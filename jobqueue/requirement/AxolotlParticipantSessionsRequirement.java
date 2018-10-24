package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.a.c;
import com.whatsapp.data.ad;
import com.whatsapp.data.ci;
import com.whatsapp.protocol.j;
import com.whatsapp.qz;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class AxolotlParticipantSessionsRequirement
  implements b, Requirement
{
  private static final long serialVersionUID = 1L;
  private transient ad a;
  private transient c b;
  private transient ci c;
  private transient Collection<String> d;
  private transient boolean e;
  private final String groupJid;
  private final String participantHash;
  
  public AxolotlParticipantSessionsRequirement(String paramString1, String paramString2)
  {
    this.groupJid = ((String)a.d.a(paramString1));
    this.participantHash = ((String)a.d.a(paramString2));
    if ((!qz.e(paramString1)) && (!j.b(paramString1))) {
      throw new IllegalArgumentException("groupJid must be a group or broadcast list" + new StringBuilder("; groupJid=").append(this.groupJid).append("; participantHash=").append(this.participantHash).toString());
    }
  }
  
  private Collection<String> c()
  {
    if (!this.e)
    {
      this.d = this.c.a(this.groupJid, this.participantHash);
      this.e = true;
    }
    return this.d;
  }
  
  public final void a(Context paramContext)
  {
    this.a = ad.a();
    this.b = c.a();
    this.c = ci.a();
  }
  
  public final boolean a()
  {
    c();
    if (this.d == null) {
      return true;
    }
    Iterator localIterator = this.d.iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((bool) && (this.b.d(c.a(str)))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public final Collection<String> b()
  {
    c();
    if (this.d == null) {
      return Collections.emptySet();
    }
    HashSet localHashSet = new HashSet();
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.b.d(c.a(str))) {
        localHashSet.add(str);
      }
    }
    return localHashSet;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/AxolotlParticipantSessionsRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */