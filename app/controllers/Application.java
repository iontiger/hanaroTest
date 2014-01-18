package controllers;

import play.*;
import play.mvc.*;
import java.sql.*;
import models.Story;

import com.avaje.ebean.Ebean;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

	public static Result patient() {
		try {
			Connection conn = play.db.DB.getConnection("hanaro",false);
			conn.setReadOnly(true);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from TB_PATIENT_INFO where PNT_ID = 1001");
			while( rs.next() )
			{
				System.out.println( rs.getString(1)) ;
				System.out.println( rs.getString("DOCT_ID")) ;
				System.out.println( rs.getString(3)) ;
				
				Story story = new Story( rs.getString(3) );
				
				Ebean.save(story);
				

			}
			rs.close();
			stmt.close();
			
		}
		catch (Exception e){
			return ok(index.render("Error" + e.getMessage()));
		}
		return ok(index.render("Success"));
	}
  
}
