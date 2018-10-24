package com.whatsapp.gdrive;

import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.fieldstats.events.k;
import com.whatsapp.ox;
import com.whatsapp.oz;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.va;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public final class ch
{
  private static final Executor a = d.a(0, 2, TimeUnit.SECONDS, "Google Drive Write Worker #");
  
  public static int a(Context paramContext)
  {
    return b.a().a(paramContext);
  }
  
  private static int a(Double paramDouble)
  {
    if (paramDouble != null) {
      return (int)paramDouble.doubleValue();
    }
    return -1;
  }
  
  public static long a(File paramFile)
  {
    return a(paramFile, null);
  }
  
  static long a(File paramFile, a<Boolean, File> parama)
  {
    if (!paramFile.exists()) {
      return 0L;
    }
    if (!paramFile.isDirectory()) {
      return paramFile.length();
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramFile);
    long l2 = 0L;
    int i;
    long l1;
    Object localObject;
    for (;;)
    {
      if (localLinkedList.peek() != null)
      {
        paramFile = ((File)localLinkedList.poll()).listFiles();
        if (paramFile != null)
        {
          int j = paramFile.length;
          i = 0;
          l1 = l2;
          l2 = l1;
          if (i < j)
          {
            localObject = paramFile[i];
            if (!((File)localObject).exists()) {
              break label173;
            }
            if (((File)localObject).isDirectory()) {
              localLinkedList.add(localObject);
            }
          }
        }
      }
    }
    label173:
    for (;;)
    {
      i += 1;
      break;
      if ((parama == null) || (((Boolean)parama.a(localObject)).booleanValue())) {}
      for (l2 = ((File)localObject).length();; l2 = 0L)
      {
        l1 = l2 + l1;
        break;
      }
      return l2;
    }
  }
  
  static long a(File[] paramArrayOfFile)
  {
    int k = paramArrayOfFile.length;
    int i = 0;
    long l3 = 0L;
    long l1;
    label73:
    long l2;
    int j;
    Object localObject2;
    if (i < k)
    {
      Object localObject1 = paramArrayOfFile[i];
      if (!((File)localObject1).exists()) {
        l1 = 0L;
      }
      for (;;)
      {
        i += 1;
        l3 = l1 + l3;
        break;
        if (((File)localObject1).isDirectory()) {
          break label73;
        }
        if (((File)localObject1).length() > 0L) {
          l1 = 1L;
        } else {
          l1 = 0L;
        }
      }
      l2 = 0L;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localObject1);
      int m;
      do
      {
        do
        {
          l1 = l2;
          if (localLinkedList.peek() == null) {
            break;
          }
          localObject1 = ((File)localLinkedList.poll()).listFiles();
        } while (localObject1 == null);
        m = localObject1.length;
        j = 0;
        l1 = l2;
        l2 = l1;
      } while (j >= m);
      localObject2 = localObject1[j];
      if (!((File)localObject2).exists()) {
        break label221;
      }
      if (((File)localObject2).isDirectory()) {
        localLinkedList.add(localObject2);
      }
    }
    label221:
    for (;;)
    {
      j += 1;
      break;
      if (((File)localObject2).length() > 0L) {}
      for (l2 = 1L;; l2 = 0L)
      {
        l1 = l2 + l1;
        break;
      }
      return l3;
    }
  }
  
  static Dialog a(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener = ci.a(paramInt1, paramActivity, paramInt2);
    b.a locala = new b.a(paramActivity);
    locala.a(false);
    locala.b(2131297856, cj.a(paramOnCancelListener));
    switch (paramInt1)
    {
    default: 
      return e.a(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
    case 0: 
      return null;
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = 2131296924;; paramInt1 = 2131296925) {
        return locala.a(2131296927).b(paramInt1).a(2131296926, localOnClickListener).a();
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = 2131296933;; paramInt1 = 2131296934) {
        return locala.a(2131296935).b(paramInt1).a(2131296932, localOnClickListener).a();
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = 2131296928;; paramInt1 = 2131296929) {
      return locala.a(2131296931).b(paramInt1).a(2131296930, localOnClickListener).a();
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unexpected error: " + paramInt);
    case 10: 
      return "none";
    case 11: 
      return "auth-failed";
    case 12: 
      return "account-missing";
    case 13: 
      return "google-drive-full";
    case 14: 
      return "google-drive-not-reachable";
    case 15: 
      return "local-storage-full";
    case 16: 
      return "local-chat-backup-missing";
    case 17: 
      return "file-not-found";
    case 18: 
      return "base-folder-does-not-exist";
    case 19: 
      return "gdrive-servers-are-not-working-properly";
    case 20: 
      return "failed-to-authenticate-with-whatsapp-servers";
    case 21: 
      return "gps-unavailable";
    case 22: 
      return "local-gdrive-file-map-is-missing";
    case 23: 
      return "read-external-storage-permission-is-missing";
    }
    return "backup-generated-using-newer-version-of-app";
  }
  
  static String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  static String a(k paramk)
  {
    return String.format(Locale.ENGLISH, "total size:%d, chat size:%d, media size:%d, media files count:%d retryCount:%d includeVideos:%b wifi-on-finish:%b failure-stage:%d result:%d", new Object[] { Integer.valueOf(a(paramk.i)), Integer.valueOf(a(paramk.j)), Integer.valueOf(a(paramk.k)), Integer.valueOf(a(paramk.n)), paramk.d, paramk.e, paramk.f, paramk.g, paramk.a });
  }
  
  static String a(ox paramox, atu paramatu, File paramFile)
  {
    return a(paramox, paramatu, paramFile, paramFile.length());
  }
  
  static String a(ox paramox, atu paramatu, File paramFile, long paramLong)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      return null;
    }
    catch (NoSuchAlgorithmException paramox)
    {
      try
      {
        localObject = d.a(paramFile, paramLong, (MessageDigest)localObject);
        return (String)localObject;
      }
      catch (IOException localIOException)
      {
        if ((!paramox.a(paramFile)) || (paramatu.b())) {
          break label57;
        }
        throw new a(localIOException);
        Log.d("gdrive-util/get-message-digest", localIOException);
      }
      paramox = paramox;
      throw new RuntimeException(paramox);
    }
  }
  
  public static String a(ox paramox, File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    if (paramox.a(paramFile))
    {
      paramFile = str.replace(paramox.a.getAbsolutePath() + "/", "");
      if (!paramFile.startsWith("_INTERNAL_FILES_"))
      {
        paramox = paramFile;
        if (!paramFile.startsWith("_INTERNAL_DATABASES_")) {}
      }
      else
      {
        Log.e("gdrive-util/local-path-to-upload-title/malicious-file-name: " + paramFile);
        paramox = null;
      }
      return paramox;
    }
    paramox = u.a().getFilesDir().getAbsolutePath();
    if (str.startsWith(paramox)) {
      return str.replace(paramox, "_INTERNAL_FILES_");
    }
    paramox = e().getAbsolutePath();
    if (str.startsWith(paramox)) {
      return str.replace(paramox, "_INTERNAL_DATABASES_");
    }
    throw new IllegalArgumentException("Unexpected file: " + str);
  }
  
  public static String a(c paramc, ox paramox, String paramString)
  {
    if ((paramString.startsWith("_INTERNAL_FILES_")) || (paramString.startsWith("_INTERNAL_DATABASES_"))) {
      return a(paramc, paramString);
    }
    return paramox.a(paramString).getAbsolutePath();
  }
  
  private static String a(c paramc, String paramString)
  {
    if ("_INTERNAL_DATABASES_/chatsettings.db".equals(paramString)) {
      Log.i("gdrive-util/convert-upload-title-to-local-path/ignored-file-skipped-from-backup " + paramString);
    }
    label162:
    do
    {
      return null;
      Set localSet;
      try
      {
        if (paramString.startsWith("_INTERNAL_FILES_")) {}
        for (paramString = paramString.replace("_INTERNAL_FILES_", u.a().getFilesDir().getAbsolutePath());; paramString = paramString.replace("_INTERNAL_DATABASES_", e().getAbsolutePath()))
        {
          paramString = new File(paramString).getCanonicalPath();
          localSet = a(GoogleDriveService.a(u.a()));
          if (!localSet.contains(new File(paramString))) {
            break label162;
          }
          return paramString;
          if (!paramString.startsWith("_INTERNAL_DATABASES_")) {
            break;
          }
        }
        throw new IllegalArgumentException("gdrive-util/upload-title-to-local-path/unexpected-title: " + paramString);
      }
      catch (IOException paramc)
      {
        Log.d("gdrive-util/upload-title-to-local-path", paramc);
        return null;
      }
      Log.e("gdrive-util/convert-upload-title-to-local-path/local-path-unexpected/return-null " + paramString + " not in [" + TextUtils.join(" ", localSet) + "]");
    } while (((av.e()) || (!av.g())) && ((!av.f()) || (av.d())));
    paramc.a("gdrive: upload title maps to invalid local path", false, null, 7);
    return null;
  }
  
  public static String a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    char[] arrayOfChar = new char[' '];
    paramInputStream = new InputStreamReader(paramInputStream);
    StringWriter localStringWriter = new StringWriter();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (i <= 0) {
        break;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
    paramInputStream.close();
    return localStringWriter.toString();
  }
  
  static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("@");
      str = paramString;
    } while (i <= 1);
    return paramString.charAt(0) + "***" + paramString.substring(i - 1);
  }
  
  static String a(String paramString1, String paramString2, String paramString3)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).build().toString();
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return paramString;
    }
    if (paramVarArgs.length % 2 != 0) {
      Log.e("gdrive-util/append-query-parameters/odd number of params - " + paramVarArgs.length);
    }
    paramString = Uri.parse(paramString).buildUpon();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      paramString.appendQueryParameter(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return paramString.build().toString();
  }
  
  private static Set<File> a(Set<File> paramSet)
  {
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(new File(((File)paramSet.next()).getCanonicalPath()));
    }
    return localHashSet;
  }
  
  static void a() {}
  
  static void a(HttpResponse paramHttpResponse)
  {
    Log.d("gdrive-util/log-response " + paramHttpResponse.getStatusLine());
  }
  
  static void a(HttpRequestBase paramHttpRequestBase)
  {
    Log.d("gdrive-util/log-request " + paramHttpRequestBase.getRequestLine());
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (((paramActivity instanceof GoogleDriveActivity)) && (((GoogleDriveActivity)paramActivity).N)) {
      return true;
    }
    if (((paramActivity instanceof SettingsGoogleDrive)) && (((SettingsGoogleDrive)paramActivity).u)) {
      return true;
    }
    return d.a(paramActivity);
  }
  
  static boolean a(atv paramatv)
  {
    return paramatv.aa() == 1;
  }
  
  public static boolean a(va paramva, atv paramatv)
  {
    boolean bool = true;
    int i = paramatv.R();
    long l2 = paramatv.e(paramatv.ac());
    long l1 = l2;
    if (l2 > System.currentTimeMillis())
    {
      Log.i("gdrive-util/should-backup/last-backup-timestamp-is-in-future/" + l2 + " , ignoring it");
      l1 = -1L;
    }
    switch (i)
    {
    default: 
      Log.e("gdrive-util/should-backup frequency has unexpected value: " + i + ", no auto backups will be performed.");
      bool = false;
    }
    label273:
    do
    {
      for (;;)
      {
        return bool;
        Log.i("gdrive-util/should-backup/frequency/none");
        bool = false;
        continue;
        Log.i("gdrive-util/should-backup/frequency/manual");
        bool = false;
        continue;
        bool = true;
        continue;
        if (System.currentTimeMillis() - l1 >= 518400000L)
        {
          bool = true;
        }
        else
        {
          Log.i("gdrive-util/should-backup/frequency/weekly its not 7 days since the last successful backup.");
          bool = false;
        }
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1);
      int j = localCalendar.get(5);
      i = localCalendar.get(2);
      int k = localCalendar.get(1);
      if (((j != 1) && (j != 2)) || (i != 1) || (k != 2016)) {
        break label481;
      }
      try
      {
        paramva = paramva.b();
        if (paramva == null) {
          break;
        }
        l2 = Long.parseLong(paramva);
        i = (int)(l2 % 30L);
      }
      catch (NumberFormatException paramva)
      {
        for (;;)
        {
          Log.d("gdrive-util/should-backup/frequency/monthly", paramva);
          i = new Random().nextInt(30);
        }
        Log.i(String.format(Locale.ENGLISH, "gdrive-util/should-backup/frequency/monthly its only %d days since the last successful backup.", new Object[] { Long.valueOf((System.currentTimeMillis() - l1) / 86400000L) }));
        bool = false;
      }
      l2 = paramatv.a.getLong("client_version_upgrade_timestamp", 2592000000L + l1) + i * 86400000L;
      Log.i("gdrive-util/should-backup/frequency/monthly last backup was on day " + j + " of Feb 2016. Randomizing next backup to " + l2);
    } while (System.currentTimeMillis() >= l2);
    Log.i("gdrive-util/should-backup/frequency/monthly wait till timestamp " + l2 + " to perform a backup");
    l1 = i * 86400000L + l1;
    label481:
    for (;;)
    {
      if (System.currentTimeMillis() - l1 >= 2505600000L)
      {
        bool = true;
        break;
        Log.i("gdrive-util/should-backup/frequency/monthly jabber-id is null");
        i = new Random().nextInt(30);
        break label273;
      }
      break;
    }
  }
  
  static boolean a(File paramFile, oz paramoz)
  {
    try
    {
      boolean bool = paramoz.a(paramFile);
      return bool;
    }
    catch (IOException paramoz)
    {
      Log.d("gdrive-service/in-media-folder " + paramFile, paramoz);
    }
    return false;
  }
  
  static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unexpected file-status: " + paramInt);
    case 1: 
      return "local-file-does-not-exist";
    case 2: 
      return "remote-file-does-not-exist";
    case 3: 
      return "remote-file-same-as-local";
    }
    return "remote-file-different-from-local";
  }
  
  static void b() {}
  
  public static boolean b(atv paramatv)
  {
    return paramatv.aa() == 3;
  }
  
  static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unexpected-return-code: " + paramInt;
    case 0: 
      return "success";
    case 1: 
      return "service-missing";
    case 18: 
      return "service-updating";
    case 2: 
      return "service-version-update-required";
    case 3: 
      return "service-disabled";
    }
    return "service-invalid";
  }
  
  public static boolean c()
  {
    Context localContext = u.a();
    return b.a().a(localContext) == 0;
  }
  
  public static boolean c(atv paramatv)
  {
    return paramatv.aa() == 2;
  }
  
  static String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unexpected backup frequency: " + paramInt);
    case 0: 
      return "off";
    case 1: 
      return "daily";
    case 2: 
      return "weekly";
    case 3: 
      return "monthly";
    }
    return "manual";
  }
  
  public static Executor d()
  {
    return a;
  }
  
  public static boolean d(atv paramatv)
  {
    return paramatv.i(2);
  }
  
  static int e(int paramInt)
  {
    switch (paramInt)
    {
    case 22: 
    default: 
      return 2;
    case 10: 
      return 1;
    case 12: 
      return 15;
    case 11: 
      return 6;
    case 13: 
      return 3;
    case 14: 
      return 5;
    case 19: 
      return 12;
    case 16: 
      return 9;
    case 15: 
      return 8;
    case 18: 
      return 11;
    case 17: 
      return 10;
    case 21: 
      return 14;
    case 20: 
      return 13;
    }
    return 16;
  }
  
  private static File e()
  {
    return u.a().getDatabasePath("dummy.db").getParentFile();
  }
  
  public static boolean e(atv paramatv)
  {
    return paramatv.i(1);
  }
  
  public static Executor f(int paramInt)
  {
    Log.i("gdrive-util/max concurrent reads " + paramInt);
    return d.a(0, paramInt, TimeUnit.SECONDS, "Google Drive Read Worker #");
  }
  
  static boolean f(atv paramatv)
  {
    return paramatv.i(0);
  }
  
  public static abstract interface a<RETURN_TYPE, ARGUMENT_TYPE>
  {
    public abstract RETURN_TYPE a(ARGUMENT_TYPE paramARGUMENT_TYPE);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */