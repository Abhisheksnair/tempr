package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.d;
import com.whatsapp.data.e;
import com.whatsapp.emoji.c;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.bh;
import com.whatsapp.util.x;
import java.util.Collection;
import java.util.List;

public class ip
  extends hy
{
  final TextView O;
  View.OnClickListener P = iq.a(this);
  
  ip(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    setClickable(false);
    setLongClickable(false);
    this.O = ((TextView)findViewById(2131755493));
    q();
  }
  
  static String a(pv parampv, cs paramcs)
  {
    String str = paramcs.a(u.a());
    if (str == null) {
      paramcs = null;
    }
    do
    {
      return paramcs;
      paramcs = str;
    } while (parampv.d());
    return "‏" + str;
  }
  
  public static String a(pv parampv, va paramva, d paramd, e parame, aus paramaus, rh paramrh, j paramj)
  {
    cs localcs;
    String str;
    if (!TextUtils.isEmpty(paramj.f))
    {
      localcs = parame.d(paramj.f);
      str = a(parampv, localcs);
    }
    for (;;)
    {
      switch ((int)paramj.t)
      {
      case 2: 
      case 3: 
      default: 
        return "";
      case 1: 
        if (paramj.e() == null) {
          break;
        }
      }
      for (paramrh = paramj.e().split("\n");; paramrh = null)
      {
        if ((paramrh != null) && (paramrh.length == 2) && ((paramj.f == null) || ((paramrh[0].endsWith("@s.whatsapp.net")) && (paramrh[1].lastIndexOf("\"") > paramrh[1].indexOf("\"")))))
        {
          parampv = a(parampv, parame.d(paramrh[0]));
          i = paramrh[1].indexOf("\"");
          j = paramrh[1].lastIndexOf("\"");
          if (j <= i) {
            Log.e("divider_row/rr=" + paramj.f + " jid=" + paramrh[0] + " s=" + paramrh[1]);
          }
          return x.a(u.a(), paramd, paramaus, paramrh[0], 2131297013, new Object[] { parampv, android.support.v4.e.a.a().a(paramrh[1].substring(i + 1, j)) });
        }
        if (!paramva.a(paramj.f))
        {
          if ((paramj.N instanceof String)) {}
          for (parampv = (String)paramj.N; !TextUtils.isEmpty(parampv); parampv = null) {
            return x.a(u.a(), paramd, paramaus, paramj.f, 2131297014, new Object[] { str, android.support.v4.e.a.a().a(parampv), android.support.v4.e.a.a().a(paramj.e()) });
          }
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297013, new Object[] { str, android.support.v4.e.a.a().a(paramj.e()) });
        }
        int i = paramj.e().indexOf("\"");
        int j = paramj.e().lastIndexOf("\"");
        if ((i == 0) && (j == paramj.e().length() - 1) && (i != j))
        {
          parampv = paramj.e().substring(i + 1, j);
          return u.a().getString(2131297015, new Object[] { android.support.v4.e.a.a().a(parampv) });
        }
        if ((paramj.N instanceof String)) {}
        for (parampv = (String)paramj.N; !TextUtils.isEmpty(parampv); parampv = null) {
          return u.a().getString(2131297016, new Object[] { android.support.v4.e.a.a().a(parampv), android.support.v4.e.a.a().a(paramj.e()) });
        }
        return u.a().getString(2131297015, new Object[] { android.support.v4.e.a.a().a(paramj.e()) });
        if (!paramva.a(paramj.f)) {
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131296948, new Object[] { str, android.support.v4.e.a.a().a(paramj.e()) });
        }
        return u.a().getString(2131296949, new Object[] { android.support.v4.e.a.a().a(paramj.e()) });
        if (paramj.f != null)
        {
          if (paramva.a(paramj.f))
          {
            if (TextUtils.isEmpty(paramj.e())) {
              return u.a().getString(2131297462);
            }
            return u.a().getString(2131297456);
          }
          if (TextUtils.isEmpty(paramj.e())) {
            return x.a(u.a(), paramd, paramaus, paramj.f, 2131297461, new Object[] { str });
          }
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297455, new Object[] { str });
        }
        return "";
        if (j.b(paramj.e.a)) {
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297091, new Object[] { str });
        }
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131296994);
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131296993, new Object[] { str });
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131297001);
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297000, new Object[] { str });
        if (j.b(paramj.e.a)) {
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297092, new Object[] { str });
        }
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131297004);
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297003, new Object[] { str });
        parampv = (List)paramj.N;
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131297009, new Object[] { paramrh.a(parampv) });
        }
        if (str == null)
        {
          if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
            return u.a().getString(2131296994);
          }
          return u.a().getString(2131296993, new Object[] { paramrh.a(parampv) });
        }
        if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297006, new Object[] { str });
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297005, new Object[] { str, paramrh.a(parampv) });
        parampv = (List)paramj.N;
        if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
          return u.a().getString(2131296999);
        }
        return u.a().getString(2131296998, new Object[] { paramrh.a(parampv) });
        parampv = (Collection)paramj.N;
        return u.a().getString(2131297000, new Object[] { paramrh.a(parampv) });
        parampv = (List)paramj.N;
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131297010, new Object[] { paramrh.a(parampv) });
        }
        if (str == null)
        {
          if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
            return u.a().getString(2131297004);
          }
          return u.a().getString(2131297003, new Object[] { paramrh.a(parampv) });
        }
        if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
          return x.a(u.a(), paramd, paramaus, paramj.f, 2131297008, new Object[] { str });
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297007, new Object[] { str, paramrh.a(parampv) });
        parampv = (List)paramj.N;
        if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
          return u.a().getString(2131297002);
        }
        return u.a.a(2131230754, parampv.size(), new Object[] { paramrh.a(parampv) });
        parampv = (List)paramj.N;
        if ((parampv.size() == 1) && (paramva.a((String)parampv.get(0)))) {
          return u.a().getString(2131296997);
        }
        return u.a.a(2131230753, parampv.size(), new Object[] { paramrh.a(parampv) });
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131296959);
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131296958, new Object[] { str });
        if (paramj.f == null) {
          return x.a(u.a(), paramd, paramaus, paramj.e.a, 2131297030, new Object[] { a(parampv, parame.d(paramj.e.a)) });
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297030, new Object[] { str });
        if (j.b(paramj.e.a)) {
          return u.a().getString(2131296356);
        }
        if (qz.e(paramj.e.a)) {
          return u.a().getString(2131296956);
        }
        return u.a().getString(2131296425);
        return u.a().getString(2131296404);
        parampv = (Collection)paramj.N;
        if (TextUtils.isEmpty(paramj.e())) {
          return u.a.a(2131230819, parampv.size(), new Object[] { Integer.valueOf(parampv.size()) });
        }
        return u.a.a(2131230818, parampv.size(), new Object[] { paramj.e(), Integer.valueOf(parampv.size()) });
        parampv = (String)paramj.N;
        if (parampv != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.a(bool);
          paramva = Character.toString(' ');
          if (!localcs.h()) {
            break;
          }
          return u.a().getString(2131296996, new Object[] { str.replace(" ", paramva), cs.b(parampv).replace(" ", paramva) });
        }
        return u.a().getString(2131296995, new Object[] { str, cs.b(localcs.t).replace(" ", paramva), cs.b(parampv).replace(" ", paramva) });
        if (TextUtils.isEmpty(paramj.f)) {
          return u.a().getString(2131297071);
        }
        if (paramva.a(paramj.f)) {
          return u.a().getString(2131297073);
        }
        return x.a(u.a(), paramd, paramaus, paramj.f, 2131297072, new Object[] { str });
      }
      str = null;
      localcs = null;
    }
  }
  
  private void q()
  {
    setClickable(false);
    this.O.setTextSize(a(getResources()));
    if ((this.a.d == -1) && (this.a.s == -1))
    {
      this.O.setText(u.a().getString(2131296788));
      return;
    }
    int i = getBackgroundResource();
    if (i != 0) {
      this.O.setBackgroundResource(i);
    }
    CharSequence localCharSequence2 = c.a(a(this.l, this.w, this.y, this.F, this.H, this.N, this.a), getContext(), this.O.getPaint(), 1.3F);
    CharSequence localCharSequence1;
    if ((this.a.t == 1L) || (this.a.t == 11L)) {
      localCharSequence1 = a(localCharSequence2);
    }
    for (;;)
    {
      this.O.setText(localCharSequence1);
      if (((this.w.a(this.a.f)) || (!qz.e(this.a.e.a)) || (this.a.t == 15L) || (this.a.t == 16L)) && (this.a.t != 18L) && (this.a.t != 19L) && (this.a.t != 21L)) {
        break;
      }
      setClickable(true);
      this.O.setOnClickListener(this.P);
      return;
      localCharSequence1 = localCharSequence2;
      if (this.a.t == 19L) {
        localCharSequence1 = bh.a("  " + localCharSequence2, b.a(getContext(), 2130840237), this.O.getPaint(), 0, 1);
      }
    }
    setClickable(false);
    this.O.setOnClickListener(null);
  }
  
  public void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        q();
      }
      return;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  int getBackgroundResource()
  {
    if ((this.a.e.b) && (this.a.d == 6) && ((this.a.t == 18L) || (this.a.t == 19L))) {
      return 2130840483;
    }
    return 2130837768;
  }
  
  protected int getCenteredLayoutId()
  {
    return 2130903146;
  }
  
  protected int getIncomingLayoutId()
  {
    return 2130903146;
  }
  
  protected int getOutgoingLayoutId()
  {
    return 2130903146;
  }
  
  public void i()
  {
    q();
    super.i();
  }
  
  public static final class a
    extends m
  {
    final pv aa = pv.a();
    final aus ab = aus.a();
    private final e ac = e.a();
    
    public static a a(String paramString)
    {
      a locala = new a();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      locala.f(localBundle);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = this.ac.d(i().getString("jid"));
      if (paramBundle.d()) {
        paramBundle = k().getString(2131296957);
      }
      for (;;)
      {
        return new b.a(l()).b(c.a(paramBundle, l().getBaseContext())).a(true).c(2131297028, ir.a(this)).b(2131297331, is.a(this)).a();
        if (j.b(paramBundle.t)) {
          paramBundle = k().getString(2131296357);
        } else {
          paramBundle = k().getString(2131296426);
        }
      }
    }
  }
  
  public static final class b
    extends m
  {
    final pv aa = pv.a();
    final aus ab = aus.a();
    private final aic ac = aic.a();
    private final e ad = e.a();
    
    public static b a(String paramString)
    {
      b localb = new b();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      localb.f(localBundle);
      return localb;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("jid");
      cs localcs = this.ad.d((String)a.d.a(paramBundle));
      return new b.a(k()).b(c.a(a(2131297027, new Object[] { ip.a(this.aa, localcs) }), k())).a(2131297029, it.a(this, paramBundle)).b(2131297331, null).c(2131297028, iu.a(this)).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */