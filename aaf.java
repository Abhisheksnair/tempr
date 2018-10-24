package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v4.view.o;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.text.ClipboardManager;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.j.a.a;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.protocol.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class aaf
  implements b.a
{
  private final ant a;
  protected final Activity b;
  protected MenuItem c;
  protected MenuItem d;
  protected MenuItem e;
  public MenuItem f;
  public MenuItem g;
  public MenuItem h;
  public MenuItem i;
  public MenuItem j;
  public MenuItem k;
  public MenuItem l;
  public MenuItem m;
  public MenuItem n;
  public MenuItem o;
  public MenuItem p;
  public MenuItem q;
  protected MenuItem r;
  private final pv s;
  private final aoj t;
  private final br u;
  private final ad v;
  private final e w;
  private final atv x;
  private final lt y;
  
  public aaf(Activity paramActivity, ant paramant, pv parampv, aoj paramaoj, br parambr, ad paramad, e parame, atv paramatv, lt paramlt)
  {
    this.b = paramActivity;
    this.a = paramant;
    this.s = parampv;
    this.t = paramaoj;
    this.u = parambr;
    this.v = paramad;
    this.w = parame;
    this.x = paramatv;
    this.y = paramlt;
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    paramj = qz.b(paramj);
    if (paramj != null)
    {
      paramj = this.w.d(paramj);
      this.u.a(paramj, this.b, Integer.valueOf(8), false, paramBoolean);
      return;
    }
    Log.e("conversation/call-contact/error no-resource");
  }
  
  private void d()
  {
    Object localObject1 = a();
    if ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      Log.e("conversation/copyselectedessages/nothingselected");
      return;
    }
    Object localObject2 = new HashSet();
    Object localObject3 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    ArrayList localArrayList = lt.a(((Map)localObject1).values());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.s == 0)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        if (((StringBuilder)localObject3).length() != 0) {
          localStringBuilder2.append('\n');
        }
        if (localArrayList.size() > 1)
        {
          localStringBuilder2.append('[').append(DateUtils.formatDateTime(this.b, localj.n, 655377)).append("] ");
          if (localj.e.b)
          {
            localStringBuilder2.append(this.x.l());
            localStringBuilder2.append(": ");
          }
        }
        else
        {
          ((StringBuilder)localObject3).append(localStringBuilder2);
          localStringBuilder1.append(localStringBuilder2);
          localStringBuilder1.append(localj.e());
          if (localj.P == null) {
            break label331;
          }
          ((StringBuilder)localObject3).append(yr.a(this.b, this.w, localj.e(), localj.P));
          ((Set)localObject2).addAll(localj.P);
          continue;
        }
        if (qz.e(localj.e.a)) {}
        for (localObject1 = this.w.d(localj.f);; localObject1 = this.w.d(localj.e.a))
        {
          localStringBuilder2.append(((cs)localObject1).a(this.b));
          break;
        }
        label331:
        ((StringBuilder)localObject3).append(localj.e());
      }
    }
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = this.b.getSharedPreferences("com.whatsapp_preferences", 0).edit();
    if (!((Set)localObject2).isEmpty())
    {
      ((SharedPreferences.Editor)localObject3).putString("copied_message", (String)localObject1);
      ((SharedPreferences.Editor)localObject3).putString("copied_message_without_mentions", localStringBuilder1.toString());
      ((SharedPreferences.Editor)localObject3).putString("copied_message_jids", yr.a((Collection)localObject2));
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject3).apply();
      localObject2 = (ClipboardManager)this.b.getSystemService("clipboard");
      try
      {
        ((ClipboardManager)localObject2).setText((CharSequence)localObject1);
        if (localArrayList.size() != 1) {
          break;
        }
        pv.a(this.b, 2131297167, 0);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.e("conversation/copymessage/npe");
        pv.a(this.b, 2131298123, 0);
        return;
      }
      ((SharedPreferences.Editor)localObject3).remove("copied_message");
      ((SharedPreferences.Editor)localObject3).remove("copied_message_without_mentions");
      ((SharedPreferences.Editor)localObject3).remove("copied_message_jids");
    }
    pv.a(this.b, String.format(u.a.a(2131230761, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()) }), 0);
  }
  
  public abstract Map<j.b, j> a();
  
  public void a(b paramb)
  {
    Log.i("conversation/selectionended");
  }
  
  public final boolean a(b paramb, Menu paramMenu)
  {
    this.q = paramMenu.add(0, 2131755068, 0, 2131297322).setIcon(2130840071);
    this.j = paramMenu.add(0, 2131755077, 0, 2131296303).setIcon(2130840079);
    this.k = paramMenu.add(0, 2131755083, 0, 2131297609).setIcon(2130840084);
    this.i = paramMenu.add(0, 2131755055, 0, 2131297045).setIcon(2130840063);
    this.d = paramMenu.add(0, 2131755054, 0, 2131296609).setIcon(2130840058);
    this.e = paramMenu.add(0, 2131755052, 0, 2131296590).setIcon(2130840056);
    this.f = paramMenu.add(0, 2131755076, 0, 2131297833).setIcon(2130840077);
    this.g = paramMenu.add(0, 2131755033, 0, 2131296398).setIcon(2130840054);
    this.h = paramMenu.add(0, 2131755032, 0, 2131296398).setIcon(2130840054);
    this.c = paramMenu.add(0, 2131755057, 0, 2131296564).setIcon(2130840062);
    this.l = paramMenu.add(0, 2131755029, 0, 2131296292);
    this.m = paramMenu.add(0, 2131755030, 0, 2131296296);
    this.n = paramMenu.add(0, 2131755058, 0, 2131297166);
    this.r = paramMenu.add(0, 2131755070, 0, 2131297504);
    if (br.b())
    {
      this.o = paramMenu.add(0, 2131755086, 0, 2131298134);
      this.p = paramMenu.add(0, 2131755085, 0, 2131298108);
    }
    for (;;)
    {
      o.a(this.q, 2);
      o.a(this.c, 2);
      o.a(this.d, 2);
      o.a(this.e, 2);
      o.a(this.f, 2);
      o.a(this.g, 2);
      o.a(this.h, 2);
      o.a(this.i, 2);
      o.a(this.j, 2);
      o.a(this.k, 2);
      o.a(this.l, 0);
      o.a(this.m, 0);
      o.a(this.n, 0);
      o.a(this.r, 8);
      o.a(this.o, 0);
      if (this.p != null) {
        o.a(this.p, 0);
      }
      return true;
      this.o = paramMenu.add(0, 2131755086, 0, 2131296373);
    }
  }
  
  public boolean a(b paramb, MenuItem paramMenuItem)
  {
    paramb = a();
    if ((paramb == null) || (paramb.size() == 0)) {
      return true;
    }
    Object localObject2;
    if (paramMenuItem.getItemId() == 2131755057)
    {
      localObject2 = a();
      if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
        Log.e("conversation/forwardselectedessages/nothingselected");
      }
    }
    label111:
    label180:
    label238:
    label344:
    label1280:
    for (;;)
    {
      return true;
      paramMenuItem = ((Map)localObject2).values().iterator();
      Object localObject1;
      int i1;
      if (paramMenuItem.hasNext())
      {
        localObject1 = (j)paramMenuItem.next();
        if ((((j)localObject1).N instanceof MediaData))
        {
          paramb = ((j)localObject1).b();
          if ((paramb == null) || (paramb.transferred) || (((j)localObject1).s == 4) || (((j)localObject1).s == 5) || (((j)localObject1).s == 14) || (!((j)localObject1).e.b)) {
            break label344;
          }
          Log.w("conversation/forward/fail/unfinshed-upload");
          pv.a(this.b, 2131297164, 0);
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label1280;
        }
        localObject1 = new Intent(this.b, ContactPicker.class);
        ((Intent)localObject1).putExtra("forward", true);
        paramMenuItem = null;
        HashSet localHashSet = new HashSet();
        long l1 = 0L;
        localObject2 = ((Map)localObject2).values().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          j localj = (j)((Iterator)localObject2).next();
          localHashSet.add(Integer.valueOf(Byte.valueOf(localj.s).intValue()));
          if (paramMenuItem == null) {
            paramb = localj.e.a;
          }
          for (;;)
          {
            paramMenuItem = paramb;
            if (localj.s != 3) {
              break label238;
            }
            paramMenuItem = paramb;
            if (localj.w * 1000L <= l1) {
              break label238;
            }
            l1 = localj.w * 1000L;
            paramMenuItem = paramb;
            break label238;
            paramb = null;
            break label111;
            if ((((j)localObject1).s != 8) && (((j)localObject1).s != 10)) {
              break;
            }
            Log.w("conversation/forward/fail/call");
            pv.a(this.b, 2131297163, 0);
            i1 = 0;
            break label180;
            paramb = paramMenuItem;
            if (!paramMenuItem.equals(localj.e.a)) {
              paramb = "";
            }
          }
        }
        ((Intent)localObject1).putExtra("forward_jid", paramMenuItem);
        ((Intent)localObject1).putIntegerArrayListExtra("message_types", new ArrayList(localHashSet));
        ((Intent)localObject1).putExtra("forward_video_duration", l1);
        this.b.startActivityForResult((Intent)localObject1, 2);
        break;
        if (paramMenuItem.getItemId() == 2131755054)
        {
          paramb = a();
          if ((paramb == null) || (paramb.isEmpty())) {
            Log.e("conversation/deleteselectedessages/nothingselected");
          }
          for (;;)
          {
            return true;
            d.a(this.b, 13);
          }
        }
        if (paramMenuItem.getItemId() == 2131755052)
        {
          d();
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755076)
        {
          paramb = c();
          this.t.a(this.b, paramb);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755033)
        {
          paramb = c();
          if (s.a(paramb.d, 2) >= 0) {
            pv.a(this.b.getBaseContext(), 2131296796, 0);
          }
          for (;;)
          {
            b();
            return true;
            paramMenuItem = paramb.b();
            if (paramMenuItem != null)
            {
              if (paramMenuItem.uploader != null) {
                paramMenuItem.uploader.b(paramb);
              } else {
                Log.e("conversation/oncancelmediaupload uploader is null media_wa_type:" + paramb.s + " status:" + paramb.d + " transferring:" + paramMenuItem.transferring + " transferred:" + paramMenuItem.transferred + " key:" + paramb.e);
              }
            }
            else {
              Log.e("conversation/oncancelmediaupload media_data is null media_wa_type:" + paramb.s + " status:" + paramb.d + " key:" + paramb.e);
            }
          }
        }
        if (paramMenuItem.getItemId() == 2131755032)
        {
          paramb = c();
          if (paramb != null)
          {
            paramMenuItem = paramb.b();
            if (paramMenuItem != null) {
              if (paramMenuItem.downloader != null) {
                paramMenuItem.downloader.b();
              }
            }
          }
          for (;;)
          {
            b();
            return true;
            Log.e("conversation/oncancelmediadownload downloader is null media_wa_type:" + paramb.s + " status:" + paramb.d + " transferring:" + paramMenuItem.transferring + " transferred:" + paramMenuItem.transferred + " key:" + paramb.e);
            continue;
            Log.e("conversation/oncancelmediadownload media_data is null media_wa_type:" + paramb.s + " status:" + paramb.d + " key:" + paramb.e);
            continue;
            Log.e("conversation/oncancelmediadownload message is null");
          }
        }
        if (paramMenuItem.getItemId() == 2131755055)
        {
          paramb = c();
          paramMenuItem = new Intent(this.b, MessageDetailsActivity.class);
          paramMenuItem.putExtra(MessageDetailsActivity.n, paramb.e.c);
          paramMenuItem.putExtra(MessageDetailsActivity.o, paramb.e.a);
          this.b.startActivity(paramMenuItem);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755077)
        {
          this.v.a(paramb.values(), true, true);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755083)
        {
          this.v.a(paramb.values(), false, true);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755058)
        {
          paramb = qz.b(c());
          if (paramb != null)
          {
            paramb = this.w.d(paramb);
            this.b.startActivity(Conversation.a(paramb));
            this.b.finish();
          }
          for (;;)
          {
            b();
            return true;
            Log.e("conversation/message-contact/error no-resource");
          }
        }
        if (paramMenuItem.getItemId() == 2131755086)
        {
          a(c(), false);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755085)
        {
          a(c(), true);
          b();
          return true;
        }
        if (paramMenuItem.getItemId() == 2131755070)
        {
          paramb = a();
          if ((paramb == null) || (paramb.isEmpty())) {
            Log.e("conversation/revoke/nothing-selected");
          }
          for (;;)
          {
            return true;
            d.a(this.b, 18);
          }
        }
        return false;
        i1 = 1;
      }
    }
  }
  
  public abstract void b();
  
  public boolean b(b paramb, Menu paramMenu)
  {
    this.d.setVisible(true);
    this.f.setVisible(false);
    this.g.setVisible(false);
    this.h.setVisible(false);
    this.i.setVisible(false);
    this.l.setVisible(false);
    this.m.setVisible(false);
    this.n.setVisible(false);
    this.o.setVisible(false);
    if (this.p != null) {
      this.p.setVisible(false);
    }
    this.r.setVisible(false);
    paramMenu = a();
    if ((paramMenu == null) || (paramMenu.size() == 0)) {
      return true;
    }
    boolean bool12 = aic.P;
    long l1 = this.a.b();
    Object localObject1 = paramMenu.values().iterator();
    int i3 = 1;
    int i5 = 0;
    boolean bool1 = false;
    boolean bool4 = true;
    boolean bool2 = false;
    int i2 = 0;
    int i4 = 0;
    int i6 = 0;
    int i1 = 0;
    boolean bool3 = true;
    Object localObject2;
    boolean bool5;
    label252:
    boolean bool8;
    label313:
    boolean bool9;
    label419:
    int i10;
    int i11;
    int i7;
    boolean bool7;
    boolean bool6;
    int i8;
    int i9;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      if ((!((j)localObject2).e.b) || (s.a(((j)localObject2).d, 4) >= 0))
      {
        bool5 = true;
        bool8 = bool4 & bool5;
        if ((!((j)localObject2).e.b) || (((j)localObject2).n + 512000L <= l1) || (j.b(((j)localObject2).e.a)) || (j.b(((j)localObject2).f))) {
          break label546;
        }
        bool4 = true;
        bool12 &= bool4;
        bool9 = i4 | e.b(((j)localObject2).e.a);
        if (((j)localObject2).s == 0) {
          break label621;
        }
        int i12 = 0;
        i3 = i1;
        i4 = i2;
        bool4 = bool2;
        bool5 = bool1;
        switch (((j)localObject2).s)
        {
        default: 
          bool5 = bool1;
          bool4 = bool2;
          i4 = i2;
          i3 = i1;
        case 13: 
        case 14: 
          i10 = i3;
          i11 = i6;
          i7 = i4;
          bool7 = bool4;
          bool6 = bool5;
          i8 = i5;
          i9 = i12;
          if (!m.b((j)localObject2))
          {
            i11 = 1;
            i9 = i12;
            i8 = i5;
            bool6 = bool5;
            bool7 = bool4;
            i7 = i4;
            i10 = i3;
          }
          label482:
          if ((!bool3) || (((j)localObject2).s == 15)) {
            break;
          }
        }
      }
    }
    for (bool1 = false;; bool1 = bool3)
    {
      bool3 = bool1;
      i1 = i10;
      i6 = i11;
      i4 = bool9;
      i2 = i7;
      bool2 = bool7;
      bool4 = bool8;
      bool1 = bool6;
      i5 = i8;
      i3 = i9;
      break;
      bool5 = false;
      break label252;
      label546:
      bool4 = false;
      break label313;
      bool5 = true;
      i3 = i1;
      i4 = i2;
      bool4 = bool2;
      break label419;
      i4 = 1;
      i3 = i1;
      bool4 = bool2;
      bool5 = bool1;
      break label419;
      bool4 = true;
      i3 = i1;
      i4 = i2;
      bool5 = bool1;
      break label419;
      i3 = 1;
      i4 = i2;
      bool4 = bool2;
      bool5 = bool1;
      break label419;
      label621:
      i10 = i1;
      i11 = i6;
      i7 = i2;
      bool7 = bool2;
      bool6 = bool1;
      i8 = i5;
      i9 = i3;
      if (!aa.a(((j)localObject2).e())) {
        break label482;
      }
      i8 = 1;
      i10 = i1;
      i11 = i6;
      i7 = i2;
      bool7 = bool2;
      bool6 = bool1;
      i9 = i3;
      break label482;
      localObject1 = this.c;
      boolean bool10;
      label784:
      boolean bool13;
      boolean bool11;
      if ((i5 == 0) && (!bool1) && (i2 == 0) && (!bool2) && (i6 == 0) && (i1 == 0))
      {
        bool10 = true;
        ((MenuItem)localObject1).setVisible(bool10);
        localObject1 = this.q;
        if ((paramMenu.size() != 1) || (bool1) || (i2 != 0) || (bool2) || (!bool4) || (i4 != 0) || (i1 != 0)) {
          break label1413;
        }
        bool10 = true;
        ((MenuItem)localObject1).setVisible(bool10);
        bool13 = false;
        bool11 = false;
        bool10 = false;
        if (paramMenu.size() != 1) {
          break label1600;
        }
        localObject1 = c();
        switch (((j)localObject1).s)
        {
        default: 
          label876:
          localObject2 = this.i;
          if ((((j)localObject1).e.b) && (!bool1) && (i1 == 0) && (s.a(((j)localObject1).d, 4) >= 0))
          {
            bool11 = true;
            label917:
            ((MenuItem)localObject2).setVisible(bool11);
            bool11 = bool10;
            if (!qz.e(((j)localObject1).e.a)) {
              break label1600;
            }
            if (((j)localObject1).e.b)
            {
              bool11 = bool10;
              if (((j)localObject1).d != 6) {
                break label1600;
              }
            }
            localObject1 = qz.b((j)localObject1);
            bool11 = bool10;
            if (localObject1 == null) {
              break label1600;
            }
            localObject1 = this.w.d((String)localObject1);
            if (((cs)localObject1).d == null)
            {
              this.l.setVisible(true);
              this.m.setVisible(true);
            }
            this.n.setVisible(true);
            this.n.setTitle(this.b.getResources().getString(2131297166, new Object[] { ((cs)localObject1).k() }));
            this.o.setVisible(true);
            if (this.p == null) {
              break label1561;
            }
            this.p.setVisible(true);
            this.p.setTitle(this.b.getResources().getString(2131298108, new Object[] { ((cs)localObject1).k() }));
            this.o.setTitle(this.b.getResources().getString(2131298134, new Object[] { ((cs)localObject1).k() }));
            label1172:
            if ((!bool12) || (bool3)) {
              break label1607;
            }
            this.r.setVisible(true);
            this.e.setIcon(null);
            o.a(this.e, 8);
            this.f.setIcon(null);
            o.a(this.f, 8);
            label1233:
            localObject1 = this.e;
            if ((i3 == 0) || (i5 != 0)) {
              break label1652;
            }
            bool11 = true;
            label1252:
            ((MenuItem)localObject1).setVisible(bool11);
            this.f.setVisible(bool10);
            localObject1 = paramMenu.values().iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (((j)((Iterator)localObject1).next()).T);
          }
          break;
        }
      }
      for (i2 = 0;; i2 = 1)
      {
        localObject1 = this.j;
        if ((i2 == 0) && (!bool1) && (!bool2) && (i1 == 0))
        {
          bool10 = true;
          label1344:
          ((MenuItem)localObject1).setVisible(bool10);
          localObject1 = this.k;
          if ((i2 == 0) || (bool1) || (bool2) || (i1 != 0)) {
            break label1664;
          }
        }
        label1413:
        label1561:
        label1600:
        label1607:
        label1652:
        label1664:
        for (bool10 = true;; bool10 = false)
        {
          ((MenuItem)localObject1).setVisible(bool10);
          paramb.b(String.valueOf(paramMenu.size()));
          return true;
          bool10 = false;
          break;
          bool10 = false;
          break label784;
          localObject2 = ((j)localObject1).b();
          if (!((j)localObject1).e.b)
          {
            bool11 = bool13;
            if (!((MediaData)localObject2).transferred) {}
          }
          else
          {
            bool11 = true;
          }
          bool10 = bool11;
          if (!((MediaData)localObject2).transferring) {
            break label876;
          }
          if (((j)localObject1).e.b)
          {
            this.g.setVisible(true);
            this.d.setVisible(false);
            this.c.setVisible(false);
            bool10 = bool11;
            break label876;
          }
          this.h.setVisible(true);
          this.d.setVisible(false);
          this.c.setVisible(false);
          bool10 = bool11;
          break label876;
          bool11 = false;
          break label917;
          this.o.setTitle(this.b.getResources().getString(2131296373, new Object[] { ((cs)localObject1).k() }));
          bool11 = bool10;
          bool10 = bool11;
          break label1172;
          this.e.setIcon(2130840056);
          o.a(this.e, 2);
          this.f.setIcon(2130840077);
          o.a(this.f, 2);
          break label1233;
          bool11 = false;
          break label1252;
          bool10 = false;
          break label1344;
        }
      }
    }
  }
  
  public final j c()
  {
    return (j)((Map.Entry)a().entrySet().iterator().next()).getValue();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */