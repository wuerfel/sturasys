package models.forms;

import models.DbData;

public interface FormData
{
	public DbData getAsDbData();
	
	public String printOut();
}
