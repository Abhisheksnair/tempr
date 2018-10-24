package com.whatsapp.messaging;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.phoneid.PhoneId;
import com.whatsapp.Me;
import com.whatsapp.abp;
import com.whatsapp.ahc;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.ant;
import com.whatsapp.anv;
import com.whatsapp.aq;
import com.whatsapp.atv;
import com.whatsapp.au;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.l.e;
import com.whatsapp.location.bp;
import com.whatsapp.phoneid.a;
import com.whatsapp.proto.d.a;
import com.whatsapp.proto.d.c;
import com.whatsapp.proto.d.c.a;
import com.whatsapp.proto.d.c.a.a;
import com.whatsapp.proto.d.c.b;
import com.whatsapp.proto.d.c.c;
import com.whatsapp.proto.d.d;
import com.whatsapp.proto.d.d.a;
import com.whatsapp.proto.d.d.b;
import com.whatsapp.proto.d.d.b.a;
import com.whatsapp.protocol.ab;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.b;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.qz;
import com.whatsapp.registration.bb;
import com.whatsapp.registration.x;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.dns.DnsCacheEntrySerializable;
import com.whatsapp.va;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

final class f
  extends HandlerThread
{
  private static int c = 0;
  private final com.whatsapp.data.ad A;
  private final a B;
  private final e C;
  private final and D;
  private final aus E;
  private final k F;
  private final aq G;
  private final com.whatsapp.data.l H;
  private final qz I;
  private final com.whatsapp.l.f J;
  private final com.whatsapp.registration.aw K;
  private final atv L;
  private final com.whatsapp.data.m M;
  private final bp N;
  private final bb O;
  final abp a;
  final com.whatsapp.a.c b;
  private as d;
  private final a e;
  private as.d f;
  private c g;
  private e h;
  private boolean i;
  private final l j = new l("connection_thread/logged_flag/connected");
  private final l k = new l("connection_thread/logged_flag/disconnecting");
  private final l l = new l("connection_thread/logged_flag/quit");
  private b m;
  private Socket n;
  private final Context o;
  private final Random p;
  private final m q;
  private final ant r;
  private final com.whatsapp.util.a.c s;
  private final va t;
  private final anv u;
  private final ahc v;
  private final w w;
  private final aic x;
  private final com.whatsapp.aw y;
  private final x z;
  
  public f(Context paramContext, a parama, m paramm, ant paramant, com.whatsapp.util.a.c paramc, va paramva, anv paramanv, ahc paramahc, w paramw, aic paramaic, com.whatsapp.aw paramaw, x paramx, com.whatsapp.data.ad paramad, a parama1, e parame, abp paramabp, and paramand, aus paramaus, k paramk, aq paramaq, com.whatsapp.data.l paraml, qz paramqz, com.whatsapp.l.f paramf, com.whatsapp.a.c paramc1, com.whatsapp.registration.aw paramaw1, atv paramatv, com.whatsapp.data.m paramm1, bp parambp, bb parambb)
  {
    super("ConnectionThread");
    this.e = parama;
    this.o = paramContext;
    this.q = paramm;
    this.r = paramant;
    this.s = paramc;
    this.t = paramva;
    this.u = paramanv;
    this.v = paramahc;
    this.w = paramw;
    this.x = paramaic;
    this.y = paramaw;
    this.z = paramx;
    this.A = paramad;
    this.B = parama1;
    this.C = parame;
    this.a = paramabp;
    this.D = paramand;
    this.E = paramaus;
    this.F = paramk;
    this.G = paramaq;
    this.H = paraml;
    this.I = paramqz;
    this.J = paramf;
    this.b = paramc1;
    this.K = paramaw1;
    this.L = paramatv;
    this.M = paramm1;
    this.N = parambp;
    this.O = parambb;
    this.p = new Random();
  }
  
  private com.whatsapp.proto.d a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    d.a locala = com.whatsapp.proto.d.b();
    try
    {
      locala.a(Long.parseLong(paramString1));
      locala.a(paramBoolean);
      if (TextUtils.isEmpty(paramString2)) {
        break label93;
      }
      if (paramString2 == null) {
        throw new NullPointerException();
      }
    }
    catch (NumberFormatException paramString2)
    {
      paramString1 = new AssertionError("jid is not numeric; jid=" + paramString1);
      paramString1.initCause(paramString2);
      throw paramString1;
    }
    locala.b |= 0x20;
    locala.e = paramString2;
    label93:
    locala.a(paramInt);
    locala.b(this.q.j());
    paramString1 = d.c.a(locala.c);
    paramString1.a(d.c.c.a);
    paramString2 = au.d().split("\\.", 3);
    if (paramString2.length != 3) {
      throw new AssertionError("expected three parts to version name; VERSION_NAME=" + au.d());
    }
    String str;
    try
    {
      paramString1.c = d.c.a.a(paramString1.c).a(Integer.parseInt(paramString2[0])).b(Integer.parseInt(paramString2[1])).c(Integer.parseInt(paramString2[2])).b();
      paramString1.b |= 0x2;
      paramString2 = this.D.c;
      if (paramString2 == null) {
        break label350;
      }
      paramString2 = com.whatsapp.util.ad.a(paramString2.getNetworkOperator());
      str = paramString2.a;
      if (str == null) {
        throw new NullPointerException();
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString2 = new AssertionError("non numeric portion of version name; VERSION_NAME=" + au.d());
      paramString2.initCause(paramString1);
      throw paramString2;
    }
    paramString1.b |= 0x4;
    paramString1.d = str;
    paramString2 = paramString2.b;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x8;
    paramString1.e = paramString2;
    label350:
    paramString2 = this.y.d;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x10;
    paramString1.f = paramString2;
    paramString2 = this.y.c;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x20;
    paramString1.g = paramString2;
    paramString2 = this.y.a;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x40;
    paramString1.h = paramString2;
    paramString2 = this.y.b;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x80;
    paramString1.i = paramString2;
    paramString2 = this.B.getPhoneId().id;
    if (paramString2 == null) {
      throw new NullPointerException();
    }
    paramString1.b |= 0x100;
    paramString1.j = paramString2;
    paramString2 = this.E.d();
    if ((!TextUtils.isEmpty(paramString2)) && (!"zz".equals(paramString2)))
    {
      if (paramString2 == null) {
        throw new NullPointerException();
      }
      paramString1.b |= 0x400;
      paramString1.k = paramString2;
    }
    paramString2 = this.E.c();
    if ((!TextUtils.isEmpty(paramString2)) && (!"ZZ".equals(paramString2)))
    {
      if (paramString2 == null) {
        throw new NullPointerException();
      }
      paramString1.b |= 0x800;
      paramString1.l = paramString2;
    }
    paramString2 = av.b();
    if (paramString2 != null) {
      paramString1.a(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = d.d.a(locala.d);
      if (paramString3 == null) {
        throw new NullPointerException();
      }
      paramString2.b |= 0x1;
      paramString2.c = paramString3;
      paramString2.b |= 0x2;
      paramString2.d = "0.14.8";
      paramString3 = d.d.b.a(paramString2.e);
      paramString3.a(true);
      paramString2.e = paramString3.b();
      paramString2.b |= 0x4;
      locala.d = paramString2.b();
      locala.b |= 0x10;
    }
    locala.c = paramString1.b();
    locala.b |= 0x8;
    return locala.b();
  }
  
  private void a()
  {
    Log.i("xmpp/connection/socket/close");
    try
    {
      if (!this.n.isOutputShutdown()) {
        this.n.shutdownOutput();
      }
      try
      {
        if (!this.n.isInputShutdown()) {
          this.n.shutdownInput();
        }
        try
        {
          if (!this.n.isClosed()) {
            this.n.close();
          }
          return;
        }
        catch (Exception localException1)
        {
          Log.i("xmpp/connection/closeSocket " + localException1);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static void a(com.whatsapp.proto.d paramd, b paramb, com.whatsapp.protocol.an paraman, com.whatsapp.protocol.aa paramaa, java.util.concurrent.atomic.AtomicReference<Integer> paramAtomicReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1142	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   4: invokevirtual 1143	com/whatsapp/proto/d$d:b	()Z
    //   7: istore 6
    //   9: aload_2
    //   10: invokeinterface 1148 1 0
    //   15: astore 7
    //   17: iconst_0
    //   18: istore 5
    //   20: aload 7
    //   22: ifnull +611 -> 633
    //   25: aload 7
    //   27: ldc_w 1150
    //   30: invokestatic 1153	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   33: ifeq +182 -> 215
    //   36: iload 5
    //   38: ifeq +14 -> 52
    //   41: new 575	com/whatsapp/protocol/c
    //   44: dup
    //   45: ldc_w 1155
    //   48: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: iload 6
    //   54: ifne +14 -> 68
    //   57: new 575	com/whatsapp/protocol/c
    //   60: dup
    //   61: ldc_w 1158
    //   64: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: aload 7
    //   70: ldc_w 1160
    //   73: invokevirtual 1163	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   76: astore 7
    //   78: aload 7
    //   80: ifnull +62 -> 142
    //   83: aload 7
    //   85: ldc_w 1165
    //   88: aconst_null
    //   89: invokevirtual 1168	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnull +529 -> 625
    //   99: aload 7
    //   101: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   104: istore 5
    //   106: aload_0
    //   107: getfield 1142	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   110: astore 8
    //   112: aload 8
    //   114: getfield 1169	com/whatsapp/proto/d$d:c	Ljava/lang/Object;
    //   117: astore 7
    //   119: aload 7
    //   121: instanceof 280
    //   124: ifeq +59 -> 183
    //   127: aload 7
    //   129: checkcast 280	java/lang/String
    //   132: astore 7
    //   134: aload_3
    //   135: aload 7
    //   137: iload 5
    //   139: invokevirtual 1171	com/whatsapp/protocol/aa:a	(Ljava/lang/String;I)V
    //   142: aload_2
    //   143: invokeinterface 1148 1 0
    //   148: astore 7
    //   150: iconst_1
    //   151: istore 5
    //   153: goto -133 -> 20
    //   156: astore_0
    //   157: new 575	com/whatsapp/protocol/c
    //   160: dup
    //   161: new 221	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 1173
    //   168: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload 7
    //   173: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: aload 7
    //   185: checkcast 1175	com/google/protobuf/e
    //   188: astore 9
    //   190: aload 9
    //   192: invokevirtual 1177	com/google/protobuf/e:e	()Ljava/lang/String;
    //   195: astore 7
    //   197: aload 9
    //   199: invokevirtual 1179	com/google/protobuf/e:f	()Z
    //   202: ifeq +10 -> 212
    //   205: aload 8
    //   207: aload 7
    //   209: putfield 1169	com/whatsapp/proto/d$d:c	Ljava/lang/Object;
    //   212: goto -78 -> 134
    //   215: aload 7
    //   217: ldc_w 1181
    //   220: invokestatic 1153	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   223: ifeq +149 -> 372
    //   226: iload 6
    //   228: ifeq +19 -> 247
    //   231: iload 5
    //   233: ifne +14 -> 247
    //   236: new 575	com/whatsapp/protocol/c
    //   239: dup
    //   240: ldc_w 1183
    //   243: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   246: athrow
    //   247: aload 7
    //   249: ldc_w 1184
    //   252: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +22 -> 279
    //   260: aload_1
    //   261: aload_0
    //   262: invokestatic 200	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   265: putfield 1106	com/whatsapp/protocol/b:k	J
    //   268: aload_1
    //   269: invokestatic 506	java/lang/System:currentTimeMillis	()J
    //   272: ldc2_w 499
    //   275: ldiv
    //   276: putfield 1108	com/whatsapp/protocol/b:l	J
    //   279: aload 7
    //   281: ldc_w 1189
    //   284: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore_0
    //   288: aload_0
    //   289: ifnull +12 -> 301
    //   292: aload 4
    //   294: aload_0
    //   295: invokestatic 1193	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   298: invokevirtual 1196	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   301: iconst_1
    //   302: istore 5
    //   304: iload 5
    //   306: ifne +318 -> 624
    //   309: new 575	com/whatsapp/protocol/c
    //   312: dup
    //   313: ldc_w 1198
    //   316: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   319: athrow
    //   320: astore_1
    //   321: new 575	com/whatsapp/protocol/c
    //   324: dup
    //   325: new 221	java/lang/StringBuilder
    //   328: dup
    //   329: ldc_w 1200
    //   332: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload_0
    //   336: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   345: athrow
    //   346: astore_1
    //   347: new 575	com/whatsapp/protocol/c
    //   350: dup
    //   351: new 221	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 1202
    //   358: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload_0
    //   362: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   371: athrow
    //   372: aload 7
    //   374: ldc_w 1204
    //   377: invokestatic 1153	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   380: ifeq +215 -> 595
    //   383: aload 7
    //   385: ldc_w 1206
    //   388: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   391: astore_0
    //   392: aload_0
    //   393: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   396: istore 5
    //   398: iload 5
    //   400: tableswitch	default:+20->420, 402:+55->455
    //   420: new 571	com/whatsapp/protocol/ab
    //   423: dup
    //   424: iconst_0
    //   425: invokespecial 1208	com/whatsapp/protocol/ab:<init>	(I)V
    //   428: athrow
    //   429: astore_1
    //   430: new 575	com/whatsapp/protocol/c
    //   433: dup
    //   434: new 221	java/lang/StringBuilder
    //   437: dup
    //   438: ldc_w 1210
    //   441: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   444: aload_0
    //   445: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   454: athrow
    //   455: new 571	com/whatsapp/protocol/ab
    //   458: dup
    //   459: iconst_2
    //   460: invokespecial 1208	com/whatsapp/protocol/ab:<init>	(I)V
    //   463: astore_0
    //   464: aload 7
    //   466: ldc_w 1212
    //   469: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore_1
    //   473: aload_0
    //   474: aload_1
    //   475: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   478: putfield 1213	com/whatsapp/protocol/ab:c	I
    //   481: aload 7
    //   483: ldc_w 1165
    //   486: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_1
    //   490: aload_0
    //   491: aload_1
    //   492: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   495: putfield 644	com/whatsapp/protocol/ab:b	I
    //   498: aload 7
    //   500: ldc_w 1215
    //   503: invokevirtual 1187	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore_1
    //   507: aload_0
    //   508: aload_1
    //   509: invokestatic 300	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   512: putfield 1217	com/whatsapp/protocol/ab:d	I
    //   515: aload_0
    //   516: athrow
    //   517: astore_0
    //   518: new 575	com/whatsapp/protocol/c
    //   521: dup
    //   522: new 221	java/lang/StringBuilder
    //   525: dup
    //   526: ldc_w 1219
    //   529: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   532: aload_1
    //   533: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   542: athrow
    //   543: astore_0
    //   544: new 575	com/whatsapp/protocol/c
    //   547: dup
    //   548: new 221	java/lang/StringBuilder
    //   551: dup
    //   552: ldc_w 1221
    //   555: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   558: aload_1
    //   559: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   568: athrow
    //   569: astore_0
    //   570: new 575	com/whatsapp/protocol/c
    //   573: dup
    //   574: new 221	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 1223
    //   581: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload_1
    //   585: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   594: athrow
    //   595: new 575	com/whatsapp/protocol/c
    //   598: dup
    //   599: new 221	java/lang/StringBuilder
    //   602: dup
    //   603: ldc_w 1225
    //   606: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   609: aload 7
    //   611: getfield 1226	com/whatsapp/protocol/ak:a	Ljava/lang/String;
    //   614: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokespecial 1156	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   623: athrow
    //   624: return
    //   625: sipush 500
    //   628: istore 5
    //   630: goto -524 -> 106
    //   633: iconst_0
    //   634: istore 5
    //   636: goto -332 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramd	com.whatsapp.proto.d
    //   0	639	1	paramb	b
    //   0	639	2	paraman	com.whatsapp.protocol.an
    //   0	639	3	paramaa	com.whatsapp.protocol.aa
    //   0	639	4	paramAtomicReference	java.util.concurrent.atomic.AtomicReference<Integer>
    //   18	617	5	i1	int
    //   7	220	6	bool	boolean
    //   15	595	7	localObject	Object
    //   110	96	8	locald	d.d
    //   188	10	9	locale	com.google.protobuf.e
    // Exception table:
    //   from	to	target	type
    //   99	106	156	java/lang/NumberFormatException
    //   260	279	320	java/lang/NumberFormatException
    //   292	301	346	java/lang/NumberFormatException
    //   392	398	429	java/lang/NumberFormatException
    //   473	481	517	java/lang/NumberFormatException
    //   490	498	543	java/lang/NumberFormatException
    //   507	515	569	java/lang/NumberFormatException
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = this.h.hasMessages(0);
    this.h.removeCallbacksAndMessages(null);
    if ((this.j.a) && (!this.k.a)) {
      if (paramBoolean)
      {
        Log.i("xmpp/connection/forced_disconnect/reader_thread/mark_finished");
        if (this.g != null) {
          this.g.c();
        }
        a();
        this.f.a();
        this.e.a(true);
        this.j.a(false);
        b();
        if (this.l.a)
        {
          Log.i("xmpp/connection/quit during forced disconnect");
          this.d.quit();
          quit();
        }
      }
    }
    while ((!bool) || (!paramBoolean))
    {
      return;
      this.h.a();
      this.f.a(a.a.a.a.d.i());
      this.k.a(true);
      return;
    }
    e locale = this.h;
    Log.w("xmpp/connection/fire-logout-timeout");
    locale.sendEmptyMessage(0);
  }
  
  private void b()
  {
    Object localObject = new Intent("com.whatsapp.alarm.CLIENT_PING_TIMEOUT").setPackage(au.b());
    localObject = PendingIntent.getBroadcast(u.a(), 0, (Intent)localObject, 1610612736);
    if (localObject != null)
    {
      ((AlarmManager)u.a().getSystemService("alarm")).cancel((PendingIntent)localObject);
      ((PendingIntent)localObject).cancel();
    }
    this.i = false;
  }
  
  private void b(boolean paramBoolean)
  {
    this.j.a(false);
    this.k.a(false);
    if (!this.l.a)
    {
      this.h.removeMessages(0);
      this.f.a();
      if (this.i)
      {
        Log.d("xmpp/connection/disconnected/pending_ping");
        paramBoolean = true;
      }
      this.e.a(paramBoolean);
    }
    for (;;)
    {
      b();
      this.h.removeCallbacksAndMessages(null);
      return;
      Log.i("xmpp/connection/quit");
      this.d.quit();
      quit();
    }
  }
  
  private void c()
  {
    Log.i("xmpp/connection/sendchangenumber");
    this.f.a(Message.obtain(null, 0, 61, 0, new aw(this.t.e().jabber_id)));
  }
  
  private void d()
  {
    Object localObject = new Intent("com.whatsapp.alarm.CLIENT_PING_TIMEOUT").setPackage(au.b());
    AlarmManager localAlarmManager;
    long l1;
    if (PendingIntent.getBroadcast(u.a(), 0, (Intent)localObject, 1610612736) == null)
    {
      localObject = PendingIntent.getBroadcast(u.a(), 0, (Intent)localObject, 1073741824);
      localAlarmManager = (AlarmManager)u.a().getSystemService("alarm");
      l1 = Math.min(32, Math.max(8, aic.K)) * 1000L + SystemClock.elapsedRealtime();
      if (Build.VERSION.SDK_INT >= 23) {
        localAlarmManager.setExactAndAllowWhileIdle(2, l1, (PendingIntent)localObject);
      }
    }
    for (;;)
    {
      this.i = true;
      this.f.a(Message.obtain(null, 0, 22, 0));
      return;
      if (Build.VERSION.SDK_INT >= 19)
      {
        localAlarmManager.setExact(2, l1, (PendingIntent)localObject);
      }
      else
      {
        localAlarmManager.set(2, l1, (PendingIntent)localObject);
        continue;
        Log.i("xmpp/connection/pingtimeout/already_set");
      }
    }
  }
  
  protected final void onLooperPrepared()
  {
    this.h = new e();
    this.d = new as(new f());
    this.d.start();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(Message paramMessage);
    
    public abstract void a(f.d paramd);
    
    public abstract void a(ab paramab);
    
    public abstract void a(al paramal);
    
    public abstract void a(String paramString);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void c();
  }
  
  @SuppressLint({"HandlerLeak"})
  final class b
    extends Handler
    implements f.d
  {
    public b()
    {
      super();
    }
    
    public final void a()
    {
      Log.d("xmpp/connection/send/inactive");
      obtainMessage(5).sendToTarget();
    }
    
    public final void a(Message paramMessage)
    {
      Log.d("xmpp/connection/send/xmpp_send");
      paramMessage.what = 3;
      sendMessage(paramMessage);
    }
    
    public final void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, ArrayList<DnsCacheEntrySerializable> paramArrayList)
    {
      Object localObject2 = new StringBuilder("xmpp/connection/send/connect/");
      if (paramBoolean2) {}
      for (Object localObject1 = "active";; localObject1 = "passive " + f.f(f.this).c())
      {
        Log.i((String)localObject1);
        localObject1 = obtainMessage(0);
        localObject2 = ((Message)localObject1).getData();
        ((Bundle)localObject2).putString("jid", paramString1);
        ((Bundle)localObject2).putString("ipaddress", paramString2);
        ((Bundle)localObject2).putBoolean("available", paramBoolean1);
        ((Bundle)localObject2).putBoolean("active_connection", paramBoolean2);
        ((Bundle)localObject2).putSerializable("fallbacks", paramArrayList);
        ((Message)localObject1).sendToTarget();
        return;
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      Log.d("xmpp/connection/send/disconnect");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        obtainMessage(1, i, 0).sendToTarget();
        return;
      }
    }
    
    public final void b()
    {
      Log.d("xmpp/connection/send/active");
      obtainMessage(6).sendToTarget();
    }
    
    public final void c()
    {
      Log.d("xmpp/connection/send/pingtimeout");
      obtainMessage(7).sendToTarget();
    }
    
    public final void d()
    {
      Log.d("xmpp/connection/send/quit");
      obtainMessage(2).sendToTarget();
    }
    
    public final void e()
    {
      Log.d("xmpp/connection/send/client_ping");
      obtainMessage(4).sendToTarget();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.i("xmpp/connection/recv/connect");
        paramMessage = paramMessage.getData();
        f.a(f.this, paramMessage.getString("jid"), paramMessage.getString("ipaddress"), paramMessage.getBoolean("available"), paramMessage.getBoolean("active_connection"), (ArrayList)paramMessage.getSerializable("fallbacks"));
        return;
      case 1: 
        Log.d("xmpp/connection/recv/disconnect");
        f localf = f.this;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          f.a(localf, bool);
          return;
          bool = false;
        }
      case 5: 
        Log.d("xmpp/connection/recv/inactive");
        f.g(f.this);
        return;
      case 6: 
        Log.d("xmpp/connection/recv/active");
        f.h(f.this);
        return;
      case 2: 
        Log.d("xmpp/connection/recv/quit");
        f.i(f.this);
        return;
      case 3: 
        Log.d("xmpp/connection/recv/xmpp_send");
        f.b(f.this, paramMessage);
        return;
      case 4: 
        Log.d("xmpp/connection/recv/client_ping");
        f.j(f.this);
        return;
      }
      Log.d("xmpp/connection/recv/pingtimeout");
      f.k(f.this);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  final class c
    extends Handler
    implements u.a
  {
    private boolean b;
    
    public c()
    {
      super();
    }
    
    public final void a()
    {
      Log.d("xmpp/connection/send/logout");
      sendEmptyMessage(1);
    }
    
    public final void a(long paramLong)
    {
      Log.d("xmpp/connection/send/ping_response; timestamp=" + paramLong);
      Message localMessage = obtainMessage(3);
      localMessage.getData().putLong("timestamp", paramLong);
      localMessage.sendToTarget();
    }
    
    public final void a(Message paramMessage)
    {
      Log.d("xmpp/connection/send/xmpp_recv");
      paramMessage.what = 0;
      sendMessage(paramMessage);
    }
    
    public final void a(al paramal)
    {
      Log.d("xmpp/connection/send/ack; stanzaKey=" + paramal);
      obtainMessage(5, paramal).sendToTarget();
    }
    
    public final void a(String paramString)
    {
      Log.d("xmpp/connection/send/iq-response; id=" + paramString);
      obtainMessage(4, paramString).sendToTarget();
    }
    
    public final void b()
    {
      Log.d("xmpp/connection/send/reader_error");
      sendEmptyMessage(2);
    }
    
    public final void c()
    {
      Log.d("xmpp/connection/reader_thread/finished");
      this.b = true;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.d("xmpp/connection/recv/xmpp_recv");
        f.a(f.this, paramMessage);
        return;
      case 1: 
        if (this.b)
        {
          Log.d("xmpp/connection/recv/logout (ignored)");
          return;
        }
        Log.d("xmpp/connection/recv/logout");
        f.a(f.this);
        return;
      case 2: 
        if (this.b)
        {
          Log.d("xmpp/connection/recv/reader_error (ignored)");
          return;
        }
        Log.d("xmpp/connection/recv/reader_error");
        if (f.b(f.this))
        {
          Log.d("xmpp/connection/recv/reader_error/during-logout");
          f.a(f.this);
          return;
        }
        f.c(f.this);
        return;
      case 3: 
        long l = paramMessage.getData().getLong("timestamp");
        Log.d("xmpp/connection/recv/ping_response; timestamp=" + l);
        f.d(f.this);
        return;
      case 4: 
        Log.d("xmpp/connection/recv/iq-response; id=" + paramMessage.obj);
        f.e(f.this).a((String)paramMessage.obj);
        return;
      }
      Log.d("xmpp/connection/recv/ack; stanzaKey=" + paramMessage.obj);
      f.e(f.this).a((al)paramMessage.obj);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void a(Message paramMessage);
    
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, ArrayList<DnsCacheEntrySerializable> paramArrayList);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
  }
  
  @SuppressLint({"HandlerLeak"})
  final class e
    extends Handler
  {
    public e()
    {
      super();
    }
    
    public final void a()
    {
      sendEmptyMessageDelayed(0, 10000L);
    }
    
    public final void b()
    {
      sendEmptyMessageDelayed(2, 32000L);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        j localj;
        do
        {
          return;
          f.l(f.this);
          return;
          paramMessage = (j.b)paramMessage.obj;
          Log.d("xmpp/connection/msgreceipt/check; messageKey=" + paramMessage);
          localj = f.m(f.this).a(paramMessage);
        } while ((localj == null) || (s.a(localj.d, 4) >= 0));
        Log.w("message receipt timeout fired; messageKey=" + paramMessage + "; fMessage.status=" + localj.d);
        removeMessages(1);
        f.a(f.this, true);
        return;
      case 2: 
        Log.w("connection active timeout fired");
        removeMessages(2);
        f.a(f.this, true);
        return;
      }
      Log.w("call offer timeout fired");
      removeMessages(3);
      f.a(f.this, true);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  final class f
    extends Handler
    implements as.a
  {
    public f()
    {
      super();
    }
    
    public final void a(as.d paramd)
    {
      Log.d("xmpp/connection/send/sending_channel_ready");
      obtainMessage(0, paramd).sendToTarget();
    }
    
    public final void a(b paramb)
    {
      Log.d("xmpp/connection/send/send_error");
      obtainMessage(1, paramb).sendToTarget();
    }
    
    public final void a(j.b paramb)
    {
      Log.d("xmpp/connection/send/message_sent");
      obtainMessage(2, paramb).sendToTarget();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.i("xmpp/connection/recv/sending_channel_ready");
        f.a(f.this, (as.d)paramMessage.obj);
        return;
      case 1: 
        Log.d("xmpp/connection/recv/send_error");
        f.a(f.this, (b)paramMessage.obj);
        return;
      }
      Log.d("xmpp/connection/recv/message_sent");
      f.a(f.this, (j.b)paramMessage.obj);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */