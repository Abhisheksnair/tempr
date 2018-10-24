package com.whatsapp.messaging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.whatsapp.protocol.VoipOptions;
import com.whatsapp.protocol.VoipOptions.ABTest;
import com.whatsapp.protocol.VoipOptions.Aec;
import com.whatsapp.protocol.VoipOptions.Agc;
import com.whatsapp.protocol.VoipOptions.AudioRestrict;
import com.whatsapp.protocol.VoipOptions.BandwidthEstimator;
import com.whatsapp.protocol.VoipOptions.Decode;
import com.whatsapp.protocol.VoipOptions.Encode;
import com.whatsapp.protocol.VoipOptions.InitialBwe;
import com.whatsapp.protocol.VoipOptions.Miscellaneous;
import com.whatsapp.protocol.VoipOptions.NoiseSuppression;
import com.whatsapp.protocol.VoipOptions.RateControl;
import com.whatsapp.protocol.VoipOptions.RelayElection;
import com.whatsapp.protocol.VoipOptions.Resend;
import com.whatsapp.protocol.VoipOptions.TrafficShaper;
import com.whatsapp.protocol.VoipOptions.VideoBatteryRateControl;
import com.whatsapp.protocol.VoipOptions.VideoDriver;
import com.whatsapp.protocol.VoipOptions.VideoRateControl;
import com.whatsapp.protocol.VoipOptions.XorCipher;
import com.whatsapp.protocol.VoipOptions.a;
import com.whatsapp.util.Log;

