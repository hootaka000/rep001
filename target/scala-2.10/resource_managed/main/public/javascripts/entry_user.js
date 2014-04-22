/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

$(function () {
    /**
     * 学校テンプレートの初期表示.
     */
    if ($("#foreign_school_flg").val() == "true") {
        $("#default_school_part").hide();
        $("#foreign_school_part").show();
    } else {
        $("#default_school_part").show();
        $("#foreign_school_part").hide();
    }

    /**
     * 郵便番号検索.
     */
    $("#postcode_search").click(function () {
        var uppercode = $("#postalcode_uppercode").val();
        var lowercode = $("#postalcode_lowercode").val();

        $.ajax({
            type: "POST",
            url: "/postcode/" + uppercode + "/" + lowercode,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({}),
            success: function (data) {
                if (data) {
                    // 都道府県と地名設定
                    $("#prefecture_id").val(data["prefectures"]["id"]);
                    $("#domestic_place_name").val(data["placeName"]);
                    // エラーメッセージを隠す
                    $("#code_number_error_part").hide();
                }
            },
            error: function () {
                // エラーメッセージの表示
                $("#code_number_error_part").show();
            }
        });

        return true;
    });

    /**
     * 学校区分選択.
     */
    $("#division_id").change(function () {
        var division_id = $("input[name='division']:checked").val();
        var prefecture_id = $("#school_prefecture_id").val();

        $.ajax({
            type: "POST",
            url: "/division/" + division_id,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({}),
            success: function (data) {
                if (data) {
                    $("#default_school_part").hide();
                    $("#foreign_school_part").show();
                } else {
                    $("#default_school_part").show();
                    $("#foreign_school_part").hide();
                    if (prefecture_id) {
                        set_school_list(division_id, prefecture_id);
                    }
                }
            }
        });
        return true;
    });

    /**
     * 学校区分 + 都道府県から学校名取得.
     */
    $("#school_prefecture_id").change(function () {
        var division_id = $("input[name='division']:checked").val();
        var prefecture_id = $(this).val();

        if (division_id == null) {
            return;
        }
        set_school_list(division_id, prefecture_id);

        return true;
    });

    /**
     * 学校名から学部を取得.
     */
    $("#school_list").change(function () {
        var school_id = $(this).val();

        $("#school_department_list").set_default_list();
        $("#school_subject_list").set_default_list();

        $.ajax({
            type: "POST",
            url: "/departments/" + school_id,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({}),
            success: function (data) {
                if (data) {
                    $.each(data, function (i, val) {
                        $('#school_department_list').
                            append($('<option>').attr({ value: val["id"] }).text(val["department"]));
                    });
                }
            }
        });

        return true;
    });

    /**
     * 学部から学科を取得.
     */
    $("#school_department_list").change(function () {
        var department_id = $(this).val();

        $("#school_subject_list").set_default_list();

        $.ajax({
            type: "POST",
            url: "/subjects/" + department_id,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({}),
            success: function (data) {
                if (data) {
                    $.each(data, function (i, val) {
                        $('#school_subject_list').
                            append($('<option>').attr({ value: val["id"] }).text(val["subject"]));
                    });
                }
            }
        });

        return true;
    });

    /**
     * selectbox初期化
     */
    $.extend($.fn, {
        set_default_list: function () {
            $(this).children().remove();
            $(this).append($('<option>').attr({ value: "" }).text("-"));
        }
    });

    /**
     * 学校区分 + 都道府県から学校一覧取得.
     * @param division_id 学校区分
     * @param prefecture_id 都道府県
     */
    function set_school_list(division_id, prefecture_id) {
        $("#school_list").set_default_list();
        $("#school_department_list").set_default_list();
        $("#school_subject_list").set_default_list();

        $.ajax({
            type: "POST",
            url: "/schools/" + division_id + "/" + prefecture_id,
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({}),
            success: function (data) {
                if (data) {
                    $.each(data, function (i, val) {
                        $('#school_list')
                            .append($('<option>').attr({ value: val["id"] }).text(val["name"]));
                    });
                }
            }
        });
    }
});
