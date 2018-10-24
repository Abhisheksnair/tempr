package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class abn
  implements Serializable
{
  private static ArrayList<abn> p = new ArrayList();
  private static String q;
  private static int r;
  private static int s = 0;
  private static int t = 0;
  public final String a;
  public final int b;
  public final ArrayList<PlaceInfo> c = new ArrayList();
  public String d;
  public int e;
  public Integer f;
  public String g;
  public boolean h = false;
  private final double i;
  private final double j;
  private final int k;
  private String l;
  private boolean m;
  private long n;
  private String o = null;
  private transient Location u;
  
  public abn()
  {
    this.b = 0;
    this.i = Double.MAX_VALUE;
    this.j = Double.MAX_VALUE;
    this.k = 0;
    this.a = "";
    this.h = false;
    this.o = null;
  }
  
  private abn(int paramInt1, Location paramLocation, int paramInt2, String paramString)
  {
    this.b = paramInt1;
    this.i = paramLocation.getLatitude();
    this.j = paramLocation.getLongitude();
    this.k = paramInt2;
    paramLocation = paramString;
    if (paramString == null) {
      paramLocation = "";
    }
    this.a = paramLocation;
    this.h = false;
    this.o = null;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static int a(va paramva)
  {
    int i1 = 3;
    if (t == 0)
    {
      if ((aic.z > 0) && (aic.z <= 3)) {
        break label91;
      }
      paramva = paramva.b();
      if ((paramva != null) && (paramva.length() > 1))
      {
        if (paramva.hashCode() % 3 != 0) {
          break label67;
        }
        i1 = 1;
      }
    }
    label67:
    label91:
    for (t = i1;; t = aic.z)
    {
      if (av.d()) {
        t = 1;
      }
      return t;
      if ((paramva.charAt(paramva.length() - 2) - '0') % 2 != 1) {
        break;
      }
      i1 = 2;
      break;
    }
  }
  
  private static abn a(Location paramLocation, int paramInt, String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    abn localabn = new abn(3, paramLocation, paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("ll", paramLocation.getLatitude() + "," + paramLocation.getLongitude()));
    localArrayList.add(new BasicNameValuePair("radius", Integer.toString(Math.min(paramInt, 99999))));
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.add(new BasicNameValuePair("query", paramString));
    }
    paramLocation = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramLocation, 15000);
    HttpConnectionParams.setSoTimeout(paramLocation, 30000);
    HttpProtocolParams.setUserAgent(paramLocation, ape.a());
    paramLocation = new DefaultHttpClient(paramLocation).execute(new HttpGet(aut.h + URLEncodedUtils.format(localArrayList, "UTF-8")));
    if (paramLocation == null) {
      throw new IOException("no response");
    }
    paramString = paramLocation.getFirstHeader("X-RateLimit-Limit");
    if (paramString != null) {
      Log.i("placelist/getplaces/foursquare/X-RateLimit-Limit:" + paramString.getValue());
    }
    paramString = paramLocation.getFirstHeader("X-RateLimit-Remaining");
    if (paramString != null)
    {
      paramString = paramString.getValue();
      Log.i("placelist/getplaces/foursquare/X-RateLimit-Remaining:" + paramString);
      if (TextUtils.isEmpty(paramString)) {}
    }
    try
    {
      if (Integer.parseInt(paramString) == 0)
      {
        localabn.f = Integer.valueOf(3);
        localabn.g = "error_out_of_quota";
      }
      if (paramLocation.getStatusLine().getStatusCode() == 200)
      {
        localabn.a(new JSONObject(EntityUtils.toString(paramLocation.getEntity())));
        b(localabn);
      }
      for (;;)
      {
        localabn.n = (SystemClock.uptimeMillis() - l1);
        Log.d("placelist/getplaces/foursquare/count:" + localabn.c.size());
        return localabn;
        localabn.f = Integer.valueOf(5);
        localabn.g = String.valueOf(paramLocation.getStatusLine().getStatusCode());
        Log.e("placelist/getplaces/foursquare/error-status:" + localabn.g);
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
  }
  
  private static abn a(Location paramLocation, int paramInt, String paramString1, String paramString2)
  {
    long l1 = SystemClock.uptimeMillis();
    abn localabn = new abn(2, paramLocation, paramInt, paramString1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("location", paramLocation.getLatitude() + "," + paramLocation.getLongitude()));
    localArrayList.add(new BasicNameValuePair("radius", Integer.toString(paramInt)));
    if (!TextUtils.isEmpty(paramString1)) {
      localArrayList.add(new BasicNameValuePair("keyword", paramString1));
    }
    paramLocation = u.a().getResources().getConfiguration().locale;
    if (paramLocation != null) {
      localArrayList.add(new BasicNameValuePair("language", paramLocation.getLanguage()));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(new BasicNameValuePair("pagetoken", paramString2));
    }
    paramLocation = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramLocation, 15000);
    HttpConnectionParams.setSoTimeout(paramLocation, 30000);
    HttpProtocolParams.setUserAgent(paramLocation, ape.a());
    paramLocation = new DefaultHttpClient(paramLocation).execute(new HttpGet(aut.i + URLEncodedUtils.format(localArrayList, "UTF-8")));
    if (paramLocation == null) {
      throw new IOException("no response");
    }
    if (paramLocation.getStatusLine().getStatusCode() == 200)
    {
      paramLocation = new JSONObject(EntityUtils.toString(paramLocation.getEntity()));
      paramString1 = paramLocation.getString("status");
      if ("OVER_QUERY_LIMIT".equals(paramString1))
      {
        localabn.f = Integer.valueOf(3);
        localabn.g = "error_out_of_quota";
      }
    }
    for (;;)
    {
      localabn.n = (SystemClock.uptimeMillis() - l1);
      Log.d("placelist/getplaces/google/count:" + localabn.c.size());
      return localabn;
      if ("OK".equals(paramString1))
      {
        localabn.b(paramLocation);
        if (paramLocation.has("next_page_token"))
        {
          localabn.o = paramLocation.getString("next_page_token");
          if (TextUtils.isEmpty(localabn.o)) {
            break label458;
          }
        }
        label458:
        for (boolean bool = true;; bool = false)
        {
          localabn.h = bool;
          if (!TextUtils.isEmpty(paramString2)) {
            break;
          }
          b(localabn);
          break;
        }
      }
      if (!"ZERO_RESULTS".equals(paramString1))
      {
        localabn.f = Integer.valueOf(5);
        localabn.g = paramString1;
        Log.e("placelist/getplaces/google/error-status:" + localabn.g);
        continue;
        localabn.f = Integer.valueOf(5);
        localabn.g = String.valueOf(paramLocation.getStatusLine().getStatusCode());
        Log.e("placelist/getplaces/google/error-status:" + localabn.g);
      }
    }
  }
  
  public static abn a(va paramva, Location paramLocation, int paramInt, String paramString)
  {
    str = paramString;
    if (paramString == null) {
      str = "";
    }
    Log.d("placelist/getplaces/location: " + paramLocation + "/radius:" + paramInt + "/query:" + str);
    paramString = b(paramLocation, paramInt, str);
    Object localObject;
    if (paramString != null)
    {
      paramString.m = true;
      paramString.l = q;
      paramString.e = r;
      a(paramva, paramString);
      localObject = paramString;
    }
    int[] arrayOfInt;
    int i1;
    label143:
    label180:
    label183:
    do
    {
      r += 1;
      if (((abn)localObject).b != 1) {
        ((abn)localObject).a(paramLocation);
      }
      return (abn)localObject;
      arrayOfInt = new int[3];
      arrayOfInt[0] = b(paramva);
      if (Math.random() < 0.5D) {
        break;
      }
      i1 = 1;
      i2 = 3 - i1;
      switch (arrayOfInt[0])
      {
      default: 
        i1 = 0;
        localObject = paramString;
      }
    } while (i1 >= 3);
    i2 = arrayOfInt[i1];
    s = i2;
    switch (i2)
    {
    default: 
      localObject = paramString;
    }
    for (;;)
    {
      paramString = (String)localObject;
      try
      {
        if (((abn)localObject).f == null)
        {
          ((abn)localObject).f = Integer.valueOf(1);
          paramString = (String)localObject;
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.d("placelist/getplaces/json-exception", paramString);
          paramString = new abn(i2, paramLocation, paramInt, str);
          paramString.f = Integer.valueOf(5);
          paramString.g = "error_json";
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.d("placelist/getplaces/io-exception", paramString);
          paramString = new abn(i2, paramLocation, paramInt, str);
          paramString.f = Integer.valueOf(4);
          paramString.g = "error_communication";
        }
      }
      paramString.l = q;
      paramString.e = r;
      a(paramva, paramString);
      localObject = paramString;
      if (!paramString.c.isEmpty()) {
        break;
      }
      localObject = paramString;
      if (paramString.f.intValue() == 4) {
        break;
      }
      i1 += 1;
      break label183;
      i1 = 2;
      break label143;
      arrayOfInt[i1] = 2;
      arrayOfInt[i2] = 3;
      break label180;
      arrayOfInt[i1] = 1;
      arrayOfInt[i2] = 3;
      break label180;
      arrayOfInt[i1] = 1;
      arrayOfInt[i2] = 2;
      break label180;
      localObject = b(paramLocation, paramInt, str, null);
      continue;
      localObject = a(paramLocation, paramInt, str, null);
      continue;
      localObject = a(paramLocation, paramInt, str);
    }
  }
  
  public static void a()
  {
    q = UUID.randomUUID().toString();
    r = 0;
  }
  
  private void a(Location paramLocation)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      PlaceInfo localPlaceInfo = (PlaceInfo)localIterator.next();
      localPlaceInfo.dist = localPlaceInfo.getLocation().distanceTo(paramLocation);
    }
    Collections.sort(this.c, abo.a());
  }
  
  public static void a(abn paramabn)
  {
    if (s == 0) {
      Log.d("placelist/getnextplaces/trying to get more results without initial results");
    }
    for (;;)
    {
      return;
      if (!paramabn.h)
      {
        Log.d("placelist/getnextplaces/trying to get more results when there are no more");
        return;
      }
      try
      {
        switch (paramabn.b)
        {
        case 1: 
          paramabn.h = false;
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.d("placelist/getnextplaces/json-exception", localJSONException);
        Object localObject = null;
        if (localObject == null) {
          continue;
        }
        if (((abn)localObject).b != 1) {
          ((abn)localObject).a(paramabn.c());
        }
        if (((abn)localObject).c.isEmpty()) {
          continue;
        }
        paramabn.c.addAll(((abn)localObject).c);
        paramabn.h = ((abn)localObject).h;
        paramabn.o = ((abn)localObject).o;
        return;
        if (TextUtils.isEmpty(paramabn.o))
        {
          Log.d("placelist/getnextplaces/tried to get next page without page offset");
          paramabn.h = false;
          return;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.d("placelist/getnextplaces/io-exception", localIOException);
          abn localabn = null;
          continue;
          localabn = b(paramabn.c(), paramabn.k, paramabn.a, paramabn.o);
          continue;
          if (TextUtils.isEmpty(paramabn.o))
          {
            Log.d("placelist/getnextplaces/tried to get next page without page token");
            paramabn.h = false;
            return;
          }
          localabn = a(paramabn.c(), paramabn.k, paramabn.a, paramabn.o);
        }
      }
    }
  }
  
  private static void a(va paramva, abn paramabn)
  {
    pb.a(u.a(), a(paramabn.b), a(a(paramva)), paramabn.f.intValue(), paramabn.g, paramabn.e, paramabn.m, paramabn.a, paramabn.c.size(), paramabn.n);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("response").getJSONArray("venues");
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramJSONObject.length()) {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
          PlaceInfo localPlaceInfo = new PlaceInfo();
          localPlaceInfo.fromJsonFoursquare(localJSONObject);
          this.c.add(localPlaceInfo);
          i1 += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.d("placelist/getplaces/foursquare/json-exception", localJSONException);
          }
        }
      }
    }
  }
  
  public static int b(va paramva)
  {
    if (s == 0) {
      s = a(paramva);
    }
    return s;
  }
  
  private static abn b(Location paramLocation, int paramInt, String paramString)
  {
    Iterator localIterator = p.iterator();
    while (localIterator.hasNext())
    {
      abn localabn = (abn)localIterator.next();
      if (localabn.a.equalsIgnoreCase(paramString))
      {
        double d1 = localabn.c().distanceTo(paramLocation);
        double d2 = (localabn.k + paramInt) / 2 * 0.2D;
        if ((d1 < d2) && (Math.abs(localabn.k - paramInt) < d2))
        {
          Log.d("placelist/getplaces/cached/size:" + localabn.c.size());
          return localabn;
        }
      }
    }
    return null;
  }
  
  private static abn b(Location paramLocation, int paramInt, String paramString1, String paramString2)
  {
    long l1 = SystemClock.uptimeMillis();
    abn localabn = new abn(1, paramLocation, paramInt, paramString1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("center", paramLocation.getLatitude() + "," + paramLocation.getLongitude()));
    localArrayList.add(new BasicNameValuePair("distance", Integer.toString(Math.min(paramInt, 4999))));
    if (!TextUtils.isEmpty(paramString1)) {
      localArrayList.add(new BasicNameValuePair("q", paramString1));
    }
    localArrayList.add(new BasicNameValuePair("type", "place"));
    localArrayList.add(new BasicNameValuePair("limit", Integer.toString(30)));
    localArrayList.add(new BasicNameValuePair("fields", "name,location,link,place_topics.limit(1){icon_url}"));
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(new BasicNameValuePair("after", paramString2));
    }
    paramLocation = u.a().getResources().getConfiguration().locale;
    if (paramLocation != null) {
      localArrayList.add(new BasicNameValuePair("locale", paramLocation.getLanguage()));
    }
    paramLocation = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(paramLocation, 15000);
    HttpConnectionParams.setSoTimeout(paramLocation, 30000);
    HttpProtocolParams.setUserAgent(paramLocation, ape.a());
    paramLocation = new DefaultHttpClient(paramLocation).execute(new HttpGet(aut.k + "search?" + aut.l + "&" + URLEncodedUtils.format(localArrayList, "UTF-8")));
    if (paramLocation == null) {
      throw new IOException("no response");
    }
    if (paramLocation.getStatusLine().getStatusCode() == 200)
    {
      paramLocation = new JSONObject(EntityUtils.toString(paramLocation.getEntity()));
      localabn.c(paramLocation);
      if (paramLocation.has("paging"))
      {
        paramLocation = paramLocation.getJSONObject("paging");
        if (paramLocation.has("next"))
        {
          localabn.h = true;
          localabn.o = paramLocation.getJSONObject("cursors").getString("after");
        }
      }
      if (TextUtils.isEmpty(paramString2)) {
        b(localabn);
      }
    }
    for (;;)
    {
      localabn.n = (SystemClock.uptimeMillis() - l1);
      Log.d("placelist/getplaces/facebook/count:" + localabn.c.size());
      return localabn;
      localabn.f = Integer.valueOf(5);
      localabn.g = String.valueOf(paramLocation.getStatusLine().getStatusCode());
      Log.e("placelist/getplaces/facebook/error-status:" + localabn.g);
    }
  }
  
  public static void b()
  {
    p.clear();
  }
  
  private static void b(abn paramabn)
  {
    p.add(paramabn);
    if (p.size() > 12) {
      p.remove(0);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    int i2 = 0;
    JSONArray localJSONArray = paramJSONObject.getJSONArray("results");
    int i1 = 0;
    while (i1 < localJSONArray.length())
    {
      try
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
        PlaceInfo localPlaceInfo = new PlaceInfo();
        localPlaceInfo.fromJsonGoogle(localJSONObject, false);
        if ((localPlaceInfo.icon == null) || (!localPlaceInfo.icon.endsWith("geocode-71.png"))) {
          this.c.add(localPlaceInfo);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.d("placelist/getplaces/google/json-exception", localJSONException);
        }
      }
      i1 += 1;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("html_attributions");
      if (paramJSONObject.length() > 0)
      {
        this.d = "";
        i1 = i2;
        while (i1 < paramJSONObject.length())
        {
          if (i1 > 0) {
            this.d += "<br />";
          }
          this.d += paramJSONObject.getString(i1);
          i1 += 1;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.d("placelist/getplaces/google/json-exception", paramJSONObject);
    }
  }
  
  public static void c(va paramva)
  {
    int i1 = b(paramva);
    switch (i1)
    {
    default: 
      a.d.a(false, "Invalid places source");
    }
    for (;;)
    {
      s = i1;
      return;
      i1 = 2;
      continue;
      i1 = 3;
      continue;
      i1 = 1;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("data");
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramJSONObject.length()) {
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
          PlaceInfo localPlaceInfo = new PlaceInfo();
          localPlaceInfo.fromJsonFacebook(localJSONObject);
          this.c.add(localPlaceInfo);
          i1 += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.d("placelist/getplaces/facebook/json-exception", localJSONException);
          }
        }
      }
    }
  }
  
  public final PlaceInfo b(int paramInt)
  {
    return (PlaceInfo)this.c.get(paramInt);
  }
  
  public final Location c()
  {
    if ((this.i == Double.MAX_VALUE) || (this.j == Double.MAX_VALUE)) {
      return null;
    }
    if (this.u == null)
    {
      this.u = new Location("");
      this.u.setLatitude(this.i);
      this.u.setLongitude(this.j);
    }
    return this.u;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */