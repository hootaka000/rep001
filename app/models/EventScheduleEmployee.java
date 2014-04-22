package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * イベント日程関係社員
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EventScheduleEmployee extends Model {

   public static Finder<Long, EventScheduleEmployee> finder = new Finder<Long, EventScheduleEmployee>(Long.class,
            EventScheduleEmployee.class);
   
   @Id
   public Long id;

   /**
    * -> 社員マスタ.社員ID
    */
   @ManyToOne
   @JoinColumn(name = "employee_id")
   @NotNull
   public Employee employee;

   /**
    * -> イベント日程.イベント日程ID
    */
   @ManyToOne
   @JoinColumn(name = "event_scheduleid")
   @NotNull
   public EventSchedule eventSchedule;

   @UpdatedTimestamp
   public java.util.Date updatedAt;

   @Version
   public Long lockVersion;

}