public final class ParcelableVoipOptions
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVoipOptions> CREATOR = new Parcelable.Creator() {};
  public final VoipOptions a;
  private final Aec b;
  private final Agc c;
  private final AudioRestrict d;
  private final Decode e;
  private final Encode f;
  private final Miscellaneous g;
  private final NoiseSuppression h;
  private final ABTest i;
  private final RateControl j;
  private final RateControl[] k;
  private final PResend l;
  private final BandwidthEstimator m;
  private final PRelayElection n;
  private final PXorCipher o;
  private final PClient p;
  private final PVideoRateControl q;
  private final PVideoRateControl[] r;
  private final PVideoBatteryRateControl[] s;
  private final PVideoDriver t;
  private final PTrafficShaper u;
  private final PInitialBwe v;
  
  private ParcelableVoipOptions(Parcel paramParcel)
  {
    this.b = ((Aec)paramParcel.readValue(Aec.class.getClassLoader()));
    this.c = ((Agc)paramParcel.readValue(Agc.class.getClassLoader()));
    this.d = ((AudioRestrict)paramParcel.readValue(AudioRestrict.class.getClassLoader()));
    this.e = ((Decode)paramParcel.readValue(Decode.class.getClassLoader()));
    this.f = ((Encode)paramParcel.readValue(Encode.class.getClassLoader()));
    this.g = ((Miscellaneous)paramParcel.readValue(Miscellaneous.class.getClassLoader()));
    this.h = ((NoiseSuppression)paramParcel.readValue(NoiseSuppression.class.getClassLoader()));
    this.i = ((ABTest)paramParcel.readValue(ABTest.class.getClassLoader()));
    this.j = ((RateControl)paramParcel.readValue(RateControl.class.getClassLoader()));
    this.k = ((RateControl[])paramParcel.createTypedArray(RateControl.CREATOR));
    this.l = ((PResend)paramParcel.readValue(PResend.class.getClassLoader()));
    this.m = ((BandwidthEstimator)paramParcel.readValue(BandwidthEstimator.class.getClassLoader()));
    this.n = ((PRelayElection)paramParcel.readValue(PRelayElection.class.getClassLoader()));
    this.o = ((PXorCipher)paramParcel.readValue(PXorCipher.class.getClassLoader()));
    this.p = ((PClient)paramParcel.readValue(PClient.class.getClassLoader()));
    this.q = ((PVideoRateControl)paramParcel.readValue(PVideoRateControl.class.getClassLoader()));
    this.r = ((PVideoRateControl[])paramParcel.createTypedArray(PVideoRateControl.CREATOR));
    this.s = ((PVideoBatteryRateControl[])paramParcel.createTypedArray(PVideoBatteryRateControl.CREATOR));
    this.t = ((PVideoDriver)paramParcel.readValue(PVideoDriver.class.getClassLoader()));
    this.u = ((PTrafficShaper)paramParcel.readValue(PTrafficShaper.class.getClassLoader()));
    this.v = ((PInitialBwe)paramParcel.readValue(PInitialBwe.class.getClassLoader()));
    Object localObject1 = null;
    paramParcel = (Parcel)localObject1;
    int i1;
    if (this.k != null)
    {
      paramParcel = (Parcel)localObject1;
      if (this.k.length > 0)
      {
        localObject1 = new VoipOptions.RateControl[this.k.length];
        i1 = 0;
        paramParcel = (Parcel)localObject1;
        if (i1 < this.k.length)
        {
          if (this.k[i1] != null) {}
          for (paramParcel = RateControl.a(this.k[i1]);; paramParcel = null)
          {
            localObject1[i1] = paramParcel;
            Log.i("rc_dyn parcelable voip options " + i1 + " " + localObject1[i1]);
            i1 += 1;
            break;
          }
        }
      }
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (this.r != null)
    {
      localObject1 = localObject2;
      if (this.r.length > 0)
      {
        localObject2 = new VoipOptions.VideoRateControl[this.r.length];
        i1 = 0;
        localObject1 = localObject2;
        if (i1 < this.r.length)
        {
          if (this.r[i1] != null) {}
          for (localObject1 = PVideoRateControl.a(this.r[i1]);; localObject1 = null)
          {
            localObject2[i1] = localObject1;
            Log.i("vid_rc_dyn parcelable voip options " + i1 + " " + localObject2[i1]);
            i1 += 1;
            break;
          }
        }
      }
    }
    Object localObject3 = null;
    localObject2 = localObject3;
    if (this.s != null)
    {
      localObject2 = localObject3;
      if (this.s.length > 0)
      {
        localObject3 = new VoipOptions.VideoBatteryRateControl[this.s.length];
        i1 = 0;
        localObject2 = localObject3;
        if (i1 < this.s.length)
        {
          if (this.s[i1] != null) {}
          for (localObject2 = PVideoBatteryRateControl.a(this.s[i1]);; localObject2 = null)
          {
            localObject3[i1] = localObject2;
            Log.i("vid_rc_battery parcelable voip options " + i1 + " " + localObject3[i1]);
            i1 += 1;
            break;
          }
        }
      }
    }
    VoipOptions.Encode localEncode;
    label712:
    VoipOptions.Decode localDecode;
    label728:
    VoipOptions.Miscellaneous localMiscellaneous;
    label744:
    VoipOptions.Agc localAgc;
    label760:
    VoipOptions.AudioRestrict localAudioRestrict;
    label776:
    VoipOptions.NoiseSuppression localNoiseSuppression;
    label792:
    VoipOptions.ABTest localABTest;
    label808:
    VoipOptions.a locala;
    label824:
    VoipOptions.RateControl localRateControl;
    label840:
    VoipOptions.Resend localResend;
    label856:
    VoipOptions.BandwidthEstimator localBandwidthEstimator;
    label872:
    VoipOptions.RelayElection localRelayElection;
    label888:
    VoipOptions.XorCipher localXorCipher;
    label904:
    VoipOptions.VideoRateControl localVideoRateControl;
    label920:
    VoipOptions.VideoDriver localVideoDriver;
    label936:
    VoipOptions.TrafficShaper localTrafficShaper;
    if (this.b != null)
    {
      localObject3 = this.b.a;
      if (this.f == null) {
        break label1026;
      }
      localEncode = this.f.a;
      if (this.e == null) {
        break label1032;
      }
      localDecode = this.e.a;
      if (this.g == null) {
        break label1038;
      }
      localMiscellaneous = this.g.a;
      if (this.c == null) {
        break label1044;
      }
      localAgc = this.c.a;
      if (this.d == null) {
        break label1050;
      }
      localAudioRestrict = this.d.a;
      if (this.h == null) {
        break label1056;
      }
      localNoiseSuppression = this.h.a;
      if (this.i == null) {
        break label1062;
      }
      localABTest = this.i.a;
      if (this.p == null) {
        break label1068;
      }
      locala = this.p.a;
      if (this.j == null) {
        break label1074;
      }
      localRateControl = this.j.a;
      if (this.l == null) {
        break label1080;
      }
      localResend = this.l.a;
      if (this.m == null) {
        break label1086;
      }
      localBandwidthEstimator = this.m.a;
      if (this.n == null) {
        break label1092;
      }
      localRelayElection = this.n.a;
      if (this.o == null) {
        break label1098;
      }
      localXorCipher = this.o.a;
      if (this.q == null) {
        break label1104;
      }
      localVideoRateControl = PVideoRateControl.a(this.q);
      if (this.t == null) {
        break label1110;
      }
      localVideoDriver = PVideoDriver.a(this.t);
      if (this.u == null) {
        break label1116;
      }
      localTrafficShaper = this.u.a;
      label952:
      if (this.v == null) {
        break label1122;
      }
    }
    label1026:
    label1032:
    label1038:
    label1044:
    label1050:
    label1056:
    label1062:
    label1068:
    label1074:
    label1080:
    label1086:
    label1092:
    label1098:
    label1104:
    label1110:
    label1116:
    label1122:
    for (VoipOptions.InitialBwe localInitialBwe = this.v.a;; localInitialBwe = null)
    {
      this.a = new VoipOptions((VoipOptions.Aec)localObject3, localEncode, localDecode, localMiscellaneous, localAgc, localAudioRestrict, localNoiseSuppression, localABTest, locala, localRateControl, paramParcel, localResend, localBandwidthEstimator, localRelayElection, localXorCipher, localVideoRateControl, (VoipOptions.VideoRateControl[])localObject1, (VoipOptions.VideoBatteryRateControl[])localObject2, localVideoDriver, localTrafficShaper, localInitialBwe);
      return;
      localObject3 = null;
      break;
      localEncode = null;
      break label712;
      localDecode = null;
      break label728;
      localMiscellaneous = null;
      break label744;
      localAgc = null;
      break label760;
      localAudioRestrict = null;
      break label776;
      localNoiseSuppression = null;
      break label792;
      localABTest = null;
      break label808;
      locala = null;
      break label824;
      localRateControl = null;
      break label840;
      localResend = null;
      break label856;
      localBandwidthEstimator = null;
      break label872;
      localRelayElection = null;
      break label888;
      localXorCipher = null;
      break label904;
      localVideoRateControl = null;
      break label920;
      localVideoDriver = null;
      break label936;
      localTrafficShaper = null;
      break label952;
    }
  }
  
  public ParcelableVoipOptions(VoipOptions paramVoipOptions)
  {
    this.a = paramVoipOptions;
    if (paramVoipOptions.aec != null)
    {
      localObject1 = new Aec(paramVoipOptions.aec, (byte)0);
      this.b = ((Aec)localObject1);
      if (paramVoipOptions.agc == null) {
        break label307;
      }
      localObject1 = new Agc(paramVoipOptions.agc, (byte)0);
      label57:
      this.c = ((Agc)localObject1);
      if (paramVoipOptions.audioRestrict == null) {
        break label312;
      }
      localObject1 = new AudioRestrict(paramVoipOptions.audioRestrict, (byte)0);
      label82:
      this.d = ((AudioRestrict)localObject1);
      if (paramVoipOptions.decode == null) {
        break label317;
      }
      localObject1 = new Decode(paramVoipOptions.decode, (byte)0);
      label107:
      this.e = ((Decode)localObject1);
      if (paramVoipOptions.encode == null) {
        break label322;
      }
      localObject1 = new Encode(paramVoipOptions.encode, (byte)0);
      label132:
      this.f = ((Encode)localObject1);
      if (paramVoipOptions.miscellaneous == null) {
        break label327;
      }
      localObject1 = new Miscellaneous(paramVoipOptions.miscellaneous, (byte)0);
      label157:
      this.g = ((Miscellaneous)localObject1);
      if (paramVoipOptions.noiseSuppression == null) {
        break label332;
      }
      localObject1 = new NoiseSuppression(paramVoipOptions.noiseSuppression, (byte)0);
      label182:
      this.h = ((NoiseSuppression)localObject1);
      if (paramVoipOptions.abTest == null) {
        break label337;
      }
      localObject1 = new ABTest(paramVoipOptions.abTest, (byte)0);
      label207:
      this.i = ((ABTest)localObject1);
      if (paramVoipOptions.rateControl == null) {
        break label342;
      }
    }
    int i1;
    label307:
    label312:
    label317:
    label322:
    label327:
    label332:
    label337:
    label342:
    for (Object localObject1 = new RateControl(paramVoipOptions.rateControl, (byte)0);; localObject1 = null)
    {
      this.j = ((RateControl)localObject1);
      if ((paramVoipOptions.rateControlOptions == null) || (paramVoipOptions.rateControlOptions.length <= 0)) {
        break label347;
      }
      this.k = new RateControl[paramVoipOptions.rateControlOptions.length];
      i1 = 0;
      while (i1 < paramVoipOptions.rateControlOptions.length)
      {
        this.k[i1] = new RateControl(paramVoipOptions.rateControlOptions[i1], 0);
        i1 += 1;
      }
      localObject1 = null;
      break;
      localObject1 = null;
      break label57;
      localObject1 = null;
      break label82;
      localObject1 = null;
      break label107;
      localObject1 = null;
      break label132;
      localObject1 = null;
      break label157;
      localObject1 = null;
      break label182;
      localObject1 = null;
      break label207;
    }
    label347:
    this.k = null;
    if (paramVoipOptions.resend != null)
    {
      localObject1 = new PResend(paramVoipOptions.resend, (byte)0);
      this.l = ((PResend)localObject1);
      if (paramVoipOptions.bwe == null) {
        break label572;
      }
      localObject1 = new BandwidthEstimator(paramVoipOptions.bwe, (byte)0);
      label397:
      this.m = ((BandwidthEstimator)localObject1);
      if (paramVoipOptions.re == null) {
        break label577;
      }
      localObject1 = new PRelayElection(paramVoipOptions.re, (byte)0);
      label422:
      this.n = ((PRelayElection)localObject1);
      if (paramVoipOptions.xc == null) {
        break label582;
      }
      localObject1 = new PXorCipher(paramVoipOptions.xc, (byte)0);
      label447:
      this.o = ((PXorCipher)localObject1);
      if (paramVoipOptions.client == null) {
        break label587;
      }
      localObject1 = new PClient(paramVoipOptions.client, (byte)0);
      label472:
      this.p = ((PClient)localObject1);
      if (paramVoipOptions.videoRateControl == null) {
        break label592;
      }
    }
    label572:
    label577:
    label582:
    label587:
    label592:
    for (localObject1 = new PVideoRateControl(paramVoipOptions.videoRateControl, (byte)0);; localObject1 = null)
    {
      this.q = ((PVideoRateControl)localObject1);
      if ((paramVoipOptions.videoRateControlOptions == null) || (paramVoipOptions.videoRateControlOptions.length <= 0)) {
        break label597;
      }
      this.r = new PVideoRateControl[paramVoipOptions.videoRateControlOptions.length];
      i1 = 0;
      while (i1 < paramVoipOptions.videoRateControlOptions.length)
      {
        this.r[i1] = new PVideoRateControl(paramVoipOptions.videoRateControlOptions[i1], 0);
        i1 += 1;
      }
      localObject1 = null;
      break;
      localObject1 = null;
      break label397;
      localObject1 = null;
      break label422;
      localObject1 = null;
      break label447;
      localObject1 = null;
      break label472;
    }
    label597:
    this.r = null;
    if ((paramVoipOptions.videoBatteryRateControl != null) && (paramVoipOptions.videoBatteryRateControl.length > 0))
    {
      this.s = new PVideoBatteryRateControl[paramVoipOptions.videoBatteryRateControl.length];
      i1 = 0;
    }
    while (i1 < paramVoipOptions.videoBatteryRateControl.length)
    {
      this.s[i1] = new PVideoBatteryRateControl(paramVoipOptions.videoBatteryRateControl[i1], 0);
      i1 += 1;
      continue;
      this.s = null;
    }
    if (paramVoipOptions.videoDriver != null)
    {
      localObject1 = new PVideoDriver(paramVoipOptions.videoDriver, (byte)0);
      this.t = ((PVideoDriver)localObject1);
      if (paramVoipOptions.trafficShaper == null) {
        break label756;
      }
    }
    label756:
    for (localObject1 = new PTrafficShaper(paramVoipOptions.trafficShaper, (byte)0);; localObject1 = null)
    {
      this.u = ((PTrafficShaper)localObject1);
      localObject1 = localObject2;
      if (paramVoipOptions.initialBwe != null) {
        localObject1 = new PInitialBwe(paramVoipOptions.initialBwe, (byte)0);
      }
      this.v = ((PInitialBwe)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.b);
    paramParcel.writeValue(this.c);
    paramParcel.writeValue(this.d);
    paramParcel.writeValue(this.e);
    paramParcel.writeValue(this.f);
    paramParcel.writeValue(this.g);
    paramParcel.writeValue(this.h);
    paramParcel.writeValue(this.i);
    paramParcel.writeValue(this.j);
    paramParcel.writeTypedArray(this.k, 0);
    paramParcel.writeValue(this.l);
    paramParcel.writeValue(this.m);
    paramParcel.writeValue(this.n);
    paramParcel.writeValue(this.o);
    paramParcel.writeValue(this.p);
    paramParcel.writeValue(this.q);
    paramParcel.writeTypedArray(this.r, 0);
    paramParcel.writeTypedArray(this.s, 0);
    paramParcel.writeValue(this.t);
    paramParcel.writeValue(this.u);
    paramParcel.writeValue(this.v);
  }
  
  public static final class ABTest
    implements Parcelable
  {
    public static final Parcelable.Creator<ABTest> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.ABTest a;
    
    private ABTest(Parcel paramParcel)
    {
      this.a = new VoipOptions.ABTest(paramParcel.readString());
    }
    
    private ABTest(VoipOptions.ABTest paramABTest)
    {
      this.a = paramABTest;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a.name);
    }
  }
  
  static final class Aec
    implements Parcelable
  {
    public static final Parcelable.Creator<Aec> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Aec a;
    
    private Aec(Parcel paramParcel)
    {
      this.a = new VoipOptions.Aec(paramParcel.readString(), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private Aec(VoipOptions.Aec paramAec)
    {
      this.a = paramAec;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a.algorithm);
      paramParcel.writeValue(this.a.offset);
      paramParcel.writeValue(this.a.length);
      paramParcel.writeValue(this.a.mode);
      paramParcel.writeValue(this.a.speakerMode);
      paramParcel.writeValue(this.a.echoDetectorImpl);
      paramParcel.writeValue(this.a.echoDetectorMode);
      paramParcel.writeValue(this.a.ecThreshold);
      paramParcel.writeValue(this.a.ecOffThreshold);
      paramParcel.writeValue(this.a.strengthThreshold);
      paramParcel.writeValue(this.a.builtinEnabled);
      paramParcel.writeValue(this.a.disableSwEcWhenBuiltinAvailable);
      paramParcel.writeValue(this.a.toneDetectorEnabled);
      paramParcel.writeValue(this.a.disableAgc);
      paramParcel.writeValue(this.a.useCleanCapture);
      paramParcel.writeValue(this.a.aecmDynamicQ);
      paramParcel.writeValue(this.a.aecmAdaptStepSize);
      paramParcel.writeValue(this.a.aecmSupgainScale);
      paramParcel.writeValue(this.a.aecmDataWidth);
    }
  }
  
  static final class Agc
    implements Parcelable
  {
    public static final Parcelable.Creator<Agc> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Agc a;
    
    private Agc(Parcel paramParcel)
    {
      this.a = new VoipOptions.Agc((Short)paramParcel.readValue(Short.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private Agc(VoipOptions.Agc paramAgc)
    {
      this.a = paramAgc;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.targetLevel);
      paramParcel.writeValue(this.a.compressionGain);
      paramParcel.writeValue(this.a.enableLimiter);
      paramParcel.writeValue(this.a.mode);
      paramParcel.writeValue(this.a.builtinEnabled);
      paramParcel.writeValue(this.a.strengthThreshold);
    }
  }
  
  static final class AudioRestrict
    implements Parcelable
  {
    public static final Parcelable.Creator<AudioRestrict> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.AudioRestrict a;
    
    private AudioRestrict(Parcel paramParcel)
    {
      this.a = new VoipOptions.AudioRestrict(paramParcel.readString(), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private AudioRestrict(VoipOptions.AudioRestrict paramAudioRestrict)
    {
      this.a = paramAudioRestrict;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a.encoding);
      paramParcel.writeValue(this.a.rate);
    }
  }
  
  static final class BandwidthEstimator
    implements Parcelable
  {
    public static final Parcelable.Creator<BandwidthEstimator> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.BandwidthEstimator a;
    
    private BandwidthEstimator(Parcel paramParcel)
    {
      this.a = new VoipOptions.BandwidthEstimator((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()));
    }
    
    private BandwidthEstimator(VoipOptions.BandwidthEstimator paramBandwidthEstimator)
    {
      this.a = paramBandwidthEstimator;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.maxUnknownOnRateIncrease);
      paramParcel.writeValue(this.a.useAudioPacketRate);
      paramParcel.writeValue(this.a.resetRccOnBweReset);
      paramParcel.writeValue(this.a.resetOudTimestampOnBweReset);
      paramParcel.writeValue(this.a.actionOnRtpMarker);
      paramParcel.writeValue(this.a.bweImpl);
      paramParcel.writeValue(this.a.maxTrainSpacing);
      paramParcel.writeValue(this.a.outageGracePeriod);
      paramParcel.writeValue(this.a.blur);
      paramParcel.writeValue(this.a.tickLength);
      paramParcel.writeValue(this.a.outageEntryRate);
      paramParcel.writeValue(this.a.outageExitRate);
    }
  }
  
  static final class Decode
    implements Parcelable
  {
    public static final Parcelable.Creator<Decode> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Decode a;
    
    private Decode(Parcel paramParcel)
    {
      this.a = new VoipOptions.Decode((Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()));
    }
    
    private Decode(VoipOptions.Decode paramDecode)
    {
      this.a = paramDecode;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.gain);
      paramParcel.writeValue(this.a.forwardErrorCorrection);
      paramParcel.writeValue(this.a.plc);
    }
  }
  
  static final class Encode
    implements Parcelable
  {
    public static final Parcelable.Creator<Encode> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Encode a;
    
    private Encode(Parcel paramParcel)
    {
      this.a = new VoipOptions.Encode((Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private Encode(VoipOptions.Encode paramEncode)
    {
      this.a = paramEncode;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.complexity);
      paramParcel.writeValue(this.a.enableConstantBitrate);
      paramParcel.writeValue(this.a.enableDiscontinuousTransmission);
      paramParcel.writeValue(this.a.targetBitrate);
      paramParcel.writeValue(this.a.forwardErrorCorrection);
      paramParcel.writeValue(this.a.vadThreshold);
      paramParcel.writeValue(this.a.nonSpeechBitrate);
      paramParcel.writeValue(this.a.selectivelySkipNonSpeechFrames);
      paramParcel.writeValue(this.a.frameMs);
    }
  }
  
  static final class Miscellaneous
    implements Parcelable
  {
    public static final Parcelable.Creator<Miscellaneous> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Miscellaneous a;
    
    private Miscellaneous(Parcel paramParcel)
    {
      this.a = new VoipOptions.Miscellaneous((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), paramParcel.readString(), paramParcel.readString(), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (String)paramParcel.readValue(String.class.getClassLoader()), (String)paramParcel.readValue(String.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private Miscellaneous(VoipOptions.Miscellaneous paramMiscellaneous)
    {
      this.a = paramMiscellaneous;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.enableComfortNoiseGeneration);
      paramParcel.writeValue(this.a.enableHighPassFiltering);
      paramParcel.writeValue(this.a.enableSilenceDetection);
      paramParcel.writeValue(this.a.callerTimeout);
      paramParcel.writeValue(this.a.jitterBufferImpl);
      paramParcel.writeValue(this.a.jitterBufferDiscardAlgo);
      paramParcel.writeValue(this.a.jitterBufferStretchAlgo);
      paramParcel.writeValue(this.a.audioCallbackThreshold);
      paramParcel.writeValue(this.a.ringbackMode);
      paramParcel.writeValue(this.a.ringbackTone);
      paramParcel.writeValue(this.a.callerEndCallThreshold);
      paramParcel.writeValue(this.a.audioSamplingRate);
      paramParcel.writeValue(this.a.androidAudioEngine);
      paramParcel.writeValue(this.a.androidAudioModeInCall);
      paramParcel.writeValue(this.a.androidRecordPreset);
      paramParcel.writeValue(this.a.androidAudioRecordBufferSize);
      paramParcel.writeValue(this.a.androidAudioPlaybackBufferSize);
      paramParcel.writeValue(this.a.androidShowCallConnectedToast);
      paramParcel.writeValue(this.a.androidShowCallConnectingToast);
      paramParcel.writeValue(this.a.androidRingFaster);
      paramParcel.writeValue(this.a.udpReceiveSocketBufferSize);
      paramParcel.writeValue(this.a.audioEncodeOffload);
      paramParcel.writeValue(this.a.disableP2P);
      paramParcel.writeValue(this.a.createStreamOnOffer);
      paramParcel.writeValue(this.a.initialInterruptionSoundDelay);
      paramParcel.writeValue(this.a.audioFPSThreshold);
      paramParcel.writeValue(this.a.networkRestartTimeout);
      paramParcel.writeValue(this.a.neteqMinDelay);
      paramParcel.writeValue(this.a.neteqMaxDelay);
      paramParcel.writeValue(this.a.neteqBgnMode);
      paramParcel.writeValue(this.a.neteqEnableFF);
      paramParcel.writeValue(this.a.neteqIatProb);
      paramParcel.writeValue(this.a.neteqIatFactor);
      paramParcel.writeValue(this.a.neteqPeakHeight);
      paramParcel.writeValue(this.a.neteqPeakMaxPeriod);
      paramParcel.writeValue(this.a.neteqCumulativePeakMaxPeriod);
      paramParcel.writeValue(this.a.neteqMaxPacketsInBuf);
      paramParcel.writeValue(this.a.audioLevelAdjust);
      paramParcel.writeValue(this.a.restartAudioOnWhiteNoise);
      paramParcel.writeValue(this.a.callOfferAckTimeout);
      paramParcel.writeString(this.a.testKey);
      paramParcel.writeString(this.a.testValue);
      paramParcel.writeValue(this.a.ipConfig);
      paramParcel.writeValue(this.a.ipAutoSwitch);
      paramParcel.writeValue(this.a.rtpExtType);
      paramParcel.writeValue(this.a.e2eDecryptEnable);
      paramParcel.writeValue(this.a.spamCallThresholdDuration);
      paramParcel.writeValue(this.a.videoCodecPriority);
      paramParcel.writeValue(this.a.vp8Cpu);
      paramParcel.writeValue(this.a.lowBatteryNotifyThreshold);
      paramParcel.writeValue(this.a.callStartDelay);
      paramParcel.writeValue(this.a.dimScreenPercentage);
      paramParcel.writeValue(this.a.enableUpnp);
      paramParcel.writeValue(this.a.enablePortPredicting);
      paramParcel.writeValue(this.a.portPredictingRange);
      paramParcel.writeValue(this.a.doPortPredictingUnconditionally);
      paramParcel.writeValue(this.a.enableNewTransportStats);
      paramParcel.writeValue(this.a.transportStatsP2pThreshold);
      paramParcel.writeValue(this.a.enableP2pDuplex);
      paramParcel.writeValue(this.a.txNetCondParamsInJson);
      paramParcel.writeValue(this.a.rxNetCondParamsInJson);
      paramParcel.writeValue(this.a.isOpenGLYUVRenderEnabled);
      paramParcel.writeValue(this.a.setupVideoStreamBeforeAccept);
      paramParcel.writeValue(this.a.preciseRxTimestampsMask);
      paramParcel.writeValue(this.a.connectedIfReceivedData);
      paramParcel.writeValue(this.a.mtuSize);
      paramParcel.writeValue(this.a.txCacheSizePkts);
      paramParcel.writeValue(this.a.vidJbMaxMs);
      paramParcel.writeValue(this.a.maxAudioTsJitterMs);
      paramParcel.writeValue(this.a.enablePreacceptReceivedUpdate);
      paramParcel.writeValue(this.a.initAudioInPreaccept);
      paramParcel.writeValue(this.a.enableVoipCapability);
      paramParcel.writeValue(this.a.avSyncThresholdMs);
      paramParcel.writeValue(this.a.doUpnpCallback);
      paramParcel.writeValue(this.a.maxAudioFrameDisorderDistance);
      paramParcel.writeValue(this.a.enableLTRP);
      paramParcel.writeValue(this.a.vidDecOnNetThread);
    }
  }
  
  static final class NoiseSuppression
    implements Parcelable
  {
    public static final Parcelable.Creator<NoiseSuppression> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.NoiseSuppression a;
    
    private NoiseSuppression(Parcel paramParcel)
    {
      this.a = new VoipOptions.NoiseSuppression((Short)paramParcel.readValue(Short.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private NoiseSuppression(VoipOptions.NoiseSuppression paramNoiseSuppression)
    {
      this.a = paramNoiseSuppression;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.mode);
      paramParcel.writeValue(this.a.builtinEnabled);
      paramParcel.writeValue(this.a.suppressThreshold);
    }
  }
  
  public static final class PClient
    implements Parcelable
  {
    public static final Parcelable.Creator<PClient> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.a a;
    
    private PClient(Parcel paramParcel)
    {
      this.a = new VoipOptions.a((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    }
    
    private PClient(VoipOptions.a parama)
    {
      this.a = parama;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.a);
      paramParcel.writeValue(this.a.b);
    }
  }
  
  public static final class PInitialBwe
    implements Parcelable
  {
    public static final Parcelable.Creator<PInitialBwe> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.InitialBwe a;
    
    private PInitialBwe(Parcel paramParcel)
    {
      this.a = new VoipOptions.InitialBwe((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private PInitialBwe(VoipOptions.InitialBwe paramInitialBwe)
    {
      this.a = paramInitialBwe;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.maxBytes);
      paramParcel.writeValue(this.a.minBitrate);
      paramParcel.writeValue(this.a.maxBitrate);
      paramParcel.writeValue(this.a.maxTxRottBasedBitrate);
      paramParcel.writeValue(this.a.delayMs);
      paramParcel.writeValue(this.a.testFlags);
    }
  }
  
  static final class PRelayElection
    implements Parcelable
  {
    public static final Parcelable.Creator<PRelayElection> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.RelayElection a;
    
    private PRelayElection(Parcel paramParcel)
    {
      this.a = new VoipOptions.RelayElection((Short)paramParcel.readValue(Short.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Short)paramParcel.readValue(Short.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private PRelayElection(VoipOptions.RelayElection paramRelayElection)
    {
      this.a = paramRelayElection;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.mode);
      paramParcel.writeValue(this.a.timestampSource);
      paramParcel.writeValue(this.a.pingCalcMode);
      paramParcel.writeValue(this.a.pingInterval);
      paramParcel.writeValue(this.a.pingRounds);
      paramParcel.writeValue(this.a.pingUpdateInterval);
      paramParcel.writeValue(this.a.p2pRequestTimeout);
    }
  }
  
  public static final class PResend
    implements Parcelable
  {
    public static final Parcelable.Creator<PResend> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.Resend a;
    
    private PResend(Parcel paramParcel)
    {
      this.a = new VoipOptions.Resend((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    }
    
    private PResend(VoipOptions.Resend paramResend)
    {
      this.a = paramResend;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.packetLossThreshold);
      paramParcel.writeValue(this.a.bweThreshold);
      paramParcel.writeValue(this.a.maxBitrate);
      paramParcel.writeValue(this.a.delayPackets);
      paramParcel.writeValue(this.a.forceDtx);
      paramParcel.writeValue(this.a.dryRun);
    }
  }
  
  public static final class PTrafficShaper
    implements Parcelable
  {
    public static final Parcelable.Creator<PTrafficShaper> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.TrafficShaper a;
    
    private PTrafficShaper(Parcel paramParcel)
    {
      this.a = new VoipOptions.TrafficShaper((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private PTrafficShaper(VoipOptions.TrafficShaper paramTrafficShaper)
    {
      this.a = paramTrafficShaper;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.minSpacing);
      paramParcel.writeValue(this.a.tickLength);
      paramParcel.writeValue(this.a.windowSize);
      paramParcel.writeValue(this.a.audioPriority);
      paramParcel.writeValue(this.a.maxDelay);
      paramParcel.writeValue(this.a.maxPackets);
      paramParcel.writeValue(this.a.maxBitrateMultiplier);
      paramParcel.writeValue(this.a.dropThreshold);
      paramParcel.writeValue(this.a.queueStrategy);
      paramParcel.writeValue(this.a.temporalPacketDrop);
    }
  }
  
  public static final class PVideoBatteryRateControl
    implements Parcelable
  {
    public static final Parcelable.Creator<PVideoBatteryRateControl> CREATOR = new Parcelable.Creator() {};
    private final VoipOptions.VideoBatteryRateControl a;
    
    private PVideoBatteryRateControl(Parcel paramParcel)
    {
      this.a = new VoipOptions.VideoBatteryRateControl((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private PVideoBatteryRateControl(VoipOptions.VideoBatteryRateControl paramVideoBatteryRateControl)
    {
      this.a = paramVideoBatteryRateControl;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.dropThreshold);
      paramParcel.writeValue(this.a.lowThreshold);
      paramParcel.writeValue(this.a.maxBitrate);
      paramParcel.writeValue(this.a.maxFps);
      paramParcel.writeValue(this.a.maxWidth);
    }
  }
  
  public static final class PVideoDriver
    implements Parcelable
  {
    public static final Parcelable.Creator<PVideoDriver> CREATOR = new Parcelable.Creator() {};
    private final VoipOptions.VideoDriver a;
    
    private PVideoDriver(Parcel paramParcel)
    {
      this.a = new VoipOptions.VideoDriver((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (String)paramParcel.readValue(String.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (String)paramParcel.readValue(String.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private PVideoDriver(VoipOptions.VideoDriver paramVideoDriver)
    {
      this.a = paramVideoDriver;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.cameraWidth);
      paramParcel.writeValue(this.a.cameraHeight);
      paramParcel.writeValue(this.a.backCameraWidth);
      paramParcel.writeValue(this.a.backCameraHeight);
      paramParcel.writeValue(this.a.encoderName);
      paramParcel.writeValue(this.a.encoderColorFormat);
      paramParcel.writeValue(this.a.encoderFrameConverterColorId);
      paramParcel.writeValue(this.a.encoderAlignment);
      paramParcel.writeValue(this.a.encoderMinWidth);
      paramParcel.writeValue(this.a.encoderMinHeight);
      paramParcel.writeValue(this.a.encoderH264Profile);
      paramParcel.writeValue(this.a.encoderH264Level);
      paramParcel.writeValue(this.a.decoderName);
      paramParcel.writeValue(this.a.decoderColorFormat);
      paramParcel.writeValue(this.a.decoderFrameConverterColorId);
      paramParcel.writeValue(this.a.decoderBaselineHack);
      paramParcel.writeValue(this.a.decoderRestrictionHack);
      paramParcel.writeValue(this.a.decoderConstrainedHighHack);
      paramParcel.writeValue(this.a.decoderCsdHack);
      paramParcel.writeValue(this.a.decoderRestartOnNewSpsPps);
    }
  }
  
  public static final class PVideoRateControl
    implements Parcelable
  {
    public static final Parcelable.Creator<PVideoRateControl> CREATOR = new Parcelable.Creator() {};
    private final VoipOptions.VideoRateControl a;
    
    private PVideoRateControl(Parcel paramParcel)
    {
      this.a = new VoipOptions.VideoRateControl((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    }
    
    private PVideoRateControl(VoipOptions.VideoRateControl paramVideoRateControl)
    {
      this.a = paramVideoRateControl;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.stop);
      paramParcel.writeValue(this.a.vp8BitrateMultiplier);
      paramParcel.writeValue(this.a.vp8DropFrameThreshold);
      paramParcel.writeValue(this.a.vp8NoiseSensitivity);
      paramParcel.writeValue(this.a.vp8MinQp);
      paramParcel.writeValue(this.a.vp8MaxQp);
      paramParcel.writeValue(this.a.vp8ErrorResilient);
      paramParcel.writeValue(this.a.vp8StaticThreshold);
      paramParcel.writeValue(this.a.vp8TemporalMode);
      paramParcel.writeValue(this.a.vp8EncMaxLatency);
      paramParcel.writeValue(this.a.minRtt);
      paramParcel.writeValue(this.a.maxRtt);
      paramParcel.writeValue(this.a.netMedium);
      paramParcel.writeValue(this.a.packetLossMode);
      paramParcel.writeValue(this.a.senderLossLow);
      paramParcel.writeValue(this.a.senderLossHigh);
      paramParcel.writeValue(this.a.senderIncRatio);
      paramParcel.writeValue(this.a.senderDecRatio);
      paramParcel.writeValue(this.a.minTargetBitrate);
      paramParcel.writeValue(this.a.maxTargetBitrate);
      paramParcel.writeValue(this.a.rcPolicy);
      paramParcel.writeValue(this.a.maxCaptureWidth);
      paramParcel.writeValue(this.a.maxEncodeWidth);
      paramParcel.writeValue(this.a.maxFps);
      paramParcel.writeValue(this.a.keyFrameInterval);
      paramParcel.writeValue(this.a.lowDataUsageBitrate);
      paramParcel.writeValue(this.a.cellularBitrate);
      paramParcel.writeValue(this.a.encoderFormatChangeWaitMs);
      paramParcel.writeValue(this.a.minPacketLossPct);
      paramParcel.writeValue(this.a.maxPacketLossPct);
      paramParcel.writeValue(this.a.minFecRatio);
      paramParcel.writeValue(this.a.maxFecRatio);
      paramParcel.writeValue(this.a.fecToPacketLossTimes10);
      paramParcel.writeValue(this.a.fecForKeyFrame);
      paramParcel.writeValue(this.a.codecType);
      paramParcel.writeValue(this.a.codecSubType);
      paramParcel.writeValue(this.a.maxKeyFrameModeBitrate);
      paramParcel.writeValue(this.a.enableFrameDropper);
      paramParcel.writeValue(this.a.minSenderEstimateOnDrop);
      paramParcel.writeValue(this.a.minSenderEstimateOnTarget);
      paramParcel.writeValue(this.a.monochromeModeRatio);
      paramParcel.writeValue(this.a.senderSideRcPolicy);
      paramParcel.writeValue(this.a.initBitrate);
      paramParcel.writeValue(this.a.packetLossThresholdInPackets);
      paramParcel.writeValue(this.a.packetLossThresholdInMilliseconds);
      paramParcel.writeValue(this.a.minBwe);
      paramParcel.writeValue(this.a.maxBwe);
      paramParcel.writeValue(this.a.vsceEnabled);
      paramParcel.writeValue(this.a.vsceEmaHigherFreqWeight);
      paramParcel.writeValue(this.a.vsceEmaLowerFreqWeight);
      paramParcel.writeValue(this.a.vsceEmaCrossMargin);
      paramParcel.writeValue(this.a.vsceEmaPktLossSizeWeight);
      paramParcel.writeValue(this.a.vsceBurstPktLossThreshold);
      paramParcel.writeValue(this.a.vsceAlternateLatencyWindowSize);
      paramParcel.writeValue(this.a.vsceDelayResponseRttRatio);
      paramParcel.writeValue(this.a.vsceAbsLatencyTopEndThreshold);
      paramParcel.writeValue(this.a.vsceHighRttThreshold);
      paramParcel.writeValue(this.a.vsceFecPktLossThreshold);
      paramParcel.writeValue(this.a.vsceFecPktLossRatio);
      paramParcel.writeValue(this.a.vsceInitialCautiousPeriod);
      paramParcel.writeValue(this.a.bitrateHysteresis);
      paramParcel.writeValue(this.a.rttHysteresis);
      paramParcel.writeValue(this.a.pktLossHysteresis);
      paramParcel.writeValue(this.a.minDecreaseFactorOnCongestion);
      paramParcel.writeValue(this.a.maxDecreaseFactorOnCongestion);
      paramParcel.writeValue(this.a.initialRttCongestionThreshold);
      paramParcel.writeValue(this.a.rttCongestionStepHighest);
      paramParcel.writeValue(this.a.rttCongestionStepPrevious);
      paramParcel.writeValue(this.a.rttCongestionStepEMA);
      paramParcel.writeValue(this.a.stopVideoEncodingRttThreshold);
      paramParcel.writeValue(this.a.doubleRttCongestionThreshold);
      paramParcel.writeValue(this.a.noRtcpReceivedThreshold);
      paramParcel.writeValue(this.a.noDataReceivedThreshold);
      paramParcel.writeValue(this.a.minPacketsPerFrame);
      paramParcel.writeValue(this.a.equalizePacketSizes);
      paramParcel.writeValue(this.a.minFragmentationSize);
      paramParcel.writeValue(this.a.constraintAudioBitrateThreshold);
      paramParcel.writeValue(this.a.nackRttInteractiveThreshold);
      paramParcel.writeValue(this.a.nackRttUltraLowThreshold);
      paramParcel.writeValue(this.a.nackOnlyAfterKeyframe);
    }
  }
  
  static final class PXorCipher
    implements Parcelable
  {
    public static final Parcelable.Creator<PXorCipher> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.XorCipher a;
    
    private PXorCipher(Parcel paramParcel)
    {
      this.a = new VoipOptions.XorCipher((Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    }
    
    private PXorCipher(VoipOptions.XorCipher paramXorCipher)
    {
      this.a = paramXorCipher;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.p1);
      paramParcel.writeValue(this.a.p2);
      paramParcel.writeValue(this.a.onRtp);
    }
  }
  
  static final class RateControl
    implements Parcelable
  {
    public static final Parcelable.Creator<RateControl> CREATOR = new Parcelable.Creator() {};
    final VoipOptions.RateControl a;
    
    private RateControl(Parcel paramParcel)
    {
      this.a = new VoipOptions.RateControl((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Float)paramParcel.readValue(Float.class.getClassLoader()), (Integer)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Boolean)paramParcel.readValue(Boolean.class.getClassLoader()), (Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    }
    
    private RateControl(VoipOptions.RateControl paramRateControl)
    {
      this.a = paramRateControl;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeValue(this.a.stop);
      paramParcel.writeValue(this.a.condMinPacketLossPct);
      paramParcel.writeValue(this.a.condMaxPacketLossPct);
      paramParcel.writeValue(this.a.condMinTargetTotalBitrate);
      paramParcel.writeValue(this.a.condMaxTargetTotalBitrate);
      paramParcel.writeValue(this.a.condMinRtt);
      paramParcel.writeValue(this.a.condMaxRtt);
      paramParcel.writeValue(this.a.condNetMedium);
      paramParcel.writeValue(this.a.totalBitrateHysteresis);
      paramParcel.writeValue(this.a.packetLossHysteresis);
      paramParcel.writeValue(this.a.rttHysteresis);
      paramParcel.writeValue(this.a.disableRateControl);
      paramParcel.writeValue(this.a.framesPerPacket);
      paramParcel.writeValue(this.a.minRTT);
      paramParcel.writeValue(this.a.maxRTT);
      paramParcel.writeValue(this.a.initBitrate);
      paramParcel.writeValue(this.a.minFramesPerPacket);
      paramParcel.writeValue(this.a.maxFramesPerPacket);
      paramParcel.writeValue(this.a.maxFramesPerPacketDuration);
      paramParcel.writeValue(this.a.cellularBitrate);
      paramParcel.writeValue(this.a.pktSizeThresholdBitrate);
      paramParcel.writeValue(this.a.lowDataUsageBitrate);
      paramParcel.writeValue(this.a.maxrttRateIncrease);
      paramParcel.writeValue(this.a.initBitrateOnCellular);
      paramParcel.writeValue(this.a.maxrttBitrateCap);
      paramParcel.writeValue(this.a.maxBWE);
      paramParcel.writeValue(this.a.maxrttPauseOnRttIncrease);
      paramParcel.writeValue(this.a.earlyRtt);
      paramParcel.writeValue(this.a.sendEarlyBWE);
      paramParcel.writeValue(this.a.dtxRttThreshold);
      paramParcel.writeValue(this.a.dtxBweThreshold);
      paramParcel.writeValue(this.a.dtxWaitPeriod);
      paramParcel.writeValue(this.a.fppRttThreshold);
      paramParcel.writeValue(this.a.enableAudioOobFecFeature);
      paramParcel.writeValue(this.a.audioOobFec);
      paramParcel.writeValue(this.a.audioOobFecRatio);
      paramParcel.writeValue(this.a.audioOobFecMinPkts);
      paramParcel.writeValue(this.a.audioOobFecMaxPkts);
      paramParcel.writeValue(this.a.enableAudioPiggybackFeature);
      paramParcel.writeValue(this.a.audioPiggyback);
      paramParcel.writeValue(this.a.audioOobFecPiggyback);
      paramParcel.writeValue(this.a.audioPiggybackTimeoutMsec);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ParcelableVoipOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */