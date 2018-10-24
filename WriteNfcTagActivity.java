package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.a;
import android.widget.TextView;
import com.whatsapp.util.Log;
import com.whatsapp.util.b;
import java.io.IOException;
import java.nio.charset.Charset;

public class WriteNfcTagActivity
  extends nh
{
  private NfcAdapter n;
  private PendingIntent o;
  private String p;
  private String q;
  private final b r = b.a();
  
  private static boolean a(NdefMessage paramNdefMessage, Tag paramTag)
  {
    int i = paramNdefMessage.toByteArray().length;
    Ndef localNdef;
    try
    {
      localNdef = Ndef.get(paramTag);
      if (localNdef == null) {
        break label64;
      }
      localNdef.connect();
      if (!localNdef.isWritable())
      {
        Log.e("writetag/failure/tag not writable");
        return false;
      }
      if (localNdef.getMaxSize() < i)
      {
        Log.e("writetag/failure/tag too small");
        return false;
      }
    }
    catch (Exception paramNdefMessage)
    {
      Log.d("writetag/failure/", paramNdefMessage);
      return false;
    }
    localNdef.writeNdefMessage(paramNdefMessage);
    return true;
    label64:
    paramTag = NdefFormatable.get(paramTag);
    if (paramTag != null) {
      try
      {
        paramTag.connect();
        paramTag.format(paramNdefMessage);
        return true;
      }
      catch (IOException paramNdefMessage)
      {
        Log.d("writetag/failure/", paramNdefMessage);
      }
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("writetag/create");
    super.onCreate(paramBundle);
    ((a)a.d.a(i())).a(true);
    paramBundle = new TextView(this);
    paramBundle.setGravity(17);
    paramBundle.setText(2131296324);
    setContentView(paramBundle);
    this.p = getIntent().getStringExtra("mime");
    this.q = getIntent().getStringExtra("data");
    this.n = NfcAdapter.getDefaultAdapter(this);
    this.o = PendingIntent.getActivity(this, 0, new Intent(this, WriteNfcTagActivity.class).addFlags(536870912), 0);
  }
  
  public void onDestroy()
  {
    Log.i("writetag/destroy");
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("android.nfc.action.TAG_DISCOVERED".equals(paramIntent.getAction()))
    {
      paramIntent = (Tag)paramIntent.getParcelableExtra("android.nfc.extra.TAG");
      if (a(new NdefMessage(new NdefRecord[] { new NdefRecord(2, this.p.getBytes(Charset.forName("US-ASCII")), null, this.q.getBytes(Charset.forName("US-ASCII"))) }), paramIntent))
      {
        Log.i("writetag/success");
        pv.a(this, 2131297089, 1);
        this.r.a(Uri.parse("android.resource://com.whatsapp/2131165190"));
        ((Vibrator)getSystemService("vibrator")).vibrate(75L);
        finish();
      }
    }
    else
    {
      return;
    }
    pv.a(this, 2131297088, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    this.n.disableForegroundDispatch(this);
  }
  
  public void onResume()
  {
    super.onResume();
    IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    this.n.enableForegroundDispatch(this, this.o, new IntentFilter[] { localIntentFilter }, null);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/WriteNfcTagActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */