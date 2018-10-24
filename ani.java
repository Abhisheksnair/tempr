package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.provider.Telephony.Sms;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ani
{
  private static volatile ani a;
  private final Context b;
  private final pv c;
  
  private ani(Context paramContext, pv parampv)
  {
    this.b = paramContext;
    this.c = parampv;
  }
  
  public static ani a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ani(u.a(), pv.a());
      }
      return a;
    }
    finally {}
  }
  
  public static void a(Activity paramActivity, Uri paramUri, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(paramUri);
    paramUri = paramActivity.getPackageManager().queryIntentActivities(localIntent, 0);
    if (!paramUri.isEmpty())
    {
      Log.i("app/sms " + paramUri.size());
      if (Build.VERSION.SDK_INT >= 19)
      {
        String str = Telephony.Sms.getDefaultSmsPackage(paramActivity);
        if (!TextUtils.isEmpty(str)) {
          localIntent.setPackage(str);
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString)) {
          localIntent.putExtra("sms_body", paramString);
        }
        paramActivity.startActivity(localIntent);
        return;
        paramUri = ((ResolveInfo)paramUri.get(0)).activityInfo;
        localIntent.setClassName(paramUri.packageName, paramUri.name);
        continue;
        paramUri = ((ResolveInfo)paramUri.get(0)).activityInfo;
        localIntent.setClassName(paramUri.packageName, paramUri.name);
      }
    }
    Log.e("app/sms/no activities");
  }
  
  final void a(Activity paramActivity)
  {
    String str1 = paramActivity.getString(2131297982);
    Object localObject4 = paramActivity.getString(2131297981, new Object[] { "https://whatsapp.com/dl/" });
    Object localObject1 = paramActivity.getString(2131297979, new Object[] { "https://www.whatsapp.com/download/" }) + "\n\n";
    Object localObject2 = paramActivity.getString(2131297980);
    Object localObject3 = paramActivity.getPackageManager();
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject4 = new Intent("android.intent.action.VIEW").setType("vnd.android-dir/mms-sms").putExtra("sms_body", (String)localObject4);
    Intent localIntent1 = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.EMAIL", " ").putExtra("android.intent.extra.TEXT", (String)localObject1).putExtra("android.intent.extra.SUBJECT", (String)localObject2);
    localObject1 = null;
    int i = 0;
    label204:
    String str2;
    String str3;
    if (i < 2)
    {
      Intent localIntent2 = new Intent[] { localObject4, localIntent1 }[i];
      Object localObject5 = ((PackageManager)localObject3).queryIntentActivities(localIntent2, 0);
      localObject2 = localObject1;
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        do
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject2 = ((ResolveInfo)((Iterator)localObject5).next()).activityInfo;
          str2 = ((ActivityInfo)localObject2).name;
          str3 = ((ActivityInfo)localObject2).applicationInfo.packageName;
          Log.i("app/tell " + i + " | " + str3 + " | " + str2);
        } while ((str3.contains("bluetooth")) || (str3.equals("com.sec.android.app.FileTransferClient")) || (str3.equals("com.sec.android.app.FileShareClient")) || (str3.equals("com.sec.android.widgetapp.diotek.smemo")) || (str3.equals("com.threebanana.notes")) || (str3.equals("com.evernote")) || (str3.equals("com.android.apps.tag")) || (str3.equals("com.andrewshu.android.reddit")) || (str3.equals("com.dataviz.stargate")) || (str3.equals("com.dropbox.android")) || (str3.equals("com.google.zxing.client.android")) || (str3.equals("com.lg.valle.phone2chrome")) || (str3.equals("com.motorola.blur.socialshare")) || (str3.equals("com.whatsapp")) || (str3.equals("la.droid.qr")) || (str3.equals("com.google.android.apps.translate")) || (str3.equals("com.google.android.apps.docs")) || (str3.equals("com.google.android.googlequicksearchbox")) || (str3.equals("com.world.newspapers")) || (str3.equals("lysesoft.andftp")) || (str3.equals("com.klye.ime.latin")) || (str3.equals("com.ideashower.readitlater.pro")) || (str3.equals("com.springpad")) || (str3.equals("ch.teamtasks.tasks.paid")) || (str3.equals("flipboard.app")) || (str3.equals("jp.naver.cafe")) || (str3.equals("org.mozilla.firefox")) || (str3.equals("com.linkedin.android")) || (str3.equals("com.tenthbit.juliet")) || (str3.equals("com.bumptech.bumpga")));
        localObject2 = (Intent)localIntent2.clone();
        ((Intent)localObject2).setClassName(str3, str2);
        ((Intent)localObject2).setPackage(str3);
        if ((str3.equals("mobi.qiss.plurq")) || (str3.equals("com.htc.socialnetwork.plurk")) || (str3.equals("com.facebook.orca")) || (str3.equals("com.google.android.apps.plus")) || (str3.equals("com.google.android.apps.googlevoice")) || (str3.equals("com.google.android.apps.messaging")) || (str3.equals("com.thedeck.android.app")) || (str3.equals("com.twitter.android")) || (str3.equals("tw.anddev.aplurk")))
        {
          ((Intent)localObject2).removeExtra("android.intent.extra.EMAIL");
          ((Intent)localObject2).putExtra("android.intent.extra.TEXT", paramActivity.getString(2131297981, new Object[] { "https://whatsapp.com/dl/" }));
        }
      }
    }
    label760:
    label1110:
    for (;;)
    {
      if (!localHashSet.contains(str3))
      {
        Log.d("app/tell/add " + localObject2);
        localArrayList.add(localObject2);
        localHashSet.add(str3);
        if (str2.equals("com.lge.message.activity.compose.ComposeMessageActivity")) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        break label204;
        if (!str3.equals("com.facebook.katana")) {
          break label1110;
        }
        ((Intent)localObject2).putExtra("android.intent.extra.TEXT", "https://www.whatsapp.com/download/");
        break label760;
        i += 1;
        localObject1 = localObject2;
        break;
        if (localArrayList.size() == 0)
        {
          Log.w("app/tell/none");
          this.c.b(this.b, paramActivity.getString(2131296743), 0);
          return;
        }
        localObject2 = Build.MANUFACTURER.replace(' ', '_');
        localObject3 = Build.MODEL.replace(' ', '_');
        localObject2 = (String)localObject2 + "-" + (String)localObject3;
        Log.i("app/packagedintents/device " + (String)localObject2);
        if (((String)localObject2).equals("LGE-LU2300"))
        {
          if (localObject1 == null)
          {
            Log.w("app/tell/none");
            this.c.b(this.b, paramActivity.getString(2131296743), 0);
            return;
          }
          Log.i("app/tell/override");
          paramActivity.startActivity((Intent)localObject1);
          return;
        }
        localObject1 = Intent.createChooser((Intent)localArrayList.get(localArrayList.size() - 1), str1);
        if (localArrayList.size() > 1)
        {
          localArrayList.remove(localArrayList.size() - 1);
          ((Intent)localObject1).putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[localArrayList.size()]));
        }
        paramActivity.startActivity((Intent)localObject1);
        return;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ani.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */