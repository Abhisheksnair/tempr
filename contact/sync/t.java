package com.whatsapp.contact.sync;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
{
  final w a;
  boolean b;
  final boolean c;
  final boolean d;
  final boolean e;
  final ArrayList<b> f;
  final boolean g;
  final boolean h;
  final boolean i;
  int j;
  final List<byte[]> k;
  
  public t(a parama)
  {
    if ((!parama.f) && (!parama.h) && (!parama.g)) {
      throw new IllegalStateException("atleast one sync protocol should be enabled");
    }
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = parama.e;
    this.k = parama.i;
    this.f = new ArrayList();
    this.j = 0;
    this.g = parama.f;
    this.i = parama.h;
    this.h = parama.g;
  }
  
  public static t a(String paramString)
  {
    paramString = new JSONObject(paramString);
    Object localObject1 = new ArrayList();
    if (paramString.has("sync_jid_hash"))
    {
      localObject2 = paramString.getJSONArray("sync_jid_hash");
      int m = 0;
      while (m < ((JSONArray)localObject2).length())
      {
        ((List)localObject1).add(Base64.decode((String)((JSONArray)localObject2).get(m), 0));
        m += 1;
      }
    }
    Object localObject2 = new a(w.a(paramString.getInt("sync_type_code")));
    ((a)localObject2).b = paramString.getBoolean("sync_is_urgent");
    ((a)localObject2).c = paramString.getBoolean("sync_only_if_changed");
    ((a)localObject2).d = paramString.getBoolean("sync_only_if_registered");
    ((a)localObject2).e = paramString.getBoolean("sync_clear_whatsapp_sync_data");
    localObject1 = a.a(((a)localObject2).a(paramString.optBoolean("sync_contact", true)).b(paramString.optBoolean("sync_status", true)).c(paramString.optBoolean("sync_feature", true)), (List)localObject1).a();
    ((t)localObject1).j = paramString.getInt("sync_retry_count");
    ((t)localObject1).a(null, paramString.getBoolean("sync_should_retry"));
    return (t)localObject1;
  }
  
  private boolean d()
  {
    return !this.k.isEmpty();
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    this.f.add(new b(paramString, paramBoolean));
  }
  
  final void a(List<b> paramList)
  {
    this.f.addAll(paramList);
  }
  
  public final boolean a()
  {
    return b();
  }
  
  public final boolean a(t paramt)
  {
    if ((d()) && (paramt.d())) {}
    while (((this.a.a()) && (paramt.a.a())) || ((!this.a.a()) && (!paramt.a.a()))) {
      return true;
    }
    return false;
  }
  
  public final boolean b()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).b) {
        return true;
      }
    }
    return false;
  }
  
  public final String c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("sync_type_code", this.a.j);
    localJSONObject.put("sync_is_urgent", this.b);
    localJSONObject.put("sync_only_if_changed", this.c);
    localJSONObject.put("sync_only_if_registered", this.d);
    localJSONObject.put("sync_clear_whatsapp_sync_data", this.e);
    if (!this.k.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Base64.encodeToString((byte[])localIterator.next(), 0));
      }
      localJSONObject.put("sync_jid_hash", new JSONArray(localArrayList));
    }
    localJSONObject.put("sync_should_retry", b());
    localJSONObject.put("sync_retry_count", this.j);
    localJSONObject.put("sync_contact", this.g);
    localJSONObject.put("sync_status", this.i);
    localJSONObject.put("sync_feature", this.h);
    return localJSONObject.toString();
  }
  
  public final String toString()
  {
    Object localObject2 = new StringBuilder("SyncRequest, type: ").append(this.a).append(", isUrgent: ").append(this.b).append(", onlyIfChanged: ").append(this.c).append(", onlyIfRegistered: ").append(this.d).append(", shoudlClearWhatsappSyncData: ").append(this.e).append(", protocols=");
    if (this.g)
    {
      localObject1 = "C";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (!this.i) {
        break label193;
      }
      localObject1 = "S";
      label98:
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (!this.h) {
        break label200;
      }
    }
    label193:
    label200:
    for (Object localObject1 = "F";; localObject1 = "")
    {
      localObject1 = ((StringBuilder)localObject2).append((String)localObject1);
      if (this.k.isEmpty()) {
        break label215;
      }
      ((StringBuilder)localObject1).append(", jidHashs: [");
      localObject2 = this.k.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(Arrays.toString((byte[])((Iterator)localObject2).next())).append(",");
      }
      localObject1 = "";
      break;
      localObject1 = "";
      break label98;
    }
    ((StringBuilder)localObject1).append("]");
    label215:
    if (this.j > 0) {
      ((StringBuilder)localObject1).append(", retry: " + this.j);
    }
    ((StringBuilder)localObject1).append(", callbacks: ").append(this.f);
    return ((StringBuilder)localObject1).toString();
  }
  
  public static final class a
  {
    final w a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    boolean f = true;
    boolean g = true;
    boolean h = true;
    List<byte[]> i;
    
    public a(w paramw)
    {
      this.a = paramw;
      this.i = new ArrayList();
    }
    
    public final a a(boolean paramBoolean)
    {
      if ((!paramBoolean) && (!this.a.a())) {
        throw new IllegalStateException("disabling contact sync not allowed for delta syncs");
      }
      this.f = paramBoolean;
      return this;
    }
    
    public final a a(byte[] paramArrayOfByte)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        if (Arrays.equals((byte[])localIterator.next(), paramArrayOfByte)) {
          return this;
        }
      }
      this.i.add(paramArrayOfByte);
      return this;
    }
    
    public final t a()
    {
      return new t(this);
    }
    
    public final a b(boolean paramBoolean)
    {
      if ((!paramBoolean) && (!this.a.a())) {
        throw new IllegalStateException("disabling status sync not allowed for delta syncs");
      }
      this.h = paramBoolean;
      return this;
    }
    
    public final a c(boolean paramBoolean)
    {
      if ((!paramBoolean) && (!this.a.a())) {
        throw new IllegalStateException("disabling feature sync not allowed for delta syncs");
      }
      this.g = paramBoolean;
      return this;
    }
  }
  
  public static final class b
  {
    public final String a;
    public final boolean b;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    public final String toString()
    {
      return "id= " + this.a + ", retry= " + this.b;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */