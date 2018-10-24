package com.whatsapp;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Binder;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.text.TextUtils;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.o;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@TargetApi(23)
public class ContactChooserTargetService
  extends ChooserTargetService
{
  private final e a = e.a();
  private final aq b = aq.a();
  private final atv c = atv.a();
  private final o d = o.a();
  private final rh e = rh.a();
  
  public List<ChooserTarget> onGetChooserTargets(ComponentName paramComponentName, IntentFilter paramIntentFilter)
  {
    Log.i("directshare/started");
    long l = Binder.clearCallingIdentity();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    try
    {
      paramComponentName = new ArrayList();
      paramIntentFilter = this.d.a(null);
      if (paramIntentFilter.isEmpty())
      {
        localObject1 = this.c.a.getString("direct_share_contacts", null);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new ArrayList(Arrays.asList(TextUtils.split((String)localObject1, ","))).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if ((!((String)localObject2).endsWith("@s.whatsapp.net")) && (!qz.e((String)localObject2)) && (!j.b((String)localObject2))) {
              ((Iterator)localObject1).remove();
            }
          }
        }
      }
      paramIntentFilter = paramIntentFilter.iterator();
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    while (paramIntentFilter.hasNext())
    {
      localObject1 = (String)paramIntentFilter.next();
      localObject1 = this.a.c((String)localObject1);
      if (localObject1 != null) {
        paramComponentName.add(localObject1);
      }
    }
    if (paramComponentName.isEmpty())
    {
      paramIntentFilter = this.a.a(20);
      paramComponentName = paramIntentFilter;
      if (paramIntentFilter.isEmpty())
      {
        this.a.b(paramIntentFilter);
        paramComponentName = paramIntentFilter;
      }
    }
    for (;;)
    {
      int i = u.a().getResources().getDimensionPixelSize(2131362090);
      int j = u.a().getResources().getDimensionPixelSize(2131361833);
      paramIntentFilter = new ComponentName(this, ContactPicker.class);
      localObject1 = paramComponentName.iterator();
      label459:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cs)((Iterator)localObject1).next();
        if (localArrayList.size() >= 8) {
          break;
        }
        paramComponentName = ((cs)localObject2).a(i, j, true);
        if (paramComponentName == null) {}
        for (paramComponentName = Icon.createWithBitmap(cs.a(((cs)localObject2).e(), i, j));; paramComponentName = Icon.createWithBitmap(paramComponentName))
        {
          if ((TextUtils.isEmpty(((cs)localObject2).t)) || (this.b.a(((cs)localObject2).t)) || ((((cs)localObject2).d()) && (!this.e.b(((cs)localObject2).t)))) {
            break label459;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("jid", ((cs)localObject2).t);
          localArrayList.add(new ChooserTarget(((cs)localObject2).a(u.a()), paramComponentName, 1.0F, paramIntentFilter, localBundle));
          break;
        }
      }
      Binder.restoreCallingIdentity(l);
      Log.i("directshare/created " + localArrayList.size() + " targets");
      return localArrayList;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactChooserTargetService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */