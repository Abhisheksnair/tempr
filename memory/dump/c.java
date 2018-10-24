package com.whatsapp.memory.dump;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  final File a;
  String b;
  private int c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public c(File paramFile, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramFile;
    this.c = 451873;
    this.d = paramInt;
    this.b = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramString6;
  }
  
  public final String a()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("app_version_code", this.c);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("memclass", this.d);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("android_version", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("app_version_name", this.e);
      ((JSONObject)localObject).put("app", this.f);
      ((JSONObject)localObject).put("process_name", this.g);
      ((JSONObject)localObject).put("uid", this.h);
      ((JSONObject)localObject).put("dump_cause", this.i);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException) {}
    return String.format("{ 'error' : '%s' }", tmp129_126);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */