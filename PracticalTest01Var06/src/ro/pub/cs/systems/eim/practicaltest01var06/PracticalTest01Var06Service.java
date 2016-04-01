package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var06Service extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ProcessingThread processingThread = null;
	 
	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
	     processingThread = new ProcessingThread();
	    processingThread.start();
	    return Service.START_REDELIVER_INTENT;
	  }
	 
	  
	  @Override
	  public void onDestroy() {
	    processingThread.stopThread();
	  }
	 

}
