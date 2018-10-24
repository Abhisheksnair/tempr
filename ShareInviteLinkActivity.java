package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument.Page;
import android.nfc.NfcAdapter;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.support.v4.app.m;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.google.c.g.c.b;
import com.google.c.q;
import com.whatsapp.data.cs;
import com.whatsapp.g.g;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.am;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ShareInviteLinkActivity
  extends nh
{
  String n;
  String o;
  TextView p;
  private View q;
  private View r;
  private View s;
  private View t;
  private final com.whatsapp.data.e u = com.whatsapp.data.e.a();
  private final qz v = qz.a();
  private final BroadcastReceiver w = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.nfc.action.ADAPTER_STATE_CHANGED")) {
        ShareInviteLinkActivity.this.invalidateOptionsMenu();
      }
    }
  };
  
  static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return "https://chat.whatsapp.com/" + paramString;
  }
  
  private void d(final boolean paramBoolean)
  {
    Log.i("invitelink/sendgetlink/recreate:" + paramBoolean);
    if (paramBoolean)
    {
      c(false);
      b(true);
    }
    bu.a(new AsyncTask()
    {
      String a;
      int b;
      
      private String a()
      {
        Object localObject = new alq(this);
        alr localalr = new alr(this);
        if (paramBoolean) {}
        for (localObject = ShareInviteLinkActivity.this.ay.a(ShareInviteLinkActivity.b(ShareInviteLinkActivity.this), (am)localObject, localalr); localObject == null; localObject = ShareInviteLinkActivity.this.ay.b(ShareInviteLinkActivity.b(ShareInviteLinkActivity.this), (am)localObject, localalr))
        {
          Log.e("invitelink/failed/callback is null");
          return null;
        }
        try
        {
          ((Future)localObject).get(32000L, TimeUnit.MILLISECONDS);
          return this.a;
        }
        catch (Exception localException)
        {
          Log.w("invitelink/failed/timeout");
        }
        return null;
      }
    }, new Void[0]);
  }
  
  final void c(boolean paramBoolean)
  {
    this.p.setEnabled(paramBoolean);
    this.q.setEnabled(paramBoolean);
    this.r.setEnabled(paramBoolean);
    this.s.setEnabled(paramBoolean);
    this.t.setEnabled(paramBoolean);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("invitelink/create");
    super.onCreate(paramBundle);
    ((a)a.d.a(i())).a(true);
    setContentView(2130903364);
    this.p = ((TextView)findViewById(2131756084));
    this.q = findViewById(2131756086);
    this.r = findViewById(2131756088);
    this.s = findViewById(2131756087);
    this.t = findViewById(2131756085);
    this.n = getIntent().getStringExtra("jid");
    if (this.u.c(this.n) == null)
    {
      Log.e("invitelink/sharelink/no-contact " + this.n);
      finish();
      return;
    }
    paramBundle = this.v;
    String str = this.n;
    this.o = ((String)paramBundle.c.get(str));
    if (!TextUtils.isEmpty(this.o)) {
      this.p.setText(a(this.o));
    }
    for (;;)
    {
      d(false);
      paramBundle = new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = (ClipboardManager)ShareInviteLinkActivity.this.getSystemService("clipboard");
          try
          {
            paramAnonymousView.setText(ShareInviteLinkActivity.b(ShareInviteLinkActivity.a(ShareInviteLinkActivity.this)));
            pv.a(ShareInviteLinkActivity.this, 2131297087, 0);
            return;
          }
          catch (NullPointerException paramAnonymousView)
          {
            Log.e("invitelink/copy/npe");
            pv.a(ShareInviteLinkActivity.this, 2131298123, 0);
          }
        }
      };
      this.q.setOnClickListener(paramBundle);
      this.r.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          ShareInviteLinkActivity.this.a(ShareInviteLinkActivity.a.a(ShareInviteLinkActivity.b(ShareInviteLinkActivity.this)), null);
        }
      });
      paramBundle = new at()
      {
        public final void a(View paramAnonymousView)
        {
          ShareInviteLinkActivity.c(ShareInviteLinkActivity.this);
        }
      };
      this.s.setOnClickListener(paramBundle);
      findViewById(2131756083).setOnClickListener(paramBundle);
      this.t.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          ShareInviteLinkActivity.d(ShareInviteLinkActivity.this);
        }
      });
      if (Build.VERSION.SDK_INT >= 18) {
        registerReceiver(this.w, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
      }
      b.a.a.c.a().a(this, false);
      return;
      c(false);
      this.p.setText(" \n ");
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramMenu.add(0, 2131755066, 0, getString(2131297482));
    }
    if (NfcAdapter.getDefaultAdapter(this) != null) {
      paramMenu.add(0, 2131755087, 0, getString(2131298212));
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("invitelink/destroy");
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 18) {
      unregisterReceiver(this.w);
    }
    b.a.a.c.a().a(this);
  }
  
  public void onEvent(g paramg)
  {
    runOnUiThread(alp.a(this, paramg));
  }
  
  public boolean onOptionsItemSelected(final MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131755066: 
      Log.i("invitelink/printlink/" + this.o + " jid:" + this.n);
      if ((this.n == null) || (this.o == null)) {}
      for (;;)
      {
        return true;
        try
        {
          paramMenuItem = new EnumMap(com.google.c.f.class);
          paramMenuItem = com.google.c.g.c.c.a("whatsapp://chat?code=" + this.o, com.google.c.g.a.f.a, paramMenuItem);
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.a();
            localObject = this.u.c(this.n);
            if (localObject == null) {
              Log.e("invitelink/print/no-contact");
            }
          }
        }
        catch (q paramMenuItem)
        {
          for (;;)
          {
            Log.b("invitelink/", paramMenuItem);
            paramMenuItem = null;
          }
          final Object localObject = getString(2131297845, new Object[] { ((cs)localObject).a(this) });
          ((PrintManager)getSystemService("print")).print((String)localObject, new PrintDocumentAdapter()
          {
            public PrintedPdfDocument a;
            
            public final void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
            {
              this.a = new PrintedPdfDocument(ShareInviteLinkActivity.this.getBaseContext(), paramAnonymousPrintAttributes2);
              if (paramAnonymousCancellationSignal.isCanceled())
              {
                paramAnonymousLayoutResultCallback.onLayoutCancelled();
                return;
              }
              paramAnonymousLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder("join_whatsapp_group.pdf").setContentType(0).setPageCount(1).build(), true);
            }
            
            public final void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
            {
              paramAnonymousArrayOfPageRange = this.a.startPage(0);
              paramAnonymousCancellationSignal = paramAnonymousArrayOfPageRange.getCanvas();
              Object localObject = new TextView(ShareInviteLinkActivity.this.getBaseContext());
              ((TextView)localObject).setTextColor(-16777216);
              ((TextView)localObject).setTextSize(0, paramAnonymousCancellationSignal.getWidth() / 25);
              ((TextView)localObject).setGravity(1);
              ((TextView)localObject).setText(com.whatsapp.emoji.c.a(localObject, ShareInviteLinkActivity.this.getBaseContext(), ((TextView)localObject).getPaint()));
              int i = paramAnonymousCancellationSignal.getWidth() / 8;
              ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramAnonymousCancellationSignal.getWidth() - i * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramAnonymousCancellationSignal.getHeight(), Integer.MIN_VALUE));
              ((TextView)localObject).layout(0, 0, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getMeasuredHeight());
              paramAnonymousCancellationSignal.translate(i, i / 2);
              ((TextView)localObject).draw(paramAnonymousCancellationSignal);
              paramAnonymousCancellationSignal.translate(-i, -i / 2);
              int k = paramMenuItem.b();
              int m = paramMenuItem.a();
              int j = Math.min(paramAnonymousCancellationSignal.getWidth(), paramAnonymousCancellationSignal.getHeight() - ((TextView)localObject).getMeasuredHeight());
              i = j / 8;
              j -= i * 2;
              float f1 = 1.0F * j / k;
              float f2 = j * 1.0F / m;
              paramAnonymousCancellationSignal.translate(i, ((TextView)localObject).getMeasuredHeight() + i);
              localObject = new Paint();
              ((Paint)localObject).setColor(-16777216);
              i = 0;
              while (i < k)
              {
                j = 0;
                while (j < m)
                {
                  if (paramMenuItem.a(i, j) == 1) {
                    paramAnonymousCancellationSignal.drawRect(i * f1, j * f2, (i + 1) * f1, (j + 1) * f2, (Paint)localObject);
                  }
                  j += 1;
                }
                i += 1;
              }
              this.a.finishPage(paramAnonymousArrayOfPageRange);
              try
              {
                this.a.writeTo(new FileOutputStream(paramAnonymousParcelFileDescriptor.getFileDescriptor()));
                this.a.close();
                this.a = null;
                paramAnonymousWriteResultCallback.onWriteFinished(new PageRange[] { new PageRange(0, 0) });
                return;
              }
              catch (IOException paramAnonymousArrayOfPageRange)
              {
                paramAnonymousWriteResultCallback.onWriteFailed(paramAnonymousArrayOfPageRange.toString());
                return;
              }
              finally
              {
                this.a.close();
                this.a = null;
              }
            }
          }, null);
        }
      }
    }
    Log.i("invitelink/writetag/" + this.o + " jid:" + this.n);
    if ((this.n == null) || (this.o == null)) {}
    for (;;)
    {
      return true;
      paramMenuItem = new Intent(this, WriteNfcTagActivity.class);
      paramMenuItem.putExtra("mime", "application/com.whatsapp.join");
      paramMenuItem.putExtra("data", this.o);
      startActivity(paramMenuItem);
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131755087);
    if (localMenuItem != null)
    {
      NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(this);
      if ((localNfcAdapter == null) || (!localNfcAdapter.isEnabled())) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setEnabled(bool);
      return super.onPrepareOptionsMenu(paramMenu);
    }
  }
  
  public static final class a
    extends m
  {
    private final com.whatsapp.data.e aa = com.whatsapp.data.e.a();
    
    public static a a(String paramString)
    {
      a locala = new a();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      locala.f(localBundle);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = a(2131297622, new Object[] { this.aa.d(i().getString("jid")).a(k()) });
      return new b.a(k()).b(paramBundle).a(2131297620, als.a(this)).b(2131296398, null).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ShareInviteLinkActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */