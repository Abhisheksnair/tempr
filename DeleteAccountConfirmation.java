package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.view.MenuItem;
import android.view.View;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.registration.EULA;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeleteAccountConfirmation
  extends nh
{
  final Handler n = new a(this);
  private final bb o = bb.a();
  private final mg p = mg.a();
  private final mg.a q = new mg.a()
  {
    public final void a()
    {
      DeleteAccountConfirmation.a(DeleteAccountConfirmation.this).removeMessages(0);
    }
    
    public final void b()
    {
      d.b(DeleteAccountConfirmation.this, 1);
      Intent localIntent = new Intent(DeleteAccountConfirmation.this, EULA.class);
      if (Build.VERSION.SDK_INT >= 11) {
        localIntent.addFlags(32768);
      }
      DeleteAccountConfirmation.this.startActivity(localIntent);
      DeleteAccountConfirmation.this.finish();
    }
  };
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("deleteaccountconfirm/create");
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903189, null, false));
    findViewById(2131755686).setOnClickListener(mo.a(this));
    if ((!GoogleDriveService.c()) || (this.aQ.ac() == null)) {
      findViewById(2131755685).setVisibility(8);
    }
    paramBundle = this.p;
    mg.a locala = this.q;
    paramBundle.b.add(locala);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 1: 
      ProgressDialog localProgressDialog = new ProgressDialog(this);
      localProgressDialog.setMessage(getString(2131296623));
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.setCancelable(false);
      return localProgressDialog;
    case 2: 
      return new b.a(this).b(getString(2131297527, new Object[] { getString(2131296506) })).a(2131297331, mp.a(this)).a();
    }
    return new b.a(this).b(2131296615).a(2131297331, mq.a(this)).a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mg localmg = this.p;
    mg.a locala = this.q;
    localmg.b.remove(locala);
    this.n.removeMessages(0);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = this.o.c();
    Log.d("deleteaccountconfirm/resume " + i);
    if ((!this.o.b()) && (i != 6))
    {
      Log.e("deleteaccountconfirm/wrong-state bounce to main " + i);
      startActivity(new Intent(this, Main.class));
      finish();
    }
  }
  
  static final class a
    extends Handler
  {
    private final WeakReference<DeleteAccountConfirmation> a;
    private final bb b = bb.a();
    
    public a(DeleteAccountConfirmation paramDeleteAccountConfirmation)
    {
      super();
      this.a = new WeakReference(paramDeleteAccountConfirmation);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      DeleteAccountConfirmation localDeleteAccountConfirmation = (DeleteAccountConfirmation)this.a.get();
      if (localDeleteAccountConfirmation == null)
      {
        Log.w("delete account confirmation was garbage collected with messages still enqueued");
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Log.i("deleteacctconfirm/timeout/expired");
      d.b(localDeleteAccountConfirmation, 1);
      if (this.b.c() == 0)
      {
        Log.d("deleteacctconfirm/go-to-eula");
        return;
      }
      Log.w("deleteacctconfirm/dialog-delete-failed");
      d.a(localDeleteAccountConfirmation, 3);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DeleteAccountConfirmation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */