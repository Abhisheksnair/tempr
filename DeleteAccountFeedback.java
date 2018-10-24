package com.whatsapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.support.v7.widget.ActionMenuView.e;
import android.support.v7.widget.at;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.util.az;

public class DeleteAccountFeedback
  extends nh
{
  boolean n = false;
  at o;
  private int p = 0;
  private EditText q;
  private android.support.v4.app.m r;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    final Object localObject = i();
    if (localObject != null) {
      ((a)localObject).a(true);
    }
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903190, null, false));
    this.q = ((EditText)findViewById(2131755689));
    localObject = (TextView)findViewById(2131755688);
    ((TextView)localObject).setBackgroundDrawable(new az(android.support.v7.widget.m.a().a(this)));
    String[] arrayOfString = getResources().getStringArray(2131689480);
    if (paramBundle != null)
    {
      this.p = paramBundle.getInt("delete_reason_selected", 0);
      if ((this.p < 0) || (this.p >= arrayOfString.length)) {
        this.p = 0;
      }
      this.n = paramBundle.getBoolean("delete_reason_showing", false);
      paramBundle = this.q;
      if (this.p != 3) {
        break label224;
      }
    }
    label224:
    for (int i = 2131296611;; i = 2131296610)
    {
      paramBundle.setHint(i);
      ((TextView)localObject).setText(arrayOfString[this.p]);
      this.o = new at(this, findViewById(2131755687));
      i = 0;
      while (i < arrayOfString.length)
      {
        this.o.a().add(0, i, 0, arrayOfString[i]);
        i += 1;
      }
    }
    this.o.a(new mr(this));
    this.o.a(new ActionMenuView.e()
    {
      public final boolean a(MenuItem paramAnonymousMenuItem)
      {
        DeleteAccountFeedback.a(DeleteAccountFeedback.this, paramAnonymousMenuItem.getItemId());
        localObject.setText(paramAnonymousMenuItem.getTitle());
        paramAnonymousMenuItem = DeleteAccountFeedback.b(DeleteAccountFeedback.this);
        if (DeleteAccountFeedback.a(DeleteAccountFeedback.this) == 3) {}
        for (int i = 2131296611;; i = 2131296610)
        {
          paramAnonymousMenuItem.setHint(i);
          return false;
        }
      }
    });
    ((TextView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        DeleteAccountFeedback.b(DeleteAccountFeedback.this).clearFocus();
        ((InputMethodManager)DeleteAccountFeedback.this.getSystemService("input_method")).hideSoftInputFromWindow(DeleteAccountFeedback.this.getCurrentFocus().getWindowToken(), 0);
        DeleteAccountFeedback.c(DeleteAccountFeedback.this);
        DeleteAccountFeedback.d(DeleteAccountFeedback.this).b();
      }
    });
    ((Button)findViewById(2131755690)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((DeleteAccountFeedback.b(DeleteAccountFeedback.this).getText().length() > 0) && (DeleteAccountFeedback.b(DeleteAccountFeedback.this).getText().length() < 5))
        {
          pv.a(DeleteAccountFeedback.this.getBaseContext(), DeleteAccountFeedback.this.getString(2131296655), 0);
          return;
        }
        if ((DeleteAccountFeedback.a(DeleteAccountFeedback.this) <= 0) || (DeleteAccountFeedback.a(DeleteAccountFeedback.this) >= DeleteAccountFeedback.this.getResources().getStringArray(2131689480).length - 1)) {}
        for (int i = -1; DeleteAccountFeedback.a(DeleteAccountFeedback.this) == 2; i = DeleteAccountFeedback.a(DeleteAccountFeedback.this) - 1)
        {
          DeleteAccountFeedback.a(DeleteAccountFeedback.this, DeleteAccountFeedback.a.a(i, DeleteAccountFeedback.b(DeleteAccountFeedback.this).getText().toString()));
          DeleteAccountFeedback.e(DeleteAccountFeedback.this).a(DeleteAccountFeedback.this.j_(), null);
          return;
        }
        paramAnonymousView = new Intent(DeleteAccountFeedback.this, DeleteAccountConfirmation.class);
        paramAnonymousView.putExtra("deleteReason", i);
        paramAnonymousView.putExtra("additionalComments", DeleteAccountFeedback.b(DeleteAccountFeedback.this).getText().toString());
        DeleteAccountFeedback.this.startActivity(paramAnonymousView);
      }
    });
    this.an.post(ms.a(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("delete_reason_selected", this.p);
    paramBundle.putBoolean("delete_reason_showing", this.n);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.o != null)
    {
      this.o.a(null);
      this.o.c();
    }
  }
  
  public static final class a
    extends android.support.v4.app.m
  {
    public final Dialog c(Bundle paramBundle)
    {
      int i = i().getInt("deleteReason", -1);
      paramBundle = i().getString("additionalComments");
      b.a locala = new b.a(l());
      locala.b(a(2131296612, new Object[] { a(2131297713) })).a(a(2131297713), mt.a(this)).b(a(2131297721), mu.a(this, i, paramBundle));
      return locala.a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DeleteAccountFeedback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */