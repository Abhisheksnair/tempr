package com.whatsapp.jobqueue.job;

import a.a.a.a.d;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.whatsapp.ant;
import com.whatsapp.att;
import com.whatsapp.data.ci;
import com.whatsapp.data.l;
import com.whatsapp.jobqueue.requirement.AxolotlDifferentAliceBaseKeyRequirement;
import com.whatsapp.jobqueue.requirement.AxolotlFastRatchetSenderKeyRequirement;
import com.whatsapp.jobqueue.requirement.AxolotlParticipantSessionsRequirement;
import com.whatsapp.jobqueue.requirement.AxolotlSenderKeyRequirement;
import com.whatsapp.jobqueue.requirement.AxolotlSessionRequirement;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.m;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.j.c;
import com.whatsapp.qz;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class SendE2EMessageJob
  extends Job
  implements b
{
  private static final ConcurrentHashMap<a, Boolean> messagesBeingSent = new ConcurrentHashMap();
  private static final Random random = new Random();
  private static final long serialVersionUID = 1L;
  transient va a;
  transient com.whatsapp.a.c b;
  private boolean duplicate;
  private final int editVersion;
  private final long expireTimeMs;
  private transient ant f;
  private transient com.whatsapp.util.a.c g;
  private final String groupParticipantHash;
  private transient att h;
  private transient m i;
  private final String id;
  private final boolean includeSenderKeysInMessage;
  private transient l j;
  final String jid;
  private transient bp k;
  private transient ci l;
  private final Integer liveLocationDuration;
  private transient rh m;
  private final E2E.Message message;
  private final long originalTimestamp;
  private final int originationFlags;
  private final String participant;
  private final boolean potentialOneTimeSend;
  private final int retryCount;
  private final j.c webAttribute;
  
  public SendE2EMessageJob(E2E.Message arg1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, j.c paramc, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, Integer paramInteger, boolean paramBoolean2) {}
  
  private Pair<Map<String, com.whatsapp.protocol.f>, List<String>> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    Object localObject5;
    if (paramBoolean2)
    {
      Log.d("sending forced onetime fanout message" + h());
      localObject3 = d.a(this.message, random);
      localObject4 = this.l.a(this.jid, this.groupParticipantHash);
      if (localObject4 != null)
      {
        localObject1 = new HashMap();
        localObject4 = ((Collection)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          if (!this.a.a((String)localObject5)) {
            ((Map)localObject1).put(localObject5, (com.whatsapp.protocol.f)com.whatsapp.a.c.a.submit(e.a(this, (String)localObject5, (byte[])localObject3)).get());
          }
        }
      }
    }
    for (;;)
    {
      return Pair.create(localObject1, localObject2);
      Log.w("unable to retrieve participants for one time message" + h());
      localObject1 = null;
      continue;
      if ((paramBoolean1) && (this.includeSenderKeysInMessage))
      {
        localObject3 = this.l.a(this.jid, this.groupParticipantHash);
        if (localObject3 != null)
        {
          localObject5 = this.m.a(this.jid).a(this.a);
          if (!((Collection)localObject5).isEmpty())
          {
            ((Collection)localObject5).retainAll((Collection)localObject3);
            localObject1 = new HashMap();
            Object localObject6 = ((E2E.Message)com.whatsapp.a.c.a.submit(f.a(this)).get()).toByteArray();
            localObject4 = new byte[localObject6.length + 1];
            System.arraycopy(localObject6, 0, localObject4, 0, localObject6.length);
            Arrays.fill((byte[])localObject4, localObject6.length, localObject4.length, (byte)1);
            localObject5 = ((Collection)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              ((Map)localObject1).put(localObject6, (com.whatsapp.protocol.f)com.whatsapp.a.c.a.submit(g.a(this, (String)localObject6, (byte[])localObject4)).get());
            }
            if (com.whatsapp.protocol.j.b(this.jid))
            {
              localObject2 = new ArrayList();
              localObject3 = ((Collection)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (String)((Iterator)localObject3).next();
                if (!((Map)localObject1).containsKey(localObject4)) {
                  ((List)localObject2).add(localObject4);
                }
              }
            }
          }
          else
          {
            Log.d("no participants need the sender key" + h());
            if (com.whatsapp.protocol.j.b(this.jid)) {}
            for (localObject1 = new ArrayList((Collection)localObject3);; localObject1 = null)
            {
              localObject3 = null;
              localObject2 = localObject1;
              localObject1 = localObject3;
              break;
            }
          }
        }
        else
        {
          Log.w("unable to retrieve participants in group at time of message" + h());
          localObject1 = null;
        }
      }
      else
      {
        Log.d("no need to include participant messages in message" + h());
        localObject1 = null;
      }
    }
  }
  
  public static boolean a(j.b paramb, int paramInt)
  {
    return messagesBeingSent.containsKey(new a(paramb, paramInt));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return ((qz.e(paramString1)) || (com.whatsapp.protocol.j.b(paramString1))) && (TextUtils.isEmpty(paramString2));
  }
  
  private boolean g()
  {
    return ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a() >= this.expireTimeMs;
  }
  
  private String h()
  {
    return "; id=" + this.id + "; jid=" + this.jid + "; participant=" + this.participant + "; retryCount=" + this.retryCount + "; groupParticipantHash=" + this.groupParticipantHash + "; webAttribute=" + this.webAttribute + "; includeSenderKeysInMessage=" + this.includeSenderKeysInMessage + "; potentialOneTimeSend=" + this.potentialOneTimeSend + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Object localObject2 = null;
    Log.i("e2e message send job added" + h());
    Iterator localIterator = e().iterator();
    Object localObject1 = null;
    Object localObject3;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (Requirement)localIterator.next();
        if ((localObject3 instanceof AxolotlSessionRequirement))
        {
          localObject3 = (AxolotlSessionRequirement)localObject3;
          if (!((AxolotlSessionRequirement)localObject3).a()) {
            localObject1 = ((AxolotlSessionRequirement)localObject3).jid;
          }
        }
        else if ((localObject3 instanceof AxolotlDifferentAliceBaseKeyRequirement))
        {
          localObject3 = (AxolotlDifferentAliceBaseKeyRequirement)localObject3;
          if (((AxolotlDifferentAliceBaseKeyRequirement)localObject3).a()) {
            break label284;
          }
          localObject2 = ((AxolotlDifferentAliceBaseKeyRequirement)localObject3).jid;
          localObject1 = ((AxolotlDifferentAliceBaseKeyRequirement)localObject3).oldAliceBaseKey;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if ((localObject3 instanceof AxolotlSenderKeyRequirement))
      {
        if (((AxolotlSenderKeyRequirement)localObject3).a()) {
          break;
        }
        this.h.a(new SendSenderKeyJob(this.jid, this.id, this.expireTimeMs));
        break;
      }
      if ((localObject3 instanceof AxolotlParticipantSessionsRequirement))
      {
        localObject3 = ((AxolotlParticipantSessionsRequirement)localObject3).b();
        if (((Collection)localObject3).isEmpty()) {
          break;
        }
        localObject3 = (String[])((Collection)localObject3).toArray(new String[((Collection)localObject3).size()]);
        this.h.a(new BulkGetPreKeyJob(this.jid, (String[])localObject3));
        break;
      }
      if ((!(localObject3 instanceof AxolotlFastRatchetSenderKeyRequirement)) || (((AxolotlFastRatchetSenderKeyRequirement)localObject3).a())) {
        break;
      }
      this.k.m();
      break;
      if (localObject1 != null) {
        this.h.a(new GetPreKeyJob((String)localObject1, (byte[])localObject2));
      }
      return;
      label284:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public final void a(Context paramContext)
  {
    this.f = ant.a();
    this.g = com.whatsapp.util.a.c.a();
    this.a = va.a();
    this.h = att.a();
    this.i = m.a();
    this.j = l.a();
    this.b = com.whatsapp.a.c.a();
    this.k = bp.a();
    this.l = ci.a();
    this.m = rh.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while sending e2e message" + h(), paramException);
    if (((paramException.getCause() instanceof Error)) && (random.nextInt(100) == 0)) {
      this.g.a("SendE2EMessageJob: " + paramException.getCause().getClass().getSimpleName(), false, null, -1);
    }
    return true;
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 647	com/whatsapp/jobqueue/job/SendE2EMessageJob:g	()Z
    //   4: ifeq +65 -> 69
    //   7: new 175	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 649
    //   14: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokespecial 181	com/whatsapp/jobqueue/job/SendE2EMessageJob:h	()Ljava/lang/String;
    //   21: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 509	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   30: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   36: dup
    //   37: new 219	com/whatsapp/protocol/j$b
    //   40: dup
    //   41: aload_0
    //   42: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   45: iconst_1
    //   46: aload_0
    //   47: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   50: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   57: aload_0
    //   58: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   61: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   64: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: return
    //   69: aload_0
    //   70: getfield 231	com/whatsapp/jobqueue/job/SendE2EMessageJob:duplicate	Z
    //   73: ifeq +65 -> 138
    //   76: new 175	java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 654
    //   83: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokespecial 181	com/whatsapp/jobqueue/job/SendE2EMessageJob:h	()Ljava/lang/String;
    //   90: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 323	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   99: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   102: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   105: dup
    //   106: new 219	com/whatsapp/protocol/j$b
    //   109: dup
    //   110: aload_0
    //   111: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   114: iconst_1
    //   115: aload_0
    //   116: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   119: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   122: aload_0
    //   123: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   126: aload_0
    //   127: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   130: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   133: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: return
    //   138: new 219	com/whatsapp/protocol/j$b
    //   141: dup
    //   142: aload_0
    //   143: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   146: iconst_1
    //   147: aload_0
    //   148: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   151: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   154: astore 10
    //   156: aload_0
    //   157: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   160: invokevirtual 657	com/whatsapp/proto/E2E$Message:hasChat	()Z
    //   163: ifne +77 -> 240
    //   166: aload_0
    //   167: getfield 599	com/whatsapp/jobqueue/job/SendE2EMessageJob:j	Lcom/whatsapp/data/l;
    //   170: aload 10
    //   172: invokevirtual 660	com/whatsapp/data/l:a	(Lcom/whatsapp/protocol/j$b;)Lcom/whatsapp/protocol/j;
    //   175: ifnonnull +65 -> 240
    //   178: new 175	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 662
    //   185: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: invokespecial 181	com/whatsapp/jobqueue/job/SendE2EMessageJob:h	()Ljava/lang/String;
    //   192: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 509	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   201: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   204: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   207: dup
    //   208: new 219	com/whatsapp/protocol/j$b
    //   211: dup
    //   212: aload_0
    //   213: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   216: iconst_1
    //   217: aload_0
    //   218: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   221: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   224: aload_0
    //   225: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   228: aload_0
    //   229: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   232: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   235: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: return
    //   240: new 175	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 664
    //   247: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: invokespecial 181	com/whatsapp/jobqueue/job/SendE2EMessageJob:h	()Ljava/lang/String;
    //   254: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 509	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 145	com/whatsapp/jobqueue/job/SendE2EMessageJob:retryCount	I
    //   267: iconst_4
    //   268: if_icmple +65 -> 333
    //   271: new 175	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 666
    //   278: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: invokespecial 181	com/whatsapp/jobqueue/job/SendE2EMessageJob:h	()Ljava/lang/String;
    //   285: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 323	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   294: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   297: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   300: dup
    //   301: new 219	com/whatsapp/protocol/j$b
    //   304: dup
    //   305: aload_0
    //   306: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   309: iconst_1
    //   310: aload_0
    //   311: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   314: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   317: aload_0
    //   318: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   321: aload_0
    //   322: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   325: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   328: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: return
    //   333: aload_0
    //   334: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   337: getstatic 72	com/whatsapp/jobqueue/job/SendE2EMessageJob:random	Ljava/util/Random;
    //   340: invokestatic 254	a/a/a/a/d:a	(Lcom/whatsapp/proto/E2E$Message;Ljava/util/Random;)[B
    //   343: astore 8
    //   345: new 668	com/whatsapp/protocol/al
    //   348: dup
    //   349: invokespecial 669	com/whatsapp/protocol/al:<init>	()V
    //   352: astore 11
    //   354: aload 11
    //   356: aload_0
    //   357: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   360: putfield 671	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   363: aload 11
    //   365: ldc_w 672
    //   368: putfield 674	com/whatsapp/protocol/al:b	Ljava/lang/String;
    //   371: aload 11
    //   373: aload 10
    //   375: getfield 676	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   378: putfield 677	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   381: aload 11
    //   383: aload_0
    //   384: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   387: putfield 679	com/whatsapp/protocol/al:e	Ljava/lang/String;
    //   390: aload_0
    //   391: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   394: ifeq +15 -> 409
    //   397: aload 11
    //   399: aload_0
    //   400: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   403: invokestatic 684	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   406: putfield 686	com/whatsapp/protocol/al:f	Ljava/lang/String;
    //   409: aload_0
    //   410: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   413: aload_0
    //   414: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   417: invokestatic 100	com/whatsapp/jobqueue/job/SendE2EMessageJob:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   420: istore_3
    //   421: aload_0
    //   422: getfield 163	com/whatsapp/jobqueue/job/SendE2EMessageJob:potentialOneTimeSend	Z
    //   425: ifeq +687 -> 1112
    //   428: aload_0
    //   429: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   432: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   435: ifeq +661 -> 1096
    //   438: aload_0
    //   439: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   442: invokestatic 173	com/whatsapp/protocol/j:b	(Ljava/lang/String;)Z
    //   445: ifne +13 -> 458
    //   448: aload_0
    //   449: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   452: invokestatic 169	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   455: ifeq +641 -> 1096
    //   458: aload_0
    //   459: getfield 147	com/whatsapp/jobqueue/job/SendE2EMessageJob:groupParticipantHash	Ljava/lang/String;
    //   462: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   465: ifeq +337 -> 802
    //   468: goto +628 -> 1096
    //   471: aload_0
    //   472: iload_3
    //   473: iload_2
    //   474: invokespecial 688	com/whatsapp/jobqueue/job/SendE2EMessageJob:a	(ZZ)Landroid/util/Pair;
    //   477: astore 9
    //   479: aload 9
    //   481: getfield 692	android/util/Pair:first	Ljava/lang/Object;
    //   484: checkcast 311	java/util/Map
    //   487: astore 12
    //   489: aload 9
    //   491: getfield 695	android/util/Pair:second	Ljava/lang/Object;
    //   494: checkcast 371	java/util/List
    //   497: astore 13
    //   499: getstatic 291	com/whatsapp/a/c:a	Ljava/util/concurrent/ExecutorService;
    //   502: aload_0
    //   503: iload_2
    //   504: iload_3
    //   505: aload 8
    //   507: invokestatic 700	com/whatsapp/jobqueue/job/d:a	(Lcom/whatsapp/jobqueue/job/SendE2EMessageJob;ZZ[B)Ljava/util/concurrent/Callable;
    //   510: invokeinterface 302 2 0
    //   515: invokeinterface 307 1 0
    //   520: checkcast 309	com/whatsapp/protocol/f
    //   523: astore 14
    //   525: aconst_null
    //   526: astore 8
    //   528: aload 8
    //   530: astore 9
    //   532: aload_0
    //   533: getfield 161	com/whatsapp/jobqueue/job/SendE2EMessageJob:liveLocationDuration	Ljava/lang/Integer;
    //   536: ifnull +83 -> 619
    //   539: aload_0
    //   540: getfield 599	com/whatsapp/jobqueue/job/SendE2EMessageJob:j	Lcom/whatsapp/data/l;
    //   543: aload 10
    //   545: invokevirtual 660	com/whatsapp/data/l:a	(Lcom/whatsapp/protocol/j$b;)Lcom/whatsapp/protocol/j;
    //   548: astore 15
    //   550: aload 8
    //   552: astore 9
    //   554: aload 15
    //   556: ifnull +63 -> 619
    //   559: aload_0
    //   560: getfield 572	com/whatsapp/jobqueue/job/SendE2EMessageJob:f	Lcom/whatsapp/ant;
    //   563: invokevirtual 702	com/whatsapp/ant:b	()J
    //   566: lstore 4
    //   568: aload 15
    //   570: getfield 705	com/whatsapp/protocol/j:n	J
    //   573: lstore 6
    //   575: aload 8
    //   577: astore 9
    //   579: aload 15
    //   581: getfield 707	com/whatsapp/protocol/j:w	I
    //   584: lload 4
    //   586: lload 6
    //   588: lsub
    //   589: ldc2_w 708
    //   592: ldiv
    //   593: l2i
    //   594: isub
    //   595: ifle +24 -> 619
    //   598: aload 15
    //   600: getfield 707	com/whatsapp/protocol/j:w	I
    //   603: lload 4
    //   605: lload 6
    //   607: lsub
    //   608: ldc2_w 708
    //   611: ldiv
    //   612: l2i
    //   613: isub
    //   614: invokestatic 713	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: astore 9
    //   619: aload_0
    //   620: getfield 592	com/whatsapp/jobqueue/job/SendE2EMessageJob:i	Lcom/whatsapp/messaging/m;
    //   623: astore 15
    //   625: aload_0
    //   626: getfield 155	com/whatsapp/jobqueue/job/SendE2EMessageJob:originalTimestamp	J
    //   629: lstore 4
    //   631: aload_0
    //   632: getfield 145	com/whatsapp/jobqueue/job/SendE2EMessageJob:retryCount	I
    //   635: istore_1
    //   636: aload_0
    //   637: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   640: astore 16
    //   642: aload_0
    //   643: getfield 147	com/whatsapp/jobqueue/job/SendE2EMessageJob:groupParticipantHash	Ljava/lang/String;
    //   646: astore 17
    //   648: aload_0
    //   649: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   652: invokevirtual 716	com/whatsapp/proto/E2E$Message:hasImageMessage	()Z
    //   655: ifeq +183 -> 838
    //   658: ldc_w 718
    //   661: astore 8
    //   663: aload 15
    //   665: aload 11
    //   667: aconst_null
    //   668: iconst_0
    //   669: bipush 8
    //   671: iconst_0
    //   672: new 720	com/whatsapp/messaging/ca
    //   675: dup
    //   676: aload 10
    //   678: lload 4
    //   680: iload_1
    //   681: aload 16
    //   683: aload 17
    //   685: aload 8
    //   687: aload_0
    //   688: getfield 149	com/whatsapp/jobqueue/job/SendE2EMessageJob:webAttribute	Lcom/whatsapp/protocol/j$c;
    //   691: aload 14
    //   693: aload 12
    //   695: aload 13
    //   697: aload_0
    //   698: getfield 157	com/whatsapp/jobqueue/job/SendE2EMessageJob:originationFlags	I
    //   701: aload_0
    //   702: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   705: aload 9
    //   707: invokespecial 723	com/whatsapp/messaging/ca:<init>	(Lcom/whatsapp/protocol/j$b;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/whatsapp/protocol/j$c;Lcom/whatsapp/protocol/f;Ljava/util/Map;Ljava/util/List;IILjava/lang/Integer;)V
    //   710: invokestatic 729	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   713: invokevirtual 732	com/whatsapp/messaging/m:a	(Lcom/whatsapp/protocol/al;Landroid/os/Message;)Ljava/util/concurrent/Future;
    //   716: invokeinterface 307 1 0
    //   721: pop
    //   722: iload_3
    //   723: ifeq +40 -> 763
    //   726: aload 12
    //   728: ifnull +35 -> 763
    //   731: aload 12
    //   733: invokeinterface 733 1 0
    //   738: ifne +25 -> 763
    //   741: aload_0
    //   742: getfield 256	com/whatsapp/jobqueue/job/SendE2EMessageJob:l	Lcom/whatsapp/data/ci;
    //   745: aload_0
    //   746: getfield 325	com/whatsapp/jobqueue/job/SendE2EMessageJob:m	Lcom/whatsapp/rh;
    //   749: aload_0
    //   750: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   753: aload 12
    //   755: invokeinterface 737 1 0
    //   760: invokevirtual 740	com/whatsapp/data/ci:a	(Lcom/whatsapp/rh;Ljava/lang/String;Ljava/util/Collection;)V
    //   763: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   766: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   769: dup
    //   770: new 219	com/whatsapp/protocol/j$b
    //   773: dup
    //   774: aload_0
    //   775: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   778: iconst_1
    //   779: aload_0
    //   780: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   783: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   786: aload_0
    //   787: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   790: aload_0
    //   791: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   794: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   797: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: pop
    //   801: return
    //   802: aload_0
    //   803: getfield 256	com/whatsapp/jobqueue/job/SendE2EMessageJob:l	Lcom/whatsapp/data/ci;
    //   806: aconst_null
    //   807: aload_0
    //   808: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   811: invokevirtual 743	com/whatsapp/data/ci:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    //   814: astore 9
    //   816: aload 9
    //   818: ifnull +289 -> 1107
    //   821: aload 9
    //   823: aload_0
    //   824: getfield 147	com/whatsapp/jobqueue/job/SendE2EMessageJob:groupParticipantHash	Ljava/lang/String;
    //   827: invokevirtual 746	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   830: ifne +277 -> 1107
    //   833: iconst_1
    //   834: istore_1
    //   835: goto +263 -> 1098
    //   838: aload_0
    //   839: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   842: invokevirtual 749	com/whatsapp/proto/E2E$Message:hasContactMessage	()Z
    //   845: ifeq +11 -> 856
    //   848: ldc_w 751
    //   851: astore 8
    //   853: goto -190 -> 663
    //   856: aload_0
    //   857: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   860: invokevirtual 754	com/whatsapp/proto/E2E$Message:hasContactsArrayMessage	()Z
    //   863: ifeq +11 -> 874
    //   866: ldc_w 756
    //   869: astore 8
    //   871: goto -208 -> 663
    //   874: aload_0
    //   875: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   878: invokevirtual 759	com/whatsapp/proto/E2E$Message:hasLocationMessage	()Z
    //   881: ifeq +11 -> 892
    //   884: ldc_w 761
    //   887: astore 8
    //   889: goto -226 -> 663
    //   892: aload_0
    //   893: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   896: invokevirtual 764	com/whatsapp/proto/E2E$Message:hasLiveLocationMessage	()Z
    //   899: ifeq +11 -> 910
    //   902: ldc_w 766
    //   905: astore 8
    //   907: goto -244 -> 663
    //   910: aload_0
    //   911: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   914: invokevirtual 769	com/whatsapp/proto/E2E$Message:hasExtendedTextMessage	()Z
    //   917: ifeq +24 -> 941
    //   920: aload_0
    //   921: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   924: invokevirtual 773	com/whatsapp/proto/E2E$Message:getExtendedTextMessage	()Lcom/whatsapp/proto/E2E$Message$ExtendedTextMessage;
    //   927: invokevirtual 778	com/whatsapp/proto/E2E$Message$ExtendedTextMessage:hasMatchedText	()Z
    //   930: ifeq +187 -> 1117
    //   933: ldc_w 780
    //   936: astore 8
    //   938: goto -275 -> 663
    //   941: aload_0
    //   942: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   945: invokevirtual 783	com/whatsapp/proto/E2E$Message:hasDocumentMessage	()Z
    //   948: ifeq +11 -> 959
    //   951: ldc_w 785
    //   954: astore 8
    //   956: goto -293 -> 663
    //   959: aload_0
    //   960: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   963: invokevirtual 788	com/whatsapp/proto/E2E$Message:hasAudioMessage	()Z
    //   966: ifeq +24 -> 990
    //   969: aload_0
    //   970: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   973: invokevirtual 792	com/whatsapp/proto/E2E$Message:getAudioMessage	()Lcom/whatsapp/proto/E2E$Message$AudioMessage;
    //   976: invokevirtual 797	com/whatsapp/proto/E2E$Message$AudioMessage:getPtt	()Z
    //   979: ifeq +144 -> 1123
    //   982: ldc_w 799
    //   985: astore 8
    //   987: goto -324 -> 663
    //   990: aload_0
    //   991: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   994: invokevirtual 802	com/whatsapp/proto/E2E$Message:hasVideoMessage	()Z
    //   997: ifeq +24 -> 1021
    //   1000: aload_0
    //   1001: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   1004: invokevirtual 806	com/whatsapp/proto/E2E$Message:getVideoMessage	()Lcom/whatsapp/proto/E2E$Message$VideoMessage;
    //   1007: invokevirtual 811	com/whatsapp/proto/E2E$Message$VideoMessage:getGifPlayback	()Z
    //   1010: ifeq +121 -> 1131
    //   1013: ldc_w 813
    //   1016: astore 8
    //   1018: goto -355 -> 663
    //   1021: aload_0
    //   1022: getfield 132	com/whatsapp/jobqueue/job/SendE2EMessageJob:message	Lcom/whatsapp/proto/E2E$Message;
    //   1025: invokevirtual 816	com/whatsapp/proto/E2E$Message:hasProtocolMessage	()Z
    //   1028: pop
    //   1029: aconst_null
    //   1030: astore 8
    //   1032: goto -369 -> 663
    //   1035: astore 8
    //   1037: iconst_1
    //   1038: istore_1
    //   1039: aload 8
    //   1041: athrow
    //   1042: astore 8
    //   1044: iload_1
    //   1045: ifne +41 -> 1086
    //   1048: getstatic 67	com/whatsapp/jobqueue/job/SendE2EMessageJob:messagesBeingSent	Ljava/util/concurrent/ConcurrentHashMap;
    //   1051: new 8	com/whatsapp/jobqueue/job/SendE2EMessageJob$a
    //   1054: dup
    //   1055: new 219	com/whatsapp/protocol/j$b
    //   1058: dup
    //   1059: aload_0
    //   1060: getfield 141	com/whatsapp/jobqueue/job/SendE2EMessageJob:jid	Ljava/lang/String;
    //   1063: iconst_1
    //   1064: aload_0
    //   1065: getfield 139	com/whatsapp/jobqueue/job/SendE2EMessageJob:id	Ljava/lang/String;
    //   1068: invokespecial 222	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   1071: aload_0
    //   1072: getfield 159	com/whatsapp/jobqueue/job/SendE2EMessageJob:editVersion	I
    //   1075: aload_0
    //   1076: getfield 143	com/whatsapp/jobqueue/job/SendE2EMessageJob:participant	Ljava/lang/String;
    //   1079: invokespecial 225	com/whatsapp/jobqueue/job/SendE2EMessageJob$a:<init>	(Lcom/whatsapp/protocol/j$b;ILjava/lang/String;)V
    //   1082: invokevirtual 652	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: pop
    //   1086: aload 8
    //   1088: athrow
    //   1089: astore 8
    //   1091: iconst_0
    //   1092: istore_1
    //   1093: goto -49 -> 1044
    //   1096: iconst_0
    //   1097: istore_1
    //   1098: iload_1
    //   1099: ifeq +13 -> 1112
    //   1102: iconst_1
    //   1103: istore_2
    //   1104: goto -633 -> 471
    //   1107: iconst_0
    //   1108: istore_1
    //   1109: goto -11 -> 1098
    //   1112: iconst_0
    //   1113: istore_2
    //   1114: goto -643 -> 471
    //   1117: aconst_null
    //   1118: astore 8
    //   1120: goto -457 -> 663
    //   1123: ldc_w 818
    //   1126: astore 8
    //   1128: goto -465 -> 663
    //   1131: ldc_w 820
    //   1134: astore 8
    //   1136: goto -473 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1139	0	this	SendE2EMessageJob
    //   635	474	1	n	int
    //   473	641	2	bool1	boolean
    //   420	303	3	bool2	boolean
    //   566	113	4	l1	long
    //   573	33	6	l2	long
    //   343	688	8	localObject1	Object
    //   1035	5	8	localException	Exception
    //   1042	45	8	localObject2	Object
    //   1089	1	8	localObject3	Object
    //   1118	17	8	str1	String
    //   477	345	9	localObject4	Object
    //   154	523	10	localb	j.b
    //   352	314	11	localal	com.whatsapp.protocol.al
    //   487	267	12	localMap	Map
    //   497	199	13	localList	List
    //   523	169	14	localf	com.whatsapp.protocol.f
    //   548	116	15	localObject5	Object
    //   640	42	16	str2	String
    //   646	38	17	str3	String
    // Exception table:
    //   from	to	target	type
    //   0	30	1035	java/lang/Exception
    //   69	99	1035	java/lang/Exception
    //   138	201	1035	java/lang/Exception
    //   240	294	1035	java/lang/Exception
    //   333	409	1035	java/lang/Exception
    //   409	458	1035	java/lang/Exception
    //   458	468	1035	java/lang/Exception
    //   471	525	1035	java/lang/Exception
    //   532	550	1035	java/lang/Exception
    //   559	575	1035	java/lang/Exception
    //   579	619	1035	java/lang/Exception
    //   619	658	1035	java/lang/Exception
    //   663	722	1035	java/lang/Exception
    //   731	763	1035	java/lang/Exception
    //   802	816	1035	java/lang/Exception
    //   821	833	1035	java/lang/Exception
    //   838	848	1035	java/lang/Exception
    //   856	866	1035	java/lang/Exception
    //   874	884	1035	java/lang/Exception
    //   892	902	1035	java/lang/Exception
    //   910	933	1035	java/lang/Exception
    //   941	951	1035	java/lang/Exception
    //   959	982	1035	java/lang/Exception
    //   990	1013	1035	java/lang/Exception
    //   1021	1029	1035	java/lang/Exception
    //   1039	1042	1042	finally
    //   0	30	1089	finally
    //   69	99	1089	finally
    //   138	201	1089	finally
    //   240	294	1089	finally
    //   333	409	1089	finally
    //   409	458	1089	finally
    //   458	468	1089	finally
    //   471	525	1089	finally
    //   532	550	1089	finally
    //   559	575	1089	finally
    //   579	619	1089	finally
    //   619	658	1089	finally
    //   663	722	1089	finally
    //   731	763	1089	finally
    //   802	816	1089	finally
    //   821	833	1089	finally
    //   838	848	1089	finally
    //   856	866	1089	finally
    //   874	884	1089	finally
    //   892	902	1089	finally
    //   910	933	1089	finally
    //   941	951	1089	finally
    //   959	982	1089	finally
    //   990	1013	1089	finally
    //   1021	1029	1089	finally
  }
  
  public final void c()
  {
    Log.w("e2e send job canceled" + h());
    messagesBeingSent.remove(new a(new j.b(this.jid, true, this.id), this.editVersion, this.participant));
  }
  
  public final boolean d()
  {
    return (g()) || (super.d());
  }
  
  public static final class a
  {
    j.b a;
    int b;
    String c;
    
    public a(j.b paramb, int paramInt)
    {
      this(paramb, paramInt, null);
    }
    
    public a(j.b paramb, int paramInt, String paramString)
    {
      this.a = paramb;
      this.b = paramInt;
      this.c = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (getClass() != paramObject.getClass()) {
            return false;
          }
          paramObject = (a)paramObject;
          if (this.a == null)
          {
            if (((a)paramObject).a != null) {
              return false;
            }
          }
          else if (!this.a.equals(((a)paramObject).a)) {
            return false;
          }
          if (this.b != ((a)paramObject).b) {
            return false;
          }
          if (this.c != null) {
            break;
          }
        } while (((a)paramObject).c == null);
        return false;
      } while (this.c.equals(((a)paramObject).c));
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      int i;
      int k;
      if (this.a == null)
      {
        i = 0;
        k = this.b;
        if (this.c != null) {
          break label49;
        }
      }
      for (;;)
      {
        return ((i + 31) * 31 + k) * 31 + j;
        i = this.a.hashCode();
        break;
        label49:
        j = this.c.hashCode();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendE2EMessageJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */