package com.whatsapp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import com.whatsapp.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class auf
{
  static final Pattern n = Pattern.compile("(?i)\\bcharset=\\s*\"?([^\\s;\"]*)", 34);
  private static final Pattern o = Pattern.compile("<head[^>]*>(.*)</head>", 34);
  private static final Pattern p = Pattern.compile("<title[^>]*>(.*)</title>", 34);
  private static final Pattern q = Pattern.compile("<meta([^>]+?)/?>", 34);
  private static final Pattern r = Pattern.compile("<link([^>]+?)/?>", 34);
  private static final Pattern s = Pattern.compile("\\s*([^=]+)\\s*=\\s*(?:\"([^\"]+)\"|\\'([^\\']+)\\')", 34);
  String a;
  String b;
  String c;
  String d;
  String e;
  a f;
  byte[] g;
  long h;
  long i;
  long j;
  long k;
  int l;
  int m;
  
  public auf(String paramString)
  {
    this.a = paramString;
  }
  
  private static a a(String paramString)
  {
    try
    {
      HttpURLConnection localHttpURLConnection = b(new URL(paramString));
      if (localHttpURLConnection != null)
      {
        String str = localHttpURLConnection.getHeaderField("Content-Type");
        if (str.equals("video/mp4"))
        {
          paramString = new a(paramString, localHttpURLConnection.getContentLength(), str);
          return paramString;
        }
      }
    }
    catch (URISyntaxException paramString)
    {
      Log.d("IOException", paramString);
      return null;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  private static a a(String paramString1, String paramString2, int paramInt)
  {
    if ((!"image/gif".equals(paramString2)) || (paramInt == -1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      Object localObject2 = paramString1;
      Object localObject1;
      if (paramString1.endsWith("giphy.gif"))
      {
        localObject2 = paramString1;
        localObject1 = paramString1;
      }
      try
      {
        if (new URI(paramString1).getHost().contains("giphy.com"))
        {
          localObject1 = paramString1;
          localObject2 = paramString1.substring(0, paramString1.length() - 9) + "200.mp4";
          localObject1 = localObject2;
          paramString1 = a((String)localObject2);
          localObject1 = paramString1;
          paramString1 = (String)localObject1;
          if (localObject1 != null) {
            continue;
          }
        }
      }
      catch (URISyntaxException paramString1)
      {
        for (;;)
        {
          Log.c("Unable to create uri", paramString1);
          localObject2 = localObject1;
        }
      }
    }
    return new a((String)localObject2, paramInt, paramString2);
  }
  
  private static a a(Map<String, String> paramMap, String... paramVarArgs)
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject;
      if (i1 < 5)
      {
        localObject = (String)paramMap.get(paramVarArgs[i1]);
        if ((localObject == null) || (!Patterns.WEB_URL.matcher((CharSequence)localObject).matches())) {}
      }
      try
      {
        HttpURLConnection localHttpURLConnection = b(new URL((String)localObject));
        if (localHttpURLConnection != null)
        {
          localObject = a((String)localObject, localHttpURLConnection.getHeaderField("Content-Type"), localHttpURLConnection.getContentLength());
          if (localObject != null) {
            return (a)localObject;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        Log.e(localURISyntaxException);
        i1 += 1;
        continue;
        return null;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  private static String a(HashMap<String, String> paramHashMap, String... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)paramHashMap.get(paramVarArgs[i1]);
      if (str != null) {
        return str.trim();
      }
      i1 += 1;
    }
    return null;
  }
  
  static HttpURLConnection a(URL paramURL)
  {
    Object localObject3 = b(paramURL);
    Object localObject1;
    if (localObject3 == null) {
      localObject1 = null;
    }
    do
    {
      int i2;
      do
      {
        for (;;)
        {
          return (HttpURLConnection)localObject1;
          ((HttpURLConnection)localObject3).setInstanceFollowRedirects(true);
          try
          {
            ((HttpURLConnection)localObject3).connect();
            i1 = ((HttpURLConnection)localObject3).getResponseCode();
            Log.d("webpageinfo/response:" + i1);
            localObject1 = localObject3;
            if (i1 / 100 != 2) {
              if (i1 / 100 != 3)
              {
                ((HttpURLConnection)localObject3).disconnect();
                return null;
              }
            }
          }
          catch (ProtocolException localProtocolException)
          {
            while (localProtocolException.toString().contains("Too many redirects")) {
              i1 = 303;
            }
            throw localProtocolException;
          }
        }
        ((HttpURLConnection)localObject3).disconnect();
        paramURL = b(paramURL);
        if (paramURL == null) {
          return null;
        }
        paramURL.setInstanceFollowRedirects(false);
        paramURL.connect();
        i2 = paramURL.getResponseCode();
        Log.d("webpageinfo/response:" + i2);
        int i1 = 0;
        localObject2 = "";
        for (;;)
        {
          localObject3 = paramURL;
          if (i2 / 100 != 3) {
            break;
          }
          localObject3 = paramURL;
          if (i1 >= 20) {
            break;
          }
          String str = paramURL.getHeaderField("Location");
          Log.d("webpageinfo/redirect url:" + str);
          localObject3 = paramURL;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          Object localObject4 = paramURL.getHeaderField("Set-Cookie");
          localObject3 = localObject4;
          if (localObject4 != null)
          {
            String[] arrayOfString = ((String)localObject4).split(";");
            localObject3 = localObject4;
            if (arrayOfString.length > 0) {
              localObject3 = arrayOfString[0];
            }
          }
          localObject4 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject4 = (String)localObject2 + "; ";
          }
          localObject2 = (String)localObject4 + (String)localObject3;
          paramURL.disconnect();
          paramURL = b(new URL(str));
          localObject3 = paramURL;
          if (paramURL == null) {
            break;
          }
          paramURL.setInstanceFollowRedirects(false);
          paramURL.setRequestProperty("Cookie", (String)localObject2);
          paramURL.connect();
          i2 = paramURL.getResponseCode();
          Log.d("webpageinfo/response:" + i2);
          i1 += 1;
        }
        localObject2 = localObject3;
      } while (i2 / 100 == 2);
      Object localObject2 = localObject3;
    } while (localObject3 == null);
    ((HttpURLConnection)localObject3).disconnect();
    return null;
  }
  
  static byte[] a(URLConnection paramURLConnection)
  {
    paramURLConnection = paramURLConnection.getInputStream();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    int i1 = 0;
    String str;
    do
    {
      int i2 = paramURLConnection.read(arrayOfByte, 0, 1024);
      if (i2 == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i2);
      i1 += i2;
      if (i1 > 65536) {
        break;
      }
      str = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    } while (!o.matcher(str).find());
    paramURLConnection.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static HttpURLConnection b(URL paramURL)
  {
    URLConnection localURLConnection = paramURL.openConnection();
    if (!(localURLConnection instanceof HttpURLConnection))
    {
      Log.d("webpageinfo/not http " + paramURL);
      return null;
    }
    paramURL = (HttpURLConnection)localURLConnection;
    paramURL.setConnectTimeout(10000);
    paramURL.setReadTimeout(10000);
    paramURL.setRequestProperty("User-Agent", "WhatsApp/" + au.d().replace(' ', '_') + " A");
    return paramURL;
  }
  
  private static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Matcher localMatcher = s.matcher(paramString);
    while (localMatcher.find())
    {
      String str2 = localMatcher.group(1);
      String str1 = localMatcher.group(2);
      paramString = str1;
      if (str1 == null) {
        paramString = localMatcher.group(3);
      }
      localHashMap.put(str2, paramString);
    }
    return localHashMap;
  }
  
  final String a(URL paramURL, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Log.d("webpageinfo/html:" + paramString1);
    Object localObject = o.matcher(paramString1);
    String str1 = paramString1;
    if (((Matcher)localObject).find()) {
      str1 = ((Matcher)localObject).group(1);
    }
    paramString1 = null;
    HashMap localHashMap1 = new HashMap();
    Matcher localMatcher = q.matcher(str1);
    HashMap localHashMap2;
    if (localMatcher.find())
    {
      localHashMap2 = b(localMatcher.group(1));
      if (TextUtils.isEmpty(paramString2))
      {
        localObject = (String)localHashMap2.get("charset");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          Log.d("webpageinfo/charset:" + (String)localObject);
          paramString1 = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1059;
          }
          paramString1 = (String)localObject;
          if ("UTF-8".equalsIgnoreCase((String)localObject)) {
            break label1059;
          }
          b();
          return (String)localObject;
        }
        if ("Content-Type".equalsIgnoreCase((String)localHashMap2.get("http-equiv")))
        {
          localObject = (String)localHashMap2.get("content");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = n.matcher((CharSequence)localObject);
            if (((Matcher)localObject).find())
            {
              localObject = ((Matcher)localObject).group(1).trim().toUpperCase();
              Log.d("webpageinfo/charset:" + (String)localObject);
              paramString1 = (String)localObject;
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1059;
              }
              paramString1 = (String)localObject;
              if ("UTF-8".equalsIgnoreCase((String)localObject)) {
                break label1059;
              }
              b();
              return (String)localObject;
            }
          }
        }
      }
    }
    label952:
    label1059:
    for (;;)
    {
      String str2 = (String)localHashMap2.get("property");
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        str2 = (String)localHashMap2.get("name");
        localObject = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject = (String)localHashMap2.get("itemprop");
        }
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("og:image".equals(localObject)) || ("image".equals(localObject)) || ("thumbnail".equals(localObject)) || ("twitter:image".equals(localObject)) || ("og:title".equals(localObject)) || ("title".equals(localObject)) || ("twitter:title".equals(localObject)) || ("og:description".equals(localObject)) || ("description".equals(localObject)) || ("twitter:description".equals(localObject)) || ("og:url".equals(localObject)) || ("twitter:url".equals(localObject))))
        {
          str2 = (String)localHashMap2.get("content");
          if (str2 != null) {
            localHashMap1.put(localObject, Html.fromHtml(str2).toString());
          }
        }
        break;
        paramString2 = a(paramURL.toString(), paramString3, paramInt);
        if (paramString2 != null) {}
        for (;;)
        {
          this.f = paramString2;
          this.e = a(localHashMap1, new String[] { "og:image", "twitter:image", "image", "thumbnail" });
          this.b = a(localHashMap1, new String[] { "og:title", "twitter:title", "title" });
          this.c = a(localHashMap1, new String[] { "og:description", "twitter:description", "description" });
          this.d = a(localHashMap1, new String[] { "og:url", "twitter:url" });
          if (!TextUtils.isEmpty(this.e)) {
            break;
          }
          paramString2 = r.matcher(str1);
          while (paramString2.find())
          {
            paramString3 = b(paramString2.group(1));
            localObject = (String)paramString3.get("rel");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("icon".equals(localObject)) || ("image_src".equals(localObject)) || ("apple-touch-icon-precomposed".equals(localObject)) || ("apple-touch-icon".equals(localObject)))) {
              this.e = ((String)paramString3.get("href"));
            }
          }
          paramString2 = a(localHashMap1, new String[] { "og:url", "twitter:url", "og:image", "twitter:image", "image" });
        }
        if ((!TextUtils.isEmpty(this.e)) && (!this.e.startsWith("http")))
        {
          if (!this.e.startsWith("//")) {
            break label952;
          }
          this.e = (paramURL.getProtocol() + ":" + this.e);
        }
        while (TextUtils.isEmpty(this.b))
        {
          paramURL = p.matcher(str1);
          while (paramURL.find()) {
            this.b = paramURL.group(1).trim();
          }
          try
          {
            this.e = new URI(paramURL.getProtocol(), paramURL.getUserInfo(), paramURL.getHost(), paramURL.getPort(), this.e, null, null).toURL().toString();
          }
          catch (URISyntaxException paramURL) {}catch (MalformedURLException paramURL)
          {
            paramURL.printStackTrace();
          }
        }
        if (!TextUtils.isEmpty(this.b)) {
          this.b = Html.fromHtml(this.b).toString();
        }
        if (!TextUtils.isEmpty(this.c)) {
          this.c = Html.fromHtml(this.c).toString();
        }
        return paramString1;
      }
    }
  }
  
  public final void a()
  {
    this.j = 0L;
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    Object localObject1 = new URL(this.e);
    if (this.e.equals(URLDecoder.decode(this.e, "UTF-8"))) {
      localObject1 = new URI(((URL)localObject1).getProtocol(), ((URL)localObject1).getUserInfo(), ((URL)localObject1).getHost(), ((URL)localObject1).getPort(), ((URL)localObject1).getPath(), ((URL)localObject1).getQuery(), ((URL)localObject1).getRef()).toURL();
    }
    for (;;)
    {
      localObject1 = b((URL)localObject1);
      if (localObject1 == null) {
        break;
      }
      ((URLConnection)localObject1).setConnectTimeout(10000);
      ((URLConnection)localObject1).setReadTimeout(20000);
      localObject1 = ((URLConnection)localObject1).getInputStream();
      Object localObject2 = new ByteArrayOutputStream();
      Object localObject3 = new byte['Ѐ'];
      int i1 = 0;
      int i2;
      do
      {
        i2 = ((InputStream)localObject1).read((byte[])localObject3, 0, 1024);
        if (i2 == -1) {
          break;
        }
        ((ByteArrayOutputStream)localObject2).write((byte[])localObject3, 0, i2);
        i2 = i1 + i2;
        i1 = i2;
      } while (i2 <= 307200);
      this.k = Long.MAX_VALUE;
      this.j = (System.currentTimeMillis() - l1);
      throw new IOException("image too large " + this.e);
      ((ByteArrayOutputStream)localObject2).close();
      ((InputStream)localObject1).close();
      localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPurgeable = true;
      ((BitmapFactory.Options)localObject2).inInputShareable = true;
      ((BitmapFactory.Options)localObject2).inDither = true;
      ((BitmapFactory.Options)localObject2).inScaled = false;
      ((BitmapFactory.Options)localObject2).inPreferQualityOverSpeed = true;
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      this.l = ((BitmapFactory.Options)localObject2).outWidth;
      this.m = ((BitmapFactory.Options)localObject2).outHeight;
      if ((this.l >= 100) && (this.m >= 100))
      {
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = (Math.min(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight) / 140);
        localObject3 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
        if (localObject3 != null)
        {
          i1 = Math.min(140, Math.min(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()));
          i2 = Math.min(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          localObject2 = ((Bitmap)localObject3).getConfig();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Bitmap.Config.ARGB_8888;
          }
          localObject1 = Bitmap.createBitmap(i1, i1, (Bitmap.Config)localObject1);
          localObject2 = new Canvas((Bitmap)localObject1);
          Paint localPaint = new Paint();
          localPaint.setAntiAlias(true);
          localPaint.setFilterBitmap(true);
          ((Canvas)localObject2).drawColor(-1);
          ((Canvas)localObject2).drawBitmap((Bitmap)localObject3, new Rect((((Bitmap)localObject3).getWidth() - i2) / 2, (((Bitmap)localObject3).getHeight() - i2) / 2, (((Bitmap)localObject3).getWidth() + i2) / 2, (i2 + ((Bitmap)localObject3).getHeight()) / 2), new Rect(0, 0, i1, i1), localPaint);
          ((Bitmap)localObject3).recycle();
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject2);
          this.g = ((ByteArrayOutputStream)localObject2).toByteArray();
          this.k = this.g.length;
        }
      }
      this.j = (System.currentTimeMillis() - l1);
      return;
    }
  }
  
  public final void b()
  {
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
  }
  
  public final boolean c()
  {
    return (!TextUtils.isEmpty(this.b)) || (!TextUtils.isEmpty(this.c)) || ((Build.VERSION.SDK_INT >= 16) && (this.f != null) && (("image/gif".equals(this.f.c)) || ("video/mp4".equals(this.f.c))));
  }
  
  static final class a
  {
    public final String a;
    public final int b;
    public final String c;
    
    a(String paramString1, int paramInt, String paramString2)
    {
      this.a = paramString1;
      this.b = paramInt;
      this.c = paramString2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/auf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */