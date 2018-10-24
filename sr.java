package com.whatsapp;

import android.os.Message;
import android.util.Pair;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class sr
{
  public static final sr a = new sr();
  final HashMap<String, Message> b = new HashMap();
  public final Set<j.b> c = new HashSet();
  private final ArrayList<Pair<String, Message>> d = new ArrayList();
  
  public static sr a()
  {
    return a;
  }
  
  public final void a(a parama)
  {
    synchronized (this.d)
    {
      Log.i("in-flight-messages/for-each/send-pending-requests: " + this.d.size());
      Iterator localIterator = this.d.iterator();
      if (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        parama.a((String)localPair.first, (Message)localPair.second);
      }
    }
    this.d.clear();
  }
  
  public final void a(String paramString, Message paramMessage)
  {
    synchronized (this.d)
    {
      this.d.add(Pair.create(paramString, paramMessage));
      return;
    }
  }
  
  public final boolean a(j.b paramb)
  {
    return this.c.remove(paramb);
  }
  
  public final void b(a parama)
  {
    synchronized (this.b)
    {
      Log.i("xmpp/service/ready/send thumb requests: " + this.b.size());
      Iterator localIterator = this.b.values().iterator();
      if (localIterator.hasNext()) {
        parama.a(null, (Message)localIterator.next());
      }
    }
    this.b.clear();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, Message paramMessage);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/sr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */