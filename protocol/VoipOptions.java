package com.whatsapp.protocol;

import android.support.annotation.Keep;

@Keep
public final class VoipOptions
{
  private static final String INVALID_CONFIG_PREFIX = "INVALID";
  public static final int MAX_NUM_AUDIO_RATE_CONTROL_OPTIONS = 32;
  public static final int MAX_NUM_VIDEO_RATE_CONTROL_OPTIONS = 32;
  public final ABTest abTest;
  public final Aec aec;
  public final Agc agc;
  public final AudioRestrict audioRestrict;
  public final BandwidthEstimator bwe;
  public final a client;
  public final Decode decode;
  public final Encode encode;
  public final InitialBwe initialBwe;
  public final Miscellaneous miscellaneous;
  public final NoiseSuppression noiseSuppression;
  public final RateControl rateControl;
  public final RateControl[] rateControlOptions;
  public final RelayElection re;
  public byte[] reflAddr = null;
  public final Resend resend;
  public final TrafficShaper trafficShaper;
  public final VideoBatteryRateControl[] videoBatteryRateControl;
  public final VideoDriver videoDriver;
  public final VideoRateControl videoRateControl;
  public final VideoRateControl[] videoRateControlOptions;
  public final XorCipher xc;
  
  public VoipOptions()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }
  
  public VoipOptions(Aec paramAec, Encode paramEncode, Decode paramDecode, Miscellaneous paramMiscellaneous, Agc paramAgc, AudioRestrict paramAudioRestrict, NoiseSuppression paramNoiseSuppression, ABTest paramABTest, a parama, RateControl paramRateControl, RateControl[] paramArrayOfRateControl, Resend paramResend, BandwidthEstimator paramBandwidthEstimator, RelayElection paramRelayElection, XorCipher paramXorCipher, VideoRateControl paramVideoRateControl, VideoRateControl[] paramArrayOfVideoRateControl, VideoBatteryRateControl[] paramArrayOfVideoBatteryRateControl, VideoDriver paramVideoDriver, TrafficShaper paramTrafficShaper, InitialBwe paramInitialBwe)
  {
    this.aec = paramAec;
    this.encode = paramEncode;
    this.decode = paramDecode;
    this.miscellaneous = paramMiscellaneous;
    this.agc = paramAgc;
    this.audioRestrict = paramAudioRestrict;
    this.noiseSuppression = paramNoiseSuppression;
    this.abTest = paramABTest;
    this.client = parama;
    this.rateControl = paramRateControl;
    this.rateControlOptions = paramArrayOfRateControl;
    this.resend = paramResend;
    this.bwe = paramBandwidthEstimator;
    this.re = paramRelayElection;
    this.xc = paramXorCipher;
    this.videoRateControl = paramVideoRateControl;
    this.videoRateControlOptions = paramArrayOfVideoRateControl;
    this.videoBatteryRateControl = paramArrayOfVideoBatteryRateControl;
    this.videoDriver = paramVideoDriver;
    this.trafficShaper = paramTrafficShaper;
    this.initialBwe = paramInitialBwe;
  }
  
  private static Boolean convertAttributeToBoolean(String paramString)
  {
    if (("0".equals(paramString)) || ("false".equals(paramString))) {
      return Boolean.FALSE;
    }
    if (paramString != null) {
      return Boolean.TRUE;
    }
    return null;
  }
  
  private static Float convertAttributeToFloat(ak paramak, String paramString)
  {
    return convertAttributeToFloat(paramak.a(paramString, null), paramString);
  }
  
  private static Float convertAttributeToFloat(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        Float localFloat = Float.valueOf(paramString1);
        return localFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new c("invalid + " + paramString2 + ": " + paramString1);
      }
    }
    return null;
  }
  
  private static Integer convertAttributeToInteger(ak paramak, String paramString)
  {
    return convertAttributeToInteger(paramak.a(paramString, null), paramString);
  }
  
  private static Integer convertAttributeToInteger(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        Integer localInteger = Integer.valueOf(paramString1);
        return localInteger;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new c("invalid + " + paramString2 + ": " + paramString1);
      }
    }
    return null;
  }
  
  private static Integer convertAttributeToInteger(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = convertAttributeToInteger(paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1.intValue() < paramInt1) || (paramString1.intValue() > paramInt2))) {
      throw new c(paramString2 + " (" + paramString1 + ") outside of valid range [" + paramInt1 + "," + paramInt2 + "]");
    }
    return paramString1;
  }
  
  private static Short convertAttributeToShort(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        Short localShort = new Short(Short.parseShort(paramString1));
        return localShort;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new c("invalid + " + paramString2 + ": " + paramString1);
      }
    }
    return null;
  }
  
  private static Short convertAttributeToShort(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = convertAttributeToShort(paramString1, paramString2);
    if ((paramString1 != null) && ((paramString1.shortValue() < paramInt1) || (paramString1.shortValue() > paramInt2))) {
      throw new c(paramString2 + " (" + paramString1 + ") outside of valid range [" + paramInt1 + "," + paramInt2 + "]");
    }
    return paramString1;
  }
  
  /* Error */
  public static VoipOptions fromProtocolTreeNode(ak paramak, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ldc_w 299
    //   7: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   10: invokestatic 306	com/whatsapp/protocol/VoipOptions$Aec:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Aec;
    //   13: astore 7
    //   15: aload_0
    //   16: ldc_w 307
    //   19: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   22: invokestatic 310	com/whatsapp/protocol/VoipOptions$Encode:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Encode;
    //   25: astore 8
    //   27: aload_0
    //   28: ldc_w 311
    //   31: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   34: invokestatic 314	com/whatsapp/protocol/VoipOptions$Decode:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Decode;
    //   37: astore 9
    //   39: aload_0
    //   40: ldc_w 316
    //   43: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   46: invokestatic 319	com/whatsapp/protocol/VoipOptions$Miscellaneous:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Miscellaneous;
    //   49: astore 10
    //   51: aload_0
    //   52: ldc_w 320
    //   55: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   58: invokestatic 323	com/whatsapp/protocol/VoipOptions$Agc:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Agc;
    //   61: astore 11
    //   63: aconst_null
    //   64: astore_3
    //   65: aload 4
    //   67: astore 5
    //   69: iload_1
    //   70: ifeq +18 -> 88
    //   73: aload_0
    //   74: ldc_w 325
    //   77: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   80: invokestatic 328	com/whatsapp/protocol/VoipOptions$AudioRestrict:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$AudioRestrict;
    //   83: astore_3
    //   84: aload 4
    //   86: astore 5
    //   88: aload_0
    //   89: ldc_w 330
    //   92: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   95: invokestatic 333	com/whatsapp/protocol/VoipOptions$NoiseSuppression:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$NoiseSuppression;
    //   98: astore 12
    //   100: aload 5
    //   102: astore 4
    //   104: aload_0
    //   105: ldc_w 334
    //   108: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   111: astore 5
    //   113: aload 5
    //   115: ifnonnull +236 -> 351
    //   118: aconst_null
    //   119: astore 5
    //   121: aload 5
    //   123: astore 13
    //   125: aload_0
    //   126: ldc_w 336
    //   129: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   132: invokestatic 339	com/whatsapp/protocol/VoipOptions$RateControl:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$RateControl;
    //   135: astore 14
    //   137: aconst_null
    //   138: astore 6
    //   140: aload_0
    //   141: ldc_w 341
    //   144: invokevirtual 345	com/whatsapp/protocol/ak:f	(Ljava/lang/String;)Ljava/util/List;
    //   147: astore 15
    //   149: aload 6
    //   151: astore 5
    //   153: aload 15
    //   155: ifnull +268 -> 423
    //   158: aload 6
    //   160: astore 5
    //   162: aload 15
    //   164: invokeinterface 350 1 0
    //   169: ifle +254 -> 423
    //   172: aload 6
    //   174: astore 5
    //   176: aload 15
    //   178: invokeinterface 350 1 0
    //   183: bipush 32
    //   185: if_icmpgt +238 -> 423
    //   188: aload 15
    //   190: invokeinterface 350 1 0
    //   195: anewarray 36	com/whatsapp/protocol/VoipOptions$RateControl
    //   198: astore 5
    //   200: iconst_0
    //   201: istore_2
    //   202: iload_2
    //   203: aload 15
    //   205: invokeinterface 350 1 0
    //   210: if_icmpge +213 -> 423
    //   213: aload 5
    //   215: iload_2
    //   216: aload 15
    //   218: iload_2
    //   219: invokeinterface 354 2 0
    //   224: checkcast 228	com/whatsapp/protocol/ak
    //   227: invokestatic 339	com/whatsapp/protocol/VoipOptions$RateControl:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$RateControl;
    //   230: aastore
    //   231: iload_2
    //   232: iconst_1
    //   233: iadd
    //   234: istore_2
    //   235: goto -33 -> 202
    //   238: astore_3
    //   239: aload_3
    //   240: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   243: aconst_null
    //   244: astore 7
    //   246: ldc_w 299
    //   249: astore 4
    //   251: goto -236 -> 15
    //   254: astore_3
    //   255: aload_3
    //   256: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   259: aconst_null
    //   260: astore 8
    //   262: ldc_w 307
    //   265: astore 4
    //   267: goto -240 -> 27
    //   270: astore_3
    //   271: aload_3
    //   272: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   275: aconst_null
    //   276: astore 9
    //   278: ldc_w 311
    //   281: astore 4
    //   283: goto -244 -> 39
    //   286: astore_3
    //   287: aload_3
    //   288: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   291: aconst_null
    //   292: astore 10
    //   294: ldc_w 316
    //   297: astore 4
    //   299: goto -248 -> 51
    //   302: astore_3
    //   303: aload_3
    //   304: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   307: aconst_null
    //   308: astore 11
    //   310: ldc_w 320
    //   313: astore 4
    //   315: goto -252 -> 63
    //   318: astore_3
    //   319: aload_3
    //   320: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   323: aconst_null
    //   324: astore_3
    //   325: ldc_w 325
    //   328: astore 5
    //   330: goto -242 -> 88
    //   333: astore 4
    //   335: aload 4
    //   337: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   340: aconst_null
    //   341: astore 12
    //   343: ldc_w 330
    //   346: astore 4
    //   348: goto -244 -> 104
    //   351: new 60	com/whatsapp/protocol/VoipOptions$a
    //   354: dup
    //   355: aload 5
    //   357: ldc_w 361
    //   360: aconst_null
    //   361: invokevirtual 231	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   364: invokestatic 363	com/whatsapp/protocol/VoipOptions:access$200	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   367: aload 5
    //   369: ldc_w 365
    //   372: aconst_null
    //   373: invokevirtual 231	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: invokestatic 363	com/whatsapp/protocol/VoipOptions:access$200	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   379: invokespecial 368	com/whatsapp/protocol/VoipOptions$a:<init>	(Ljava/lang/Boolean;Ljava/lang/Boolean;)V
    //   382: astore 5
    //   384: goto -263 -> 121
    //   387: astore 4
    //   389: aload 4
    //   391: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   394: aconst_null
    //   395: astore 13
    //   397: ldc_w 334
    //   400: astore 4
    //   402: goto -277 -> 125
    //   405: astore 4
    //   407: aload 4
    //   409: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   412: aconst_null
    //   413: astore 14
    //   415: ldc_w 336
    //   418: astore 4
    //   420: goto -283 -> 137
    //   423: aload 5
    //   425: astore 15
    //   427: aload_0
    //   428: ldc_w 369
    //   431: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   434: invokestatic 372	com/whatsapp/protocol/VoipOptions$Resend:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$Resend;
    //   437: astore 16
    //   439: aload_0
    //   440: ldc_w 373
    //   443: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   446: invokestatic 376	com/whatsapp/protocol/VoipOptions$BandwidthEstimator:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$BandwidthEstimator;
    //   449: astore 17
    //   451: aload_0
    //   452: ldc_w 377
    //   455: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   458: invokestatic 380	com/whatsapp/protocol/VoipOptions$RelayElection:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$RelayElection;
    //   461: astore 18
    //   463: aload_0
    //   464: ldc_w 382
    //   467: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   470: invokestatic 385	com/whatsapp/protocol/VoipOptions$XorCipher:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$XorCipher;
    //   473: astore 19
    //   475: aload_0
    //   476: ldc_w 387
    //   479: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   482: invokestatic 390	com/whatsapp/protocol/VoipOptions$VideoRateControl:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$VideoRateControl;
    //   485: astore 6
    //   487: aload 4
    //   489: astore 5
    //   491: aload 6
    //   493: astore 4
    //   495: aconst_null
    //   496: astore 20
    //   498: aload_0
    //   499: ldc_w 392
    //   502: invokevirtual 345	com/whatsapp/protocol/ak:f	(Ljava/lang/String;)Ljava/util/List;
    //   505: astore 21
    //   507: aload 20
    //   509: astore 6
    //   511: aload 21
    //   513: ifnull +191 -> 704
    //   516: aload 20
    //   518: astore 6
    //   520: aload 21
    //   522: invokeinterface 350 1 0
    //   527: ifle +177 -> 704
    //   530: aload 20
    //   532: astore 6
    //   534: aload 21
    //   536: invokeinterface 350 1 0
    //   541: bipush 32
    //   543: if_icmpgt +161 -> 704
    //   546: aload 21
    //   548: invokeinterface 350 1 0
    //   553: anewarray 54	com/whatsapp/protocol/VoipOptions$VideoRateControl
    //   556: astore 6
    //   558: iconst_0
    //   559: istore_2
    //   560: iload_2
    //   561: aload 21
    //   563: invokeinterface 350 1 0
    //   568: if_icmpge +136 -> 704
    //   571: aload 6
    //   573: iload_2
    //   574: aload 21
    //   576: iload_2
    //   577: invokeinterface 354 2 0
    //   582: checkcast 228	com/whatsapp/protocol/ak
    //   585: invokestatic 390	com/whatsapp/protocol/VoipOptions$VideoRateControl:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$VideoRateControl;
    //   588: aastore
    //   589: iload_2
    //   590: iconst_1
    //   591: iadd
    //   592: istore_2
    //   593: goto -33 -> 560
    //   596: astore 4
    //   598: aload 4
    //   600: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   603: aconst_null
    //   604: astore 15
    //   606: ldc_w 341
    //   609: astore 4
    //   611: goto -184 -> 427
    //   614: astore 4
    //   616: aload 4
    //   618: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   621: aconst_null
    //   622: astore 16
    //   624: ldc_w 369
    //   627: astore 4
    //   629: goto -190 -> 439
    //   632: astore 4
    //   634: aload 4
    //   636: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   639: aconst_null
    //   640: astore 17
    //   642: ldc_w 373
    //   645: astore 4
    //   647: goto -196 -> 451
    //   650: astore 4
    //   652: aload 4
    //   654: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   657: aconst_null
    //   658: astore 18
    //   660: ldc_w 377
    //   663: astore 4
    //   665: goto -202 -> 463
    //   668: astore 4
    //   670: aload 4
    //   672: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   675: aconst_null
    //   676: astore 19
    //   678: ldc_w 382
    //   681: astore 4
    //   683: goto -208 -> 475
    //   686: astore 4
    //   688: aload 4
    //   690: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   693: ldc_w 387
    //   696: astore 5
    //   698: aconst_null
    //   699: astore 4
    //   701: goto -206 -> 495
    //   704: aload 6
    //   706: astore 20
    //   708: aconst_null
    //   709: astore 21
    //   711: aload_0
    //   712: ldc_w 394
    //   715: invokevirtual 345	com/whatsapp/protocol/ak:f	(Ljava/lang/String;)Ljava/util/List;
    //   718: astore 22
    //   720: aload 21
    //   722: astore 6
    //   724: aload 22
    //   726: ifnull +101 -> 827
    //   729: aload 21
    //   731: astore 6
    //   733: aload 22
    //   735: invokeinterface 350 1 0
    //   740: ifle +87 -> 827
    //   743: aload 21
    //   745: astore 6
    //   747: aload 22
    //   749: invokeinterface 350 1 0
    //   754: bipush 32
    //   756: if_icmpgt +71 -> 827
    //   759: aload 22
    //   761: invokeinterface 350 1 0
    //   766: anewarray 48	com/whatsapp/protocol/VoipOptions$VideoBatteryRateControl
    //   769: astore 6
    //   771: iconst_0
    //   772: istore_2
    //   773: iload_2
    //   774: aload 22
    //   776: invokeinterface 350 1 0
    //   781: if_icmpge +46 -> 827
    //   784: aload 6
    //   786: iload_2
    //   787: aload 22
    //   789: iload_2
    //   790: invokeinterface 354 2 0
    //   795: checkcast 228	com/whatsapp/protocol/ak
    //   798: invokestatic 397	com/whatsapp/protocol/VoipOptions$VideoBatteryRateControl:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$VideoBatteryRateControl;
    //   801: aastore
    //   802: iload_2
    //   803: iconst_1
    //   804: iadd
    //   805: istore_2
    //   806: goto -33 -> 773
    //   809: astore 5
    //   811: aload 5
    //   813: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   816: aconst_null
    //   817: astore 20
    //   819: ldc_w 392
    //   822: astore 5
    //   824: goto -116 -> 708
    //   827: aload 5
    //   829: astore 21
    //   831: aload 6
    //   833: astore 5
    //   835: aload 4
    //   837: astore 6
    //   839: aload 21
    //   841: astore 4
    //   843: aload_0
    //   844: ldc_w 399
    //   847: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   850: invokestatic 402	com/whatsapp/protocol/VoipOptions$VideoDriver:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$VideoDriver;
    //   853: astore 21
    //   855: aload_0
    //   856: ldc_w 404
    //   859: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   862: invokestatic 407	com/whatsapp/protocol/VoipOptions$TrafficShaper:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$TrafficShaper;
    //   865: astore 22
    //   867: aload_0
    //   868: ldc_w 409
    //   871: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   874: invokestatic 412	com/whatsapp/protocol/VoipOptions$InitialBwe:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$InitialBwe;
    //   877: astore 24
    //   879: aload 4
    //   881: astore 23
    //   883: aload 24
    //   885: astore 4
    //   887: aload_0
    //   888: ldc_w 414
    //   891: invokevirtual 303	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   894: invokestatic 417	com/whatsapp/protocol/VoipOptions$ABTest:fromProtocolTreeNode	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/VoipOptions$ABTest;
    //   897: astore 24
    //   899: aload 24
    //   901: astore_0
    //   902: aload 23
    //   904: ifnull +37 -> 941
    //   907: aload 24
    //   909: ifnonnull +155 -> 1064
    //   912: new 6	com/whatsapp/protocol/VoipOptions$ABTest
    //   915: dup
    //   916: new 243	java/lang/StringBuilder
    //   919: dup
    //   920: ldc_w 419
    //   923: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   926: aload 23
    //   928: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: invokevirtual 422	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   937: invokespecial 423	com/whatsapp/protocol/VoipOptions$ABTest:<init>	(Ljava/lang/String;)V
    //   940: astore_0
    //   941: new 2	com/whatsapp/protocol/VoipOptions
    //   944: dup
    //   945: aload 7
    //   947: aload 8
    //   949: aload 9
    //   951: aload 10
    //   953: aload 11
    //   955: aload_3
    //   956: aload 12
    //   958: aload_0
    //   959: aload 13
    //   961: aload 14
    //   963: aload 15
    //   965: aload 16
    //   967: aload 17
    //   969: aload 18
    //   971: aload 19
    //   973: aload 6
    //   975: aload 20
    //   977: aload 5
    //   979: aload 21
    //   981: aload 22
    //   983: aload 4
    //   985: invokespecial 119	com/whatsapp/protocol/VoipOptions:<init>	(Lcom/whatsapp/protocol/VoipOptions$Aec;Lcom/whatsapp/protocol/VoipOptions$Encode;Lcom/whatsapp/protocol/VoipOptions$Decode;Lcom/whatsapp/protocol/VoipOptions$Miscellaneous;Lcom/whatsapp/protocol/VoipOptions$Agc;Lcom/whatsapp/protocol/VoipOptions$AudioRestrict;Lcom/whatsapp/protocol/VoipOptions$NoiseSuppression;Lcom/whatsapp/protocol/VoipOptions$ABTest;Lcom/whatsapp/protocol/VoipOptions$a;Lcom/whatsapp/protocol/VoipOptions$RateControl;[Lcom/whatsapp/protocol/VoipOptions$RateControl;Lcom/whatsapp/protocol/VoipOptions$Resend;Lcom/whatsapp/protocol/VoipOptions$BandwidthEstimator;Lcom/whatsapp/protocol/VoipOptions$RelayElection;Lcom/whatsapp/protocol/VoipOptions$XorCipher;Lcom/whatsapp/protocol/VoipOptions$VideoRateControl;[Lcom/whatsapp/protocol/VoipOptions$VideoRateControl;[Lcom/whatsapp/protocol/VoipOptions$VideoBatteryRateControl;Lcom/whatsapp/protocol/VoipOptions$VideoDriver;Lcom/whatsapp/protocol/VoipOptions$TrafficShaper;Lcom/whatsapp/protocol/VoipOptions$InitialBwe;)V
    //   988: areturn
    //   989: astore 4
    //   991: aconst_null
    //   992: astore 5
    //   994: aload 4
    //   996: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   999: aconst_null
    //   1000: astore 6
    //   1002: ldc_w 394
    //   1005: astore 4
    //   1007: goto -164 -> 843
    //   1010: astore 4
    //   1012: aload 4
    //   1014: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1017: aconst_null
    //   1018: astore 21
    //   1020: ldc_w 399
    //   1023: astore 4
    //   1025: goto -170 -> 855
    //   1028: astore 4
    //   1030: aload 4
    //   1032: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1035: aconst_null
    //   1036: astore 22
    //   1038: ldc_w 404
    //   1041: astore 4
    //   1043: goto -176 -> 867
    //   1046: astore 4
    //   1048: aload 4
    //   1050: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1053: aconst_null
    //   1054: astore 4
    //   1056: ldc_w 409
    //   1059: astore 23
    //   1061: goto -174 -> 887
    //   1064: new 6	com/whatsapp/protocol/VoipOptions$ABTest
    //   1067: dup
    //   1068: new 243	java/lang/StringBuilder
    //   1071: dup
    //   1072: ldc_w 425
    //   1075: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1078: aload 24
    //   1080: getfield 428	com/whatsapp/protocol/VoipOptions$ABTest:name	Ljava/lang/String;
    //   1083: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: ldc_w 430
    //   1089: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: aload 23
    //   1094: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokevirtual 422	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1103: invokespecial 423	com/whatsapp/protocol/VoipOptions$ABTest:<init>	(Ljava/lang/String;)V
    //   1106: astore_0
    //   1107: goto -166 -> 941
    //   1110: astore_0
    //   1111: aload_0
    //   1112: invokestatic 359	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1115: new 6	com/whatsapp/protocol/VoipOptions$ABTest
    //   1118: dup
    //   1119: new 243	java/lang/StringBuilder
    //   1122: dup
    //   1123: ldc_w 419
    //   1126: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1129: ldc_w 414
    //   1132: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokevirtual 422	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1141: invokespecial 423	com/whatsapp/protocol/VoipOptions$ABTest:<init>	(Ljava/lang/String;)V
    //   1144: astore_0
    //   1145: goto -204 -> 941
    //   1148: astore_0
    //   1149: aload 23
    //   1151: ifnull +32 -> 1183
    //   1154: new 6	com/whatsapp/protocol/VoipOptions$ABTest
    //   1157: dup
    //   1158: new 243	java/lang/StringBuilder
    //   1161: dup
    //   1162: ldc_w 419
    //   1165: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1168: aload 23
    //   1170: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1176: invokevirtual 422	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1179: invokespecial 423	com/whatsapp/protocol/VoipOptions$ABTest:<init>	(Ljava/lang/String;)V
    //   1182: pop
    //   1183: aload_0
    //   1184: athrow
    //   1185: astore 4
    //   1187: aload 6
    //   1189: astore 5
    //   1191: goto -197 -> 994
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1194	0	paramak	ak
    //   0	1194	1	paramBoolean	boolean
    //   201	605	2	i	int
    //   64	20	3	localAudioRestrict1	AudioRestrict
    //   238	2	3	localc1	c
    //   254	2	3	localc2	c
    //   270	2	3	localc3	c
    //   286	2	3	localc4	c
    //   302	2	3	localc5	c
    //   318	2	3	localc6	c
    //   324	632	3	localAudioRestrict2	AudioRestrict
    //   1	313	4	localObject1	Object
    //   333	3	4	localc7	c
    //   346	1	4	str1	String
    //   387	3	4	localc8	c
    //   400	1	4	str2	String
    //   405	3	4	localc9	c
    //   418	76	4	localObject2	Object
    //   596	3	4	localc10	c
    //   609	1	4	str3	String
    //   614	3	4	localc11	c
    //   627	1	4	str4	String
    //   632	3	4	localc12	c
    //   645	1	4	str5	String
    //   650	3	4	localc13	c
    //   663	1	4	str6	String
    //   668	3	4	localc14	c
    //   681	1	4	str7	String
    //   686	3	4	localc15	c
    //   699	285	4	localObject3	Object
    //   989	6	4	localc16	c
    //   1005	1	4	str8	String
    //   1010	3	4	localc17	c
    //   1023	1	4	str9	String
    //   1028	3	4	localc18	c
    //   1041	1	4	str10	String
    //   1046	3	4	localc19	c
    //   1054	1	4	localObject4	Object
    //   1185	1	4	localc20	c
    //   67	630	5	localObject5	Object
    //   809	3	5	localc21	c
    //   822	368	5	localObject6	Object
    //   138	1050	6	localObject7	Object
    //   13	933	7	localAec	Aec
    //   25	923	8	localEncode	Encode
    //   37	913	9	localDecode	Decode
    //   49	903	10	localMiscellaneous	Miscellaneous
    //   61	893	11	localAgc	Agc
    //   98	859	12	localNoiseSuppression	NoiseSuppression
    //   123	837	13	localObject8	Object
    //   135	827	14	localRateControl	RateControl
    //   147	817	15	localObject9	Object
    //   437	529	16	localResend	Resend
    //   449	519	17	localBandwidthEstimator	BandwidthEstimator
    //   461	509	18	localRelayElection	RelayElection
    //   473	499	19	localXorCipher	XorCipher
    //   496	480	20	localObject10	Object
    //   505	514	21	localObject11	Object
    //   718	319	22	localObject12	Object
    //   881	288	23	localObject13	Object
    //   877	202	24	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	238	com/whatsapp/protocol/c
    //   15	27	254	com/whatsapp/protocol/c
    //   27	39	270	com/whatsapp/protocol/c
    //   39	51	286	com/whatsapp/protocol/c
    //   51	63	302	com/whatsapp/protocol/c
    //   73	84	318	com/whatsapp/protocol/c
    //   88	100	333	com/whatsapp/protocol/c
    //   104	113	387	com/whatsapp/protocol/c
    //   351	384	387	com/whatsapp/protocol/c
    //   125	137	405	com/whatsapp/protocol/c
    //   140	149	596	com/whatsapp/protocol/c
    //   162	172	596	com/whatsapp/protocol/c
    //   176	200	596	com/whatsapp/protocol/c
    //   202	231	596	com/whatsapp/protocol/c
    //   427	439	614	com/whatsapp/protocol/c
    //   439	451	632	com/whatsapp/protocol/c
    //   451	463	650	com/whatsapp/protocol/c
    //   463	475	668	com/whatsapp/protocol/c
    //   475	487	686	com/whatsapp/protocol/c
    //   498	507	809	com/whatsapp/protocol/c
    //   520	530	809	com/whatsapp/protocol/c
    //   534	558	809	com/whatsapp/protocol/c
    //   560	589	809	com/whatsapp/protocol/c
    //   711	720	989	com/whatsapp/protocol/c
    //   733	743	989	com/whatsapp/protocol/c
    //   747	771	989	com/whatsapp/protocol/c
    //   843	855	1010	com/whatsapp/protocol/c
    //   855	867	1028	com/whatsapp/protocol/c
    //   867	879	1046	com/whatsapp/protocol/c
    //   887	899	1110	com/whatsapp/protocol/c
    //   887	899	1148	finally
    //   1111	1115	1148	finally
    //   773	802	1185	com/whatsapp/protocol/c
  }
  
  private static Boolean negate(Boolean paramBoolean)
  {
    if (Boolean.TRUE.equals(paramBoolean)) {
      return Boolean.FALSE;
    }
    if (Boolean.FALSE.equals(paramBoolean)) {
      return Boolean.TRUE;
    }
    return null;
  }
  
  public final void setReflectedAddress(byte[] paramArrayOfByte)
  {
    this.reflAddr = paramArrayOfByte;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VoipOptions{");
    if (this.aec == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str);
      if (this.encode != null) {
        break label349;
      }
      str = "";
      label39:
      localStringBuilder = localStringBuilder.append(str);
      if (this.decode != null) {
        break label373;
      }
      str = "";
      label56:
      localStringBuilder = localStringBuilder.append(str);
      if (this.miscellaneous != null) {
        break label397;
      }
      str = "";
      label73:
      localStringBuilder = localStringBuilder.append(str);
      if (this.agc != null) {
        break label421;
      }
      str = "";
      label90:
      localStringBuilder = localStringBuilder.append(str);
      if (this.audioRestrict != null) {
        break label445;
      }
      str = "";
      label107:
      localStringBuilder = localStringBuilder.append(str);
      if (this.noiseSuppression != null) {
        break label469;
      }
      str = "";
      label124:
      localStringBuilder = localStringBuilder.append(str);
      if (this.abTest != null) {
        break label493;
      }
      str = "";
      label141:
      localStringBuilder = localStringBuilder.append(str);
      if (this.client != null) {
        break label517;
      }
      str = "";
      label158:
      localStringBuilder = localStringBuilder.append(str);
      if (this.rateControl != null) {
        break label541;
      }
      str = "";
      label175:
      localStringBuilder = localStringBuilder.append(str);
      if (this.resend != null) {
        break label565;
      }
      str = "";
      label192:
      localStringBuilder = localStringBuilder.append(str);
      if (this.bwe != null) {
        break label589;
      }
      str = "";
      label209:
      localStringBuilder = localStringBuilder.append(str);
      if (this.re != null) {
        break label613;
      }
      str = "";
      label226:
      localStringBuilder = localStringBuilder.append(str);
      if (this.xc != null) {
        break label637;
      }
      str = "";
      label243:
      localStringBuilder = localStringBuilder.append(str);
      if (this.videoRateControl != null) {
        break label661;
      }
      str = "";
      label260:
      localStringBuilder = localStringBuilder.append(str);
      if (this.trafficShaper != null) {
        break label685;
      }
      str = "";
      label277:
      localStringBuilder = localStringBuilder.append(str);
      if (this.initialBwe != null) {
        break label709;
      }
      str = "";
      label294:
      localStringBuilder = localStringBuilder.append(str);
      if (this.videoDriver != null) {
        break label733;
      }
    }
    label349:
    label373:
    label397:
    label421:
    label445:
    label469:
    label493:
    label517:
    label541:
    label565:
    label589:
    label613:
    label637:
    label661:
    label685:
    label709:
    label733:
    for (String str = "";; str = ", videoDriver=" + this.videoDriver)
    {
      return str + '}';
      str = "aec=" + this.aec;
      break;
      str = ", encode=" + this.encode;
      break label39;
      str = ", decode=" + this.decode;
      break label56;
      str = ", miscellaneous=" + this.miscellaneous;
      break label73;
      str = ", agc=" + this.agc;
      break label90;
      str = ", audioRestrict=" + this.audioRestrict;
      break label107;
      str = ", noiseSuppression=" + this.noiseSuppression;
      break label124;
      str = ", abTest=" + this.abTest;
      break label141;
      str = ", client=" + this.client;
      break label158;
      str = ", rateControl=" + this.rateControl;
      break label175;
      str = ", resend=" + this.resend;
      break label192;
      str = ", bwe=" + this.bwe;
      break label209;
      str = ", relayElection=" + this.re;
      break label226;
      str = ", xorCipher=" + this.xc;
      break label243;
      str = ", videoRateControl=" + this.videoRateControl;
      break label260;
      str = ", trafficShaper=" + this.trafficShaper;
      break label277;
      str = ", initialBwe=" + this.initialBwe;
      break label294;
    }
  }
  
  @Keep
  public static final class ABTest
  {
    public final String name;
    
    public ABTest(String paramString)
    {
      this.name = paramString;
    }
    
    public static ABTest fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new ABTest(paramak.a("name", null));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("ABTest{");
      if (this.name == null) {}
      for (String str = "";; str = "name=" + this.name) {
        return str + "}";
      }
    }
  }
  
  @Keep
  public static final class Aec
  {
    public final Integer aecmAdaptStepSize;
    public final Integer aecmDataWidth;
    public final Boolean aecmDynamicQ;
    public final Integer aecmSupgainScale;
    public final String algorithm;
    public final Short builtinEnabled;
    public final Boolean disableAgc;
    public final Boolean disableSwEcWhenBuiltinAvailable;
    public final Integer ecOffThreshold;
    public final Integer ecThreshold;
    public final Integer echoDetectorImpl;
    public final Short echoDetectorMode;
    public final Integer length;
    public final Short mode;
    public final Integer offset;
    public final Short speakerMode;
    public final Integer strengthThreshold;
    public final Boolean toneDetectorEnabled;
    public final Boolean useCleanCapture;
    
    public Aec(String paramString, Integer paramInteger1, Integer paramInteger2, Short paramShort1, Short paramShort2, Integer paramInteger3, Short paramShort3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Short paramShort4, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9)
    {
      this.algorithm = paramString;
      this.offset = paramInteger1;
      this.length = paramInteger2;
      this.mode = paramShort1;
      this.speakerMode = paramShort2;
      this.echoDetectorImpl = paramInteger3;
      this.echoDetectorMode = paramShort3;
      this.ecThreshold = paramInteger4;
      this.ecOffThreshold = paramInteger5;
      this.strengthThreshold = paramInteger6;
      this.builtinEnabled = paramShort4;
      this.disableSwEcWhenBuiltinAvailable = paramBoolean1;
      this.toneDetectorEnabled = paramBoolean2;
      this.disableAgc = paramBoolean3;
      this.useCleanCapture = paramBoolean4;
      this.aecmDynamicQ = paramBoolean5;
      this.aecmAdaptStepSize = paramInteger7;
      this.aecmSupgainScale = paramInteger8;
      this.aecmDataWidth = paramInteger9;
    }
    
    public static Aec fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      String str = paramak.a("algorithm", null);
      Object localObject1 = paramak.a("offset", null);
      Object localObject2 = paramak.a("length", null);
      Object localObject3 = paramak.a("mode", null);
      Object localObject4 = paramak.a("echo_detector_impl", null);
      Object localObject5 = paramak.a("echo_detector_mode", null);
      Object localObject6 = paramak.a("ec_threshold", null);
      Object localObject8 = paramak.a("ec_off_threshold", null);
      Object localObject10 = paramak.a("builtin", null);
      Object localObject9 = paramak.a("disable_sw_ec_when_builtin_available", null);
      Object localObject7 = paramak.a("tonedetector", null);
      localObject1 = VoipOptions.convertAttributeToInteger((String)localObject1, "offset");
      localObject2 = VoipOptions.convertAttributeToInteger((String)localObject2, "length");
      localObject3 = VoipOptions.convertAttributeToShort((String)localObject3, "mode", 0, 4);
      localObject4 = VoipOptions.convertAttributeToInteger((String)localObject4, "echo_detector_impl");
      localObject5 = VoipOptions.convertAttributeToShort((String)localObject5, "echo_detector_mode", 0, 7);
      localObject6 = VoipOptions.convertAttributeToInteger((String)localObject6, "ec_threshold");
      localObject8 = VoipOptions.convertAttributeToInteger((String)localObject8, "ec_off_threshold");
      Integer localInteger1 = VoipOptions.convertAttributeToInteger(paramak.a("strength_threshold", null), "strength_threshold");
      localObject10 = VoipOptions.convertAttributeToShort((String)localObject10, "builtin", 0, 7);
      localObject9 = VoipOptions.convertAttributeToBoolean((String)localObject9);
      localObject7 = VoipOptions.convertAttributeToBoolean((String)localObject7);
      Boolean localBoolean1 = VoipOptions.convertAttributeToBoolean(paramak.a("disable_agc", null));
      Boolean localBoolean2 = VoipOptions.convertAttributeToBoolean(paramak.a("use_clean_capture", null));
      Boolean localBoolean3 = VoipOptions.convertAttributeToBoolean(paramak.a("aecm_dynamic_q_en", null));
      Integer localInteger2 = VoipOptions.convertAttributeToInteger(paramak.a("aecm_adapt_step_size", null), "aecm_adapt_step_size");
      Integer localInteger3 = VoipOptions.convertAttributeToInteger(paramak.a("aecm_supgain_scale", null), "aecm_supgain_scale");
      Integer localInteger4 = VoipOptions.convertAttributeToInteger(paramak.a("aecm_data_width", null), "aecm_data_width");
      return new Aec(str, (Integer)localObject1, (Integer)localObject2, (Short)localObject3, VoipOptions.convertAttributeToShort(paramak.a("speaker_mode", null), "speaker_mode"), (Integer)localObject4, (Short)localObject5, (Integer)localObject6, (Integer)localObject8, localInteger1, (Short)localObject10, (Boolean)localObject9, (Boolean)localObject7, localBoolean1, localBoolean2, localBoolean3, localInteger2, localInteger3, localInteger4);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Aec{algorithm='").append(this.algorithm).append('\'');
      if (this.offset == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.length != null) {
          break label325;
        }
        str = "";
        label48:
        localStringBuilder = localStringBuilder.append(str);
        if (this.mode != null) {
          break label348;
        }
        str = "";
        label64:
        localStringBuilder = localStringBuilder.append(str);
        if (this.speakerMode != null) {
          break label371;
        }
        str = "";
        label80:
        localStringBuilder = localStringBuilder.append(str);
        if (this.echoDetectorImpl != null) {
          break label394;
        }
        str = "";
        label96:
        localStringBuilder = localStringBuilder.append(str);
        if (this.echoDetectorMode != null) {
          break label417;
        }
        str = "";
        label112:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ecThreshold != null) {
          break label440;
        }
        str = "";
        label128:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ecOffThreshold != null) {
          break label463;
        }
        str = "";
        label144:
        localStringBuilder = localStringBuilder.append(str);
        if (this.strengthThreshold != null) {
          break label486;
        }
        str = "";
        label160:
        localStringBuilder = localStringBuilder.append(str);
        if (this.builtinEnabled != null) {
          break label509;
        }
        str = "";
        label176:
        localStringBuilder = localStringBuilder.append(str);
        if (this.disableSwEcWhenBuiltinAvailable != null) {
          break label532;
        }
        str = "";
        label192:
        localStringBuilder = localStringBuilder.append(str);
        if (this.disableAgc != null) {
          break label555;
        }
        str = "";
        label208:
        localStringBuilder = localStringBuilder.append(str);
        if (this.useCleanCapture != null) {
          break label578;
        }
        str = "";
        label224:
        localStringBuilder = localStringBuilder.append(str);
        if (this.aecmDynamicQ != null) {
          break label601;
        }
        str = "";
        label240:
        localStringBuilder = localStringBuilder.append(str);
        if (this.aecmAdaptStepSize != null) {
          break label624;
        }
        str = "";
        label256:
        localStringBuilder = localStringBuilder.append(str);
        if (this.aecmSupgainScale != null) {
          break label647;
        }
        str = "";
        label272:
        localStringBuilder = localStringBuilder.append(str);
        if (this.aecmDataWidth != null) {
          break label670;
        }
      }
      label325:
      label348:
      label371:
      label394:
      label417:
      label440:
      label463:
      label486:
      label509:
      label532:
      label555:
      label578:
      label601:
      label624:
      label647:
      label670:
      for (String str = "";; str = ", aecmDataWidth=" + this.aecmDataWidth)
      {
        return str + '}';
        str = ", offset=" + this.offset;
        break;
        str = ", length=" + this.length;
        break label48;
        str = ", mode=" + this.mode;
        break label64;
        str = ", speakerMode=" + this.speakerMode;
        break label80;
        str = ", echoDetectorImpl=" + this.echoDetectorImpl;
        break label96;
        str = ", echoDetectorMode=" + this.echoDetectorMode;
        break label112;
        str = ", ecThreshold=" + this.ecThreshold;
        break label128;
        str = ", ecOffThreshold=" + this.ecOffThreshold;
        break label144;
        str = ", strengthThreshold=" + this.strengthThreshold;
        break label160;
        str = ", builtinEnabled=" + this.builtinEnabled;
        break label176;
        str = ", disableSwEcWhenBuiltinAvailable=" + this.disableSwEcWhenBuiltinAvailable;
        break label192;
        str = ", disableAgc=" + this.disableAgc;
        break label208;
        str = ", useCleanCapture=" + this.useCleanCapture;
        break label224;
        str = ", aecmDynamicQ=" + this.aecmDynamicQ;
        break label240;
        str = ", aecmAdaptStepSize=" + this.aecmAdaptStepSize;
        break label256;
        str = ", aecmSupgainScale=" + this.aecmSupgainScale;
        break label272;
      }
    }
  }
  
  @Keep
  public static final class Agc
  {
    public final Boolean builtinEnabled;
    public final Short compressionGain;
    public final Boolean enableLimiter;
    public final Short mode;
    public final Integer strengthThreshold;
    public final Short targetLevel;
    
    public Agc(Short paramShort1, Short paramShort2, Boolean paramBoolean1, Short paramShort3, Boolean paramBoolean2, Integer paramInteger)
    {
      this.targetLevel = paramShort1;
      this.compressionGain = paramShort2;
      this.enableLimiter = paramBoolean1;
      this.mode = paramShort3;
      this.builtinEnabled = paramBoolean2;
      this.strengthThreshold = paramInteger;
    }
    
    public static Agc fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      String str1 = paramak.a("targetlevel", null);
      String str2 = paramak.a("compressiongain", null);
      String str3 = paramak.a("limiterenable", null);
      String str4 = paramak.a("mode", null);
      String str5 = paramak.a("builtin", null);
      return new Agc(VoipOptions.convertAttributeToShort(str1, "target level", 0, 31), VoipOptions.convertAttributeToShort(str2, "compression gain", 0, 90), VoipOptions.convertAttributeToBoolean(str3), VoipOptions.convertAttributeToShort(str4, "mode", 0, 2), VoipOptions.convertAttributeToBoolean(str5), VoipOptions.convertAttributeToInteger(paramak.a("strength_threshold", null), "strength_threshold"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Agc{");
      if (this.targetLevel == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.compressionGain != null) {
          break label137;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableLimiter != null) {
          break label160;
        }
        str = "";
        label52:
        localStringBuilder = localStringBuilder.append(str);
        if (this.mode != null) {
          break label183;
        }
        str = "";
        label68:
        localStringBuilder = localStringBuilder.append(str);
        if (this.builtinEnabled != null) {
          break label206;
        }
        str = "";
        label84:
        localStringBuilder = localStringBuilder.append(str);
        if (this.strengthThreshold != null) {
          break label229;
        }
      }
      label137:
      label160:
      label183:
      label206:
      label229:
      for (String str = "";; str = ", strengthThreshold=" + this.strengthThreshold)
      {
        return str + '}';
        str = "targetLevel=" + this.targetLevel;
        break;
        str = ", compressionGain=" + this.compressionGain;
        break label36;
        str = ", enableLimiter=" + this.enableLimiter;
        break label52;
        str = ", mode=" + this.mode;
        break label68;
        str = ", builtinEnabled=" + this.builtinEnabled;
        break label84;
      }
    }
  }
  
  @Keep
  public static final class AudioRestrict
  {
    public final String encoding;
    public final Integer rate;
    
    public AudioRestrict(String paramString, Integer paramInteger)
    {
      this.encoding = paramString;
      this.rate = paramInteger;
    }
    
    public static AudioRestrict fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new AudioRestrict(paramak.a("enc", null), VoipOptions.convertAttributeToInteger(paramak.a("rate", null), "rate"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("AudioRestrict{encoding='").append(this.encoding).append('\'');
      if (this.rate == null) {}
      for (String str = "";; str = ", rate=" + this.rate) {
        return str + '}';
      }
    }
  }
  
  @Keep
  public static final class BandwidthEstimator
  {
    public final Short actionOnRtpMarker;
    public final Integer blur;
    public final Integer bweImpl;
    public final Integer maxTrainSpacing;
    public final Boolean maxUnknownOnRateIncrease;
    public final Float outageEntryRate;
    public final Float outageExitRate;
    public final Integer outageGracePeriod;
    public final Boolean resetOudTimestampOnBweReset;
    public final Boolean resetRccOnBweReset;
    public final Integer tickLength;
    public final Boolean useAudioPacketRate;
    
    public BandwidthEstimator(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Short paramShort, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Float paramFloat1, Float paramFloat2)
    {
      this.maxUnknownOnRateIncrease = paramBoolean1;
      this.useAudioPacketRate = paramBoolean2;
      this.resetRccOnBweReset = paramBoolean3;
      this.resetOudTimestampOnBweReset = paramBoolean4;
      this.actionOnRtpMarker = paramShort;
      this.bweImpl = paramInteger1;
      this.maxTrainSpacing = paramInteger2;
      this.outageGracePeriod = paramInteger3;
      this.blur = paramInteger4;
      this.tickLength = paramInteger5;
      this.outageEntryRate = paramFloat1;
      this.outageExitRate = paramFloat2;
    }
    
    public static BandwidthEstimator fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new BandwidthEstimator(VoipOptions.convertAttributeToBoolean(paramak.a("max_unknown_on_rate_increase", null)), VoipOptions.convertAttributeToBoolean(paramak.a("use_audio_packet_rate", null)), VoipOptions.convertAttributeToBoolean(paramak.a("reset_rcc_on_bwe_reset", null)), VoipOptions.convertAttributeToBoolean(paramak.a("reset_oud_timestamp_on_bwe_reset", null)), VoipOptions.convertAttributeToShort(paramak.a("action_on_rtp_marker", null), "action_on_rtp_marker", 0, 15), VoipOptions.convertAttributeToInteger(paramak.a("bwe_impl", null), "bwe_impl", 1, 4), VoipOptions.convertAttributeToInteger(paramak.a("max_train_spacing", null), "max_train_spacing", 1, 20), VoipOptions.convertAttributeToInteger(paramak.a("outage_grace_period", null), "outage_grace_period", 0, 200), VoipOptions.convertAttributeToInteger(paramak.a("blur", null), "blur", 0, 400), VoipOptions.convertAttributeToInteger(paramak.a("tick_length", null), "tick_length", 10, 100), VoipOptions.convertAttributeToFloat(paramak, "outage_entry_rate"), VoipOptions.convertAttributeToFloat(paramak, "outage_exit_rate"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Bwe{");
      if (this.maxUnknownOnRateIncrease == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.useAudioPacketRate != null) {
          break label233;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.resetRccOnBweReset != null) {
          break label256;
        }
        str = "";
        label52:
        localStringBuilder = localStringBuilder.append(str);
        if (this.resetOudTimestampOnBweReset != null) {
          break label279;
        }
        str = "";
        label68:
        localStringBuilder = localStringBuilder.append(str);
        if (this.actionOnRtpMarker != null) {
          break label302;
        }
        str = "";
        label84:
        localStringBuilder = localStringBuilder.append(str);
        if (this.bweImpl != null) {
          break label325;
        }
        str = "";
        label100:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxTrainSpacing != null) {
          break label348;
        }
        str = "";
        label116:
        localStringBuilder = localStringBuilder.append(str);
        if (this.outageGracePeriod != null) {
          break label371;
        }
        str = "";
        label132:
        localStringBuilder = localStringBuilder.append(str);
        if (this.blur != null) {
          break label394;
        }
        str = "";
        label148:
        localStringBuilder = localStringBuilder.append(str);
        if (this.tickLength != null) {
          break label417;
        }
        str = "";
        label164:
        localStringBuilder = localStringBuilder.append(str);
        if (this.outageEntryRate != null) {
          break label440;
        }
        str = "";
        label180:
        localStringBuilder = localStringBuilder.append(str);
        if (this.outageExitRate != null) {
          break label463;
        }
      }
      label233:
      label256:
      label279:
      label302:
      label325:
      label348:
      label371:
      label394:
      label417:
      label440:
      label463:
      for (String str = "";; str = ", outageExitRate=" + this.outageExitRate)
      {
        return str + '}';
        str = "maxUnknownOnRateIncrease=" + this.maxUnknownOnRateIncrease;
        break;
        str = ", useAudioPacketRate=" + this.useAudioPacketRate;
        break label36;
        str = ", resetRccOnBweReset=" + this.resetRccOnBweReset;
        break label52;
        str = ", resetOudTimestampOnBweReset=" + this.resetOudTimestampOnBweReset;
        break label68;
        str = ", actionOnRtpMarker=" + this.actionOnRtpMarker;
        break label84;
        str = ", impl=" + this.bweImpl;
        break label100;
        str = ", maxTrainSpacing=" + this.maxTrainSpacing;
        break label116;
        str = ", outageGracePeriod=" + this.outageGracePeriod;
        break label132;
        str = ", blur=" + this.blur;
        break label148;
        str = ", tickLength=" + this.tickLength;
        break label164;
        str = ", outageEntryRate=" + this.outageEntryRate;
        break label180;
      }
    }
  }
  
  @Keep
  public static final class Decode
  {
    public final Boolean forwardErrorCorrection;
    public final Short gain;
    public final Short plc;
    
    public Decode(Short paramShort1, Boolean paramBoolean, Short paramShort2)
    {
      this.gain = paramShort1;
      this.forwardErrorCorrection = paramBoolean;
      this.plc = paramShort2;
    }
    
    public static Decode fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new Decode(VoipOptions.convertAttributeToShort(paramak.a("gain", null), "gain"), VoipOptions.convertAttributeToBoolean(paramak.a("fec", null)), VoipOptions.convertAttributeToShort(paramak.a("plc", null), "plc"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Decode{");
      if (this.gain == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.forwardErrorCorrection != null) {
          break label89;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.plc != null) {
          break label112;
        }
      }
      label89:
      label112:
      for (String str = "";; str = "plc=" + this.plc)
      {
        return str + '}';
        str = "gain=" + this.gain;
        break;
        str = "forwardErrorCorrection=" + this.forwardErrorCorrection;
        break label36;
      }
    }
  }
  
  @Keep
  public static final class Encode
  {
    public final Short complexity;
    public final Boolean enableConstantBitrate;
    public final Boolean enableDiscontinuousTransmission;
    public final Boolean forwardErrorCorrection;
    public final Integer frameMs;
    public final Integer nonSpeechBitrate;
    public final Integer selectivelySkipNonSpeechFrames;
    public final Integer targetBitrate;
    public final Integer vadThreshold;
    
    public Encode(Short paramShort, Boolean paramBoolean1, Boolean paramBoolean2, Integer paramInteger1, Boolean paramBoolean3, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
    {
      this.complexity = paramShort;
      this.enableConstantBitrate = paramBoolean1;
      this.enableDiscontinuousTransmission = paramBoolean2;
      this.targetBitrate = paramInteger1;
      this.forwardErrorCorrection = paramBoolean3;
      this.vadThreshold = paramInteger2;
      this.nonSpeechBitrate = paramInteger3;
      this.selectivelySkipNonSpeechFrames = paramInteger4;
      this.frameMs = paramInteger5;
    }
    
    public static Encode fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      Object localObject2 = paramak.a("complexity", null);
      Object localObject3 = paramak.a("cbr", null);
      Object localObject4 = paramak.a("dtx", null);
      Object localObject1 = paramak.a("bitrate", null);
      String str = paramak.a("fec", null);
      localObject2 = VoipOptions.convertAttributeToShort((String)localObject2, "complexity", 1, 10);
      localObject3 = VoipOptions.convertAttributeToBoolean((String)localObject3);
      localObject4 = VoipOptions.convertAttributeToBoolean((String)localObject4);
      if ("auto".equals(localObject1)) {}
      for (localObject1 = null;; localObject1 = VoipOptions.convertAttributeToInteger((String)localObject1, "bitrate", 6000, 51000)) {
        return new Encode((Short)localObject2, (Boolean)localObject3, (Boolean)localObject4, (Integer)localObject1, VoipOptions.convertAttributeToBoolean(str), VoipOptions.convertAttributeToInteger(paramak.a("vad_threshold", null), "vad_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("non_speech_bitrate", null), "non_speech_bitrate"), VoipOptions.convertAttributeToInteger(paramak.a("selectively_skip_non_speech_frames", null), "selectively_skip_non_speech_frames"), VoipOptions.convertAttributeToInteger(paramak.a("frame_ms", null), "frame_ms"));
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Encode{");
      if (this.complexity == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableConstantBitrate != null) {
          break label185;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableDiscontinuousTransmission != null) {
          break label208;
        }
        str = "";
        label52:
        localStringBuilder = localStringBuilder.append(str);
        if (this.targetBitrate != null) {
          break label231;
        }
        str = "";
        label68:
        localStringBuilder = localStringBuilder.append(str);
        if (this.forwardErrorCorrection != null) {
          break label254;
        }
        str = "";
        label84:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vadThreshold != null) {
          break label277;
        }
        str = "";
        label100:
        localStringBuilder = localStringBuilder.append(str);
        if (this.nonSpeechBitrate != null) {
          break label300;
        }
        str = "";
        label116:
        localStringBuilder = localStringBuilder.append(str);
        if (this.selectivelySkipNonSpeechFrames != null) {
          break label323;
        }
        str = "";
        label132:
        localStringBuilder = localStringBuilder.append(str);
        if (this.frameMs != null) {
          break label346;
        }
      }
      label185:
      label208:
      label231:
      label254:
      label277:
      label300:
      label323:
      label346:
      for (String str = "";; str = ", frameMs=" + this.frameMs)
      {
        return str + '}';
        str = "complexity=" + this.complexity;
        break;
        str = ", enableConstantBitrate=" + this.enableConstantBitrate;
        break label36;
        str = ", enableDiscontinuousTransmission=" + this.enableDiscontinuousTransmission;
        break label52;
        str = ", targetBitrate=" + this.targetBitrate;
        break label68;
        str = ", forwardErrorCorrection=" + this.forwardErrorCorrection;
        break label84;
        str = ", vadThreshold=" + this.vadThreshold;
        break label100;
        str = ", nonSpeechBitrate=" + this.nonSpeechBitrate;
        break label116;
        str = ", selectivelySkipNonSpeechFrames=" + this.selectivelySkipNonSpeechFrames;
        break label132;
      }
    }
  }
  
  @Keep
  public static final class InitialBwe
  {
    public final Integer delayMs;
    public final Integer maxBitrate;
    public final Integer maxBytes;
    public final Integer maxTxRottBasedBitrate;
    public final Integer minBitrate;
    public final Integer testFlags;
    
    public InitialBwe(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6)
    {
      this.maxBytes = paramInteger1;
      this.minBitrate = paramInteger2;
      this.maxBitrate = paramInteger3;
      this.maxTxRottBasedBitrate = paramInteger4;
      this.delayMs = paramInteger5;
      this.testFlags = paramInteger6;
    }
    
    public static InitialBwe fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new InitialBwe(VoipOptions.convertAttributeToInteger(paramak, "max_bytes"), VoipOptions.convertAttributeToInteger(paramak, "min_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "max_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "max_tx_rott_based_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "delay_ms"), VoipOptions.convertAttributeToInteger(paramak, "test_flags"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("InitialBwe{");
      if (this.maxBytes != null)
      {
        str = "maxBytes=" + this.maxBytes;
        localStringBuilder = localStringBuilder.append(str);
        if (this.minBitrate == null) {
          break label222;
        }
        str = "minBitrate=" + this.minBitrate;
        label70:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBitrate == null) {
          break label228;
        }
        str = "maxBitrate=" + this.maxBitrate;
        label103:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxTxRottBasedBitrate == null) {
          break label234;
        }
        str = "maxTxRottBasedBitrate=" + this.maxTxRottBasedBitrate;
        label136:
        localStringBuilder = localStringBuilder.append(str);
        if (this.delayMs == null) {
          break label240;
        }
        str = "delayMs=" + this.delayMs;
        label169:
        localStringBuilder = localStringBuilder.append(str);
        if (this.testFlags == null) {
          break label246;
        }
      }
      label222:
      label228:
      label234:
      label240:
      label246:
      for (String str = "testFlags=" + this.testFlags;; str = "")
      {
        return str + '}';
        str = "";
        break;
        str = "";
        break label70;
        str = "";
        break label103;
        str = "";
        break label136;
        str = "";
        break label169;
      }
    }
  }
  
  @Keep
  public static final class Miscellaneous
  {
    public final Integer androidAudioEngine;
    public final Integer androidAudioModeInCall;
    public final Integer androidAudioPlaybackBufferSize;
    public final Integer androidAudioRecordBufferSize;
    public final Integer androidRecordPreset;
    public final Boolean androidRingFaster;
    public final Boolean androidShowCallConnectedToast;
    public final Boolean androidShowCallConnectingToast;
    public final Integer audioCallbackThreshold;
    public final Boolean audioEncodeOffload;
    public final Integer audioFPSThreshold;
    public final Integer audioLevelAdjust;
    public final Integer audioSamplingRate;
    public final Integer avSyncThresholdMs;
    public final Integer callOfferAckTimeout;
    public final Integer callStartDelay;
    public final Integer callerEndCallThreshold;
    public final Integer callerTimeout;
    public final Integer connectedIfReceivedData;
    public final Boolean createStreamOnOffer;
    public final Integer dimScreenPercentage;
    public final Boolean disableP2P;
    public final Boolean doPortPredictingUnconditionally;
    public final Boolean doUpnpCallback;
    public final Boolean e2eDecryptEnable;
    public final Boolean enableComfortNoiseGeneration;
    public final Boolean enableHighPassFiltering;
    public final Boolean enableLTRP;
    public final Boolean enableNewTransportStats;
    public final Boolean enableP2pDuplex;
    public final Boolean enablePortPredicting;
    public final Boolean enablePreacceptReceivedUpdate;
    public final Boolean enableSilenceDetection;
    public final Boolean enableUpnp;
    public final Boolean enableVoipCapability;
    public final Boolean initAudioInPreaccept;
    public final Integer initialInterruptionSoundDelay;
    public final Integer ipAutoSwitch;
    public final Integer ipConfig;
    public final Boolean isOpenGLYUVRenderEnabled;
    public final Integer jitterBufferDiscardAlgo;
    public final Integer jitterBufferImpl;
    public final Integer jitterBufferStretchAlgo;
    public final Integer lowBatteryNotifyThreshold;
    public final Integer maxAudioFrameDisorderDistance;
    public final Integer maxAudioTsJitterMs;
    public final Integer mtuSize;
    public final Integer neteqBgnMode;
    public final Integer neteqCumulativePeakMaxPeriod;
    public final Boolean neteqEnableFF;
    public final Integer neteqIatFactor;
    public final Integer neteqIatProb;
    public final Integer neteqMaxDelay;
    public final Integer neteqMaxPacketsInBuf;
    public final Integer neteqMinDelay;
    public final Integer neteqPeakHeight;
    public final Integer neteqPeakMaxPeriod;
    public final Integer networkRestartTimeout;
    public final Integer portPredictingRange;
    public final Integer preciseRxTimestampsMask;
    public final Integer restartAudioOnWhiteNoise;
    public final Integer ringbackMode;
    public final Integer ringbackTone;
    public final Integer rtpExtType;
    public final String rxNetCondParamsInJson;
    public final Integer setupVideoStreamBeforeAccept;
    public final Integer spamCallThresholdDuration;
    public final String testKey;
    public final String testValue;
    public final Float transportStatsP2pThreshold;
    public final Integer txCacheSizePkts;
    public final String txNetCondParamsInJson;
    public final Integer udpReceiveSocketBufferSize;
    public final Integer vidDecOnNetThread;
    public final Integer vidJbMaxMs;
    public final Integer videoCodecPriority;
    public final Integer vp8Cpu;
    
    public Miscellaneous(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, Integer paramInteger11, Integer paramInteger12, Integer paramInteger13, Integer paramInteger14, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Integer paramInteger15, Boolean paramBoolean7, Boolean paramBoolean8, Boolean paramBoolean9, Integer paramInteger16, Integer paramInteger17, Integer paramInteger18, Integer paramInteger19, Integer paramInteger20, Integer paramInteger21, Boolean paramBoolean10, Integer paramInteger22, Integer paramInteger23, Integer paramInteger24, Integer paramInteger25, Integer paramInteger26, Integer paramInteger27, Integer paramInteger28, Integer paramInteger29, Integer paramInteger30, String paramString1, String paramString2, Integer paramInteger31, Integer paramInteger32, Integer paramInteger33, Boolean paramBoolean11, Integer paramInteger34, Integer paramInteger35, Integer paramInteger36, Integer paramInteger37, Integer paramInteger38, Integer paramInteger39, Boolean paramBoolean12, Boolean paramBoolean13, Integer paramInteger40, Boolean paramBoolean14, Boolean paramBoolean15, Float paramFloat, Boolean paramBoolean16, String paramString3, String paramString4, Boolean paramBoolean17, Integer paramInteger41, Integer paramInteger42, Integer paramInteger43, Integer paramInteger44, Integer paramInteger45, Integer paramInteger46, Integer paramInteger47, Boolean paramBoolean18, Boolean paramBoolean19, Boolean paramBoolean20, Integer paramInteger48, Boolean paramBoolean21, Integer paramInteger49, Boolean paramBoolean22, Integer paramInteger50)
    {
      this.enableComfortNoiseGeneration = paramBoolean1;
      this.enableHighPassFiltering = paramBoolean2;
      this.enableSilenceDetection = paramBoolean3;
      this.callerTimeout = paramInteger1;
      this.jitterBufferImpl = paramInteger2;
      this.jitterBufferDiscardAlgo = paramInteger3;
      this.jitterBufferStretchAlgo = paramInteger4;
      this.audioCallbackThreshold = paramInteger5;
      this.ringbackMode = paramInteger6;
      this.ringbackTone = paramInteger7;
      this.callerEndCallThreshold = paramInteger8;
      this.audioSamplingRate = paramInteger9;
      this.androidAudioEngine = paramInteger10;
      this.androidAudioModeInCall = paramInteger11;
      this.androidRecordPreset = paramInteger12;
      this.androidAudioRecordBufferSize = paramInteger13;
      this.androidAudioPlaybackBufferSize = paramInteger14;
      this.androidShowCallConnectedToast = paramBoolean4;
      this.androidShowCallConnectingToast = paramBoolean5;
      this.androidRingFaster = paramBoolean6;
      this.udpReceiveSocketBufferSize = paramInteger15;
      this.audioEncodeOffload = paramBoolean7;
      this.disableP2P = paramBoolean8;
      this.createStreamOnOffer = paramBoolean9;
      this.initialInterruptionSoundDelay = paramInteger16;
      this.audioFPSThreshold = paramInteger17;
      this.networkRestartTimeout = paramInteger18;
      this.neteqMinDelay = paramInteger19;
      this.neteqMaxDelay = paramInteger20;
      this.neteqBgnMode = paramInteger21;
      this.neteqEnableFF = paramBoolean10;
      this.neteqIatProb = paramInteger22;
      this.neteqIatFactor = paramInteger23;
      this.neteqPeakHeight = paramInteger24;
      this.neteqPeakMaxPeriod = paramInteger25;
      this.neteqCumulativePeakMaxPeriod = paramInteger26;
      this.neteqMaxPacketsInBuf = paramInteger27;
      this.audioLevelAdjust = paramInteger28;
      this.restartAudioOnWhiteNoise = paramInteger29;
      this.callOfferAckTimeout = paramInteger30;
      this.testKey = paramString1;
      this.testValue = paramString2;
      this.ipConfig = paramInteger31;
      this.ipAutoSwitch = paramInteger32;
      this.rtpExtType = paramInteger33;
      this.e2eDecryptEnable = paramBoolean11;
      this.spamCallThresholdDuration = paramInteger34;
      this.videoCodecPriority = paramInteger35;
      this.vp8Cpu = paramInteger36;
      this.lowBatteryNotifyThreshold = paramInteger37;
      this.callStartDelay = paramInteger38;
      this.dimScreenPercentage = paramInteger39;
      this.enableUpnp = paramBoolean12;
      this.enablePortPredicting = paramBoolean13;
      this.portPredictingRange = paramInteger40;
      this.doPortPredictingUnconditionally = paramBoolean14;
      this.enableNewTransportStats = paramBoolean15;
      this.transportStatsP2pThreshold = paramFloat;
      this.enableP2pDuplex = paramBoolean16;
      this.txNetCondParamsInJson = paramString3;
      this.rxNetCondParamsInJson = paramString4;
      this.isOpenGLYUVRenderEnabled = paramBoolean17;
      this.setupVideoStreamBeforeAccept = paramInteger41;
      this.preciseRxTimestampsMask = paramInteger42;
      this.connectedIfReceivedData = paramInteger43;
      this.mtuSize = paramInteger44;
      this.txCacheSizePkts = paramInteger45;
      this.vidJbMaxMs = paramInteger46;
      this.maxAudioTsJitterMs = paramInteger47;
      this.enablePreacceptReceivedUpdate = paramBoolean18;
      this.initAudioInPreaccept = paramBoolean19;
      this.enableVoipCapability = paramBoolean20;
      this.avSyncThresholdMs = paramInteger48;
      this.doUpnpCallback = paramBoolean21;
      this.maxAudioFrameDisorderDistance = paramInteger49;
      this.enableLTRP = paramBoolean22;
      this.vidDecOnNetThread = paramInteger50;
    }
    
    public static Miscellaneous fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new Miscellaneous(VoipOptions.convertAttributeToBoolean(paramak.a("cng", null)), VoipOptions.convertAttributeToBoolean(paramak.a("hpf", null)), VoipOptions.convertAttributeToBoolean(paramak.a("silent_detection", null)), VoipOptions.convertAttributeToInteger(paramak.a("caller_timeout", null), "caller_timeout"), VoipOptions.convertAttributeToInteger(paramak.a("jb_impl", null), "jb_impl"), VoipOptions.convertAttributeToInteger(paramak.a("jb_algo", null), "jb_algo"), VoipOptions.convertAttributeToInteger(paramak.a("jb_stretch", null), "jb_stretch"), VoipOptions.convertAttributeToInteger(paramak.a("audio_cb_threshold", null), "audio_cb_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("ringback_mode", null), "ringback_mode"), VoipOptions.convertAttributeToInteger(paramak.a("ringback_tone", null), "ringback_tone"), VoipOptions.convertAttributeToInteger(paramak.a("caller_end_call_threshold", null), "caller_end_call_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("audio_sampling_rate", null), "audio_sampling_rate"), VoipOptions.convertAttributeToInteger(paramak.a("android_audio_engine", null), "android_audio_engine"), VoipOptions.convertAttributeToInteger(paramak.a("android_audio_mode_in_call", null), "android_audio_mode_in_call"), VoipOptions.convertAttributeToInteger(paramak.a("android_record_preset", null), "android_record_preset"), VoipOptions.convertAttributeToInteger(paramak.a("android_record_buffer_size", null), "android_record_buffer_size"), VoipOptions.convertAttributeToInteger(paramak.a("android_playback_buffer_size", null), "android_playback_buffer_size"), VoipOptions.convertAttributeToBoolean(paramak.a("android_call_connected_toast", null)), VoipOptions.convertAttributeToBoolean(paramak.a("android_call_connecting_toast", null)), VoipOptions.convertAttributeToBoolean(paramak.a("android_ring_faster", null)), VoipOptions.convertAttributeToInteger(paramak.a("sobuf_rcv_size", null), "sobuf_rcv_size"), VoipOptions.convertAttributeToBoolean(paramak.a("audio_encode_offload", null)), VoipOptions.convertAttributeToBoolean(paramak.a("disable_p2p", null)), VoipOptions.convertAttributeToBoolean(paramak.a("create_stream_on_offer", null)), VoipOptions.convertAttributeToInteger(paramak.a("initial_interruption_sound_delay", null), "initial_interruption_sound_delay"), VoipOptions.convertAttributeToInteger(paramak.a("audio_fps_threshold", null), "audio_fps_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("network_transport_restart_timeout", null), "network_transport_restart_timeout"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_min_delay", null), "neteq_min_delay"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_max_delay", null), "neteq_max_delay"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_bgn_mode", null), "neteq_bgn_mode"), VoipOptions.convertAttributeToBoolean(paramak.a("neteq_enable_ff", null)), VoipOptions.convertAttributeToInteger(paramak.a("neteq_iat_prob", null), "neteq_iat_prob"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_iat_factor", null), "neteq_iat_factor"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_peak_height", null), "neteq_peak_height"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_peak_max_period", null), "neteq_peak_max_period"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_cumulative_peak_max_period", null), "neteq_cumulative_peak_max_period"), VoipOptions.convertAttributeToInteger(paramak.a("neteq_max_packets_in_buf", null), "neteq_max_packets_in_buf"), VoipOptions.convertAttributeToInteger(paramak.a("audio_level_adjust", null), "audio_level_adjust"), VoipOptions.convertAttributeToInteger(paramak.a("restart_audio_on_white_noise", null), "restart_audio_on_white_noise"), VoipOptions.convertAttributeToInteger(paramak.a("offer_ack_timeout", null), "offer_ack_timeout"), paramak.a("test_key", null), paramak.a("test_value", null), VoipOptions.convertAttributeToInteger(paramak.a("ip_config", null), "ip_config"), VoipOptions.convertAttributeToInteger(paramak.a("ip_auto_switchover", null), "ip_auto_switchover"), VoipOptions.convertAttributeToInteger(paramak.a("rtp_ext_type", null), "rtp_ext_type"), VoipOptions.convertAttributeToBoolean(paramak.a("e2e_decrypt_enable", null)), VoipOptions.convertAttributeToInteger(paramak.a("spam_call_threshold_seconds", null), "spam_call_threshold_seconds"), VoipOptions.convertAttributeToInteger(paramak.a("video_codec_priority", null), "video_codec_priority"), VoipOptions.convertAttributeToInteger(paramak.a("vp8_cpu", null), "vp8_cpu"), VoipOptions.convertAttributeToInteger(paramak.a("low_battery_notify_threshold", null), "low_battery_notify_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("call_start_delay", null), "call_start_delay"), VoipOptions.convertAttributeToInteger(paramak.a("dim_screen_percentage", null), "dim_screen_percentage"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_upnp", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_port_predicting", null)), VoipOptions.convertAttributeToInteger(paramak.a("port_predicting_range", null), "port_predicting_range"), VoipOptions.convertAttributeToBoolean(paramak.a("do_port_predicting_unconditionally", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_new_transport_stats", null)), VoipOptions.convertAttributeToFloat(paramak.a("transport_stats_p2p_threshold", null), "transport_stats_p2p_threshold"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_p2p_duplex", null)), paramak.a("tx_net_cond_params_in_json", null), paramak.a("rx_net_cond_params_in_json", null), VoipOptions.convertAttributeToBoolean(paramak.a("is_openGL_YUV_render_enabled", null)), VoipOptions.convertAttributeToInteger(paramak.a("setup_video_stream_before_accept", null), "setup_video_stream_before_accept"), VoipOptions.convertAttributeToInteger(paramak.a("precise_rx_timestamps_mask", null), "precise_rx_timestamps_mask"), VoipOptions.convertAttributeToInteger(paramak.a("connected_if_received_data", null), "connected_if_received_data"), VoipOptions.convertAttributeToInteger(paramak.a("mtu_size", null), "mtu_size"), VoipOptions.convertAttributeToInteger(paramak.a("tx_cache_size_pkts", null), "tx_cache_size_pkts"), VoipOptions.convertAttributeToInteger(paramak.a("vid_jb_max_ms", null), "vid_jb_max_ms"), VoipOptions.convertAttributeToInteger(paramak.a("max_audio_ts_jitter_ms", null), "max_audio_ts_jitter_ms"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_preaccept_received_update", null)), VoipOptions.convertAttributeToBoolean(paramak.a("init_audio_in_preaccept", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_voip_capability", null)), VoipOptions.convertAttributeToInteger(paramak.a("av_sync_threshold_ms", null), "av_sync_threshold_ms"), VoipOptions.convertAttributeToBoolean(paramak.a("do_upnp_callback", null)), VoipOptions.convertAttributeToInteger(paramak.a("max_audio_frame_disorder_distance", null), "max_audio_frame_disorder_distance"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_ltrp", null)), VoipOptions.convertAttributeToInteger(paramak.a("vid_dec_on_net_thread", null), "vid_dec_on_net_thread"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Miscellaneous{");
      if (this.enableComfortNoiseGeneration == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableHighPassFiltering != null) {
          break label1335;
        }
        str = "";
        label39:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableSilenceDetection != null) {
          break label1359;
        }
        str = "";
        label56:
        localStringBuilder = localStringBuilder.append(str);
        if (this.callerTimeout != null) {
          break label1383;
        }
        str = "";
        label73:
        localStringBuilder = localStringBuilder.append(str);
        if (this.jitterBufferImpl != null) {
          break label1407;
        }
        str = "";
        label90:
        localStringBuilder = localStringBuilder.append(str);
        if (this.jitterBufferDiscardAlgo != null) {
          break label1431;
        }
        str = "";
        label107:
        localStringBuilder = localStringBuilder.append(str);
        if (this.jitterBufferStretchAlgo != null) {
          break label1455;
        }
        str = "";
        label124:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioCallbackThreshold != null) {
          break label1479;
        }
        str = "";
        label141:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ringbackMode != null) {
          break label1503;
        }
        str = "";
        label158:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ringbackTone != null) {
          break label1527;
        }
        str = "";
        label175:
        localStringBuilder = localStringBuilder.append(str);
        if (this.callerEndCallThreshold != null) {
          break label1551;
        }
        str = "";
        label192:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioSamplingRate != null) {
          break label1575;
        }
        str = "";
        label209:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidAudioEngine != null) {
          break label1599;
        }
        str = "";
        label226:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidAudioModeInCall != null) {
          break label1623;
        }
        str = "";
        label243:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidRecordPreset != null) {
          break label1647;
        }
        str = "";
        label260:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidAudioRecordBufferSize != null) {
          break label1671;
        }
        str = "";
        label277:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidAudioPlaybackBufferSize != null) {
          break label1695;
        }
        str = "";
        label294:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidShowCallConnectedToast != null) {
          break label1719;
        }
        str = "";
        label311:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidShowCallConnectingToast != null) {
          break label1743;
        }
        str = "";
        label328:
        localStringBuilder = localStringBuilder.append(str);
        if (this.androidRingFaster != null) {
          break label1767;
        }
        str = "";
        label345:
        localStringBuilder = localStringBuilder.append(str);
        if (this.udpReceiveSocketBufferSize != null) {
          break label1791;
        }
        str = "";
        label362:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioEncodeOffload != null) {
          break label1815;
        }
        str = "";
        label379:
        localStringBuilder = localStringBuilder.append(str);
        if (this.disableP2P != null) {
          break label1839;
        }
        str = "";
        label396:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initialInterruptionSoundDelay != null) {
          break label1863;
        }
        str = "";
        label413:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioFPSThreshold != null) {
          break label1887;
        }
        str = "";
        label430:
        localStringBuilder = localStringBuilder.append(str);
        if (this.networkRestartTimeout != null) {
          break label1911;
        }
        str = "";
        label447:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqMinDelay != null) {
          break label1935;
        }
        str = "";
        label464:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqMaxDelay != null) {
          break label1959;
        }
        str = "";
        label481:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqBgnMode != null) {
          break label1983;
        }
        str = "";
        label498:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqEnableFF != null) {
          break label2007;
        }
        str = "";
        label515:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqIatProb != null) {
          break label2031;
        }
        str = "";
        label532:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqIatFactor != null) {
          break label2055;
        }
        str = "";
        label549:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqPeakHeight != null) {
          break label2079;
        }
        str = "";
        label566:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqPeakMaxPeriod != null) {
          break label2103;
        }
        str = "";
        label583:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqCumulativePeakMaxPeriod != null) {
          break label2127;
        }
        str = "";
        label600:
        localStringBuilder = localStringBuilder.append(str);
        if (this.neteqMaxPacketsInBuf != null) {
          break label2151;
        }
        str = "";
        label617:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioLevelAdjust != null) {
          break label2175;
        }
        str = "";
        label634:
        localStringBuilder = localStringBuilder.append(str);
        if (this.restartAudioOnWhiteNoise != null) {
          break label2199;
        }
        str = "";
        label651:
        localStringBuilder = localStringBuilder.append(str);
        if (this.callOfferAckTimeout != null) {
          break label2223;
        }
        str = "";
        label668:
        localStringBuilder = localStringBuilder.append(str);
        if (this.testKey != null) {
          break label2247;
        }
        str = "";
        label685:
        localStringBuilder = localStringBuilder.append(str);
        if (this.testValue != null) {
          break label2271;
        }
        str = "";
        label702:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ipConfig != null) {
          break label2295;
        }
        str = "";
        label719:
        localStringBuilder = localStringBuilder.append(str);
        if (this.ipAutoSwitch != null) {
          break label2319;
        }
        str = "";
        label736:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rtpExtType != null) {
          break label2343;
        }
        str = "";
        label753:
        localStringBuilder = localStringBuilder.append(str);
        if (this.e2eDecryptEnable != null) {
          break label2367;
        }
        str = "";
        label770:
        localStringBuilder = localStringBuilder.append(str);
        if (this.spamCallThresholdDuration != null) {
          break label2391;
        }
        str = "";
        label787:
        localStringBuilder = localStringBuilder.append(str);
        if (this.videoCodecPriority != null) {
          break label2415;
        }
        str = "";
        label804:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8Cpu != null) {
          break label2439;
        }
        str = "";
        label821:
        localStringBuilder = localStringBuilder.append(str);
        if (this.lowBatteryNotifyThreshold != null) {
          break label2463;
        }
        str = "";
        label838:
        localStringBuilder = localStringBuilder.append(str);
        if (this.callStartDelay != null) {
          break label2487;
        }
        str = "";
        label855:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dimScreenPercentage != null) {
          break label2511;
        }
        str = "";
        label872:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableUpnp != null) {
          break label2535;
        }
        str = "";
        label889:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enablePortPredicting != null) {
          break label2559;
        }
        str = "";
        label906:
        localStringBuilder = localStringBuilder.append(str);
        if (this.portPredictingRange != null) {
          break label2583;
        }
        str = "";
        label923:
        localStringBuilder = localStringBuilder.append(str);
        if (this.doPortPredictingUnconditionally != null) {
          break label2607;
        }
        str = "";
        label940:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableNewTransportStats != null) {
          break label2631;
        }
        str = "";
        label957:
        localStringBuilder = localStringBuilder.append(str);
        if (this.transportStatsP2pThreshold != null) {
          break label2655;
        }
        str = "";
        label974:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableP2pDuplex != null) {
          break label2679;
        }
        str = "";
        label991:
        localStringBuilder = localStringBuilder.append(str);
        if (this.txNetCondParamsInJson != null) {
          break label2703;
        }
        str = "";
        label1008:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rxNetCondParamsInJson != null) {
          break label2727;
        }
        str = "";
        label1025:
        localStringBuilder = localStringBuilder.append(str);
        if (this.isOpenGLYUVRenderEnabled != null) {
          break label2751;
        }
        str = "";
        label1042:
        localStringBuilder = localStringBuilder.append(str);
        if (this.setupVideoStreamBeforeAccept != null) {
          break label2775;
        }
        str = "";
        label1059:
        localStringBuilder = localStringBuilder.append(str);
        if (this.preciseRxTimestampsMask != null) {
          break label2799;
        }
        str = "";
        label1076:
        localStringBuilder = localStringBuilder.append(str);
        if (this.connectedIfReceivedData != null) {
          break label2823;
        }
        str = "";
        label1093:
        localStringBuilder = localStringBuilder.append(str);
        if (this.mtuSize != null) {
          break label2847;
        }
        str = "";
        label1110:
        localStringBuilder = localStringBuilder.append(str);
        if (this.txCacheSizePkts != null) {
          break label2871;
        }
        str = "";
        label1127:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vidJbMaxMs != null) {
          break label2895;
        }
        str = "";
        label1144:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxAudioTsJitterMs != null) {
          break label2919;
        }
        str = "";
        label1161:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enablePreacceptReceivedUpdate != null) {
          break label2943;
        }
        str = "";
        label1178:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initAudioInPreaccept != null) {
          break label2967;
        }
        str = "";
        label1195:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableVoipCapability != null) {
          break label2991;
        }
        str = "";
        label1212:
        localStringBuilder = localStringBuilder.append(str);
        if (this.avSyncThresholdMs != null) {
          break label3015;
        }
        str = "";
        label1229:
        localStringBuilder = localStringBuilder.append(str);
        if (this.doUpnpCallback != null) {
          break label3039;
        }
        str = "";
        label1246:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxAudioFrameDisorderDistance != null) {
          break label3063;
        }
        str = "";
        label1263:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableLTRP != null) {
          break label3087;
        }
        str = "";
        label1280:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vidDecOnNetThread != null) {
          break label3111;
        }
      }
      label1335:
      label1359:
      label1383:
      label1407:
      label1431:
      label1455:
      label1479:
      label1503:
      label1527:
      label1551:
      label1575:
      label1599:
      label1623:
      label1647:
      label1671:
      label1695:
      label1719:
      label1743:
      label1767:
      label1791:
      label1815:
      label1839:
      label1863:
      label1887:
      label1911:
      label1935:
      label1959:
      label1983:
      label2007:
      label2031:
      label2055:
      label2079:
      label2103:
      label2127:
      label2151:
      label2175:
      label2199:
      label2223:
      label2247:
      label2271:
      label2295:
      label2319:
      label2343:
      label2367:
      label2391:
      label2415:
      label2439:
      label2463:
      label2487:
      label2511:
      label2535:
      label2559:
      label2583:
      label2607:
      label2631:
      label2655:
      label2679:
      label2703:
      label2727:
      label2751:
      label2775:
      label2799:
      label2823:
      label2847:
      label2871:
      label2895:
      label2919:
      label2943:
      label2967:
      label2991:
      label3015:
      label3039:
      label3063:
      label3087:
      label3111:
      for (String str = "";; str = ", vidDecOnNetThread=" + this.vidDecOnNetThread)
      {
        return str + '}';
        str = "enableComfortNoiseGeneration=" + this.enableComfortNoiseGeneration;
        break;
        str = ", enableHighPassFiltering=" + this.enableHighPassFiltering;
        break label39;
        str = ", enableSilenceDetection=" + this.enableSilenceDetection;
        break label56;
        str = ", callerTimeout=" + this.callerTimeout;
        break label73;
        str = ", jitterBufferImpl=" + this.jitterBufferImpl;
        break label90;
        str = ", jitterBufferDiscardAlgo=" + this.jitterBufferDiscardAlgo;
        break label107;
        str = ", jitterBufferStretchAlgo=" + this.jitterBufferStretchAlgo;
        break label124;
        str = ", audioCallbackThreshold=" + this.audioCallbackThreshold;
        break label141;
        str = ", ringbackMode=" + this.ringbackMode;
        break label158;
        str = ", ringbackTone=" + this.ringbackTone;
        break label175;
        str = ", callerEndCallThreshold=" + this.callerEndCallThreshold;
        break label192;
        str = ", audioSamplingRate=" + this.audioSamplingRate;
        break label209;
        str = ", androidAudioEngine=" + this.androidAudioEngine;
        break label226;
        str = ", androidAudioModeInCall=" + this.androidAudioModeInCall;
        break label243;
        str = ", androidRecordPreset=" + this.androidRecordPreset;
        break label260;
        str = ", androidAudioRecordBufferSize=" + this.androidAudioRecordBufferSize;
        break label277;
        str = ", androidAudioPlaybackBufferSize=" + this.androidAudioPlaybackBufferSize;
        break label294;
        str = ", androidShowCallConnectedToast=" + this.androidShowCallConnectedToast;
        break label311;
        str = ", androidShowCallConnectingToast=" + this.androidShowCallConnectingToast;
        break label328;
        str = ", androidRingFaster=" + this.androidRingFaster;
        break label345;
        str = ", udpReceiveSocketBufferSize=" + this.udpReceiveSocketBufferSize;
        break label362;
        str = ", audioEncodeOffload=" + this.audioEncodeOffload;
        break label379;
        str = ", disableP2P=" + this.disableP2P;
        break label396;
        str = ", initialInterruptionSoundDelay=" + this.initialInterruptionSoundDelay;
        break label413;
        str = ", audioFPSThreshold=" + this.audioFPSThreshold;
        break label430;
        str = ", networkRestartTimeout=" + this.networkRestartTimeout;
        break label447;
        str = ", neteqMinDelay=" + this.neteqMinDelay;
        break label464;
        str = ", neteqMaxDelay=" + this.neteqMaxDelay;
        break label481;
        str = ", neteqBgnMode=" + this.neteqBgnMode;
        break label498;
        str = ", neteqEnableFF=" + this.neteqEnableFF;
        break label515;
        str = ", neteqIatProb=" + this.neteqIatProb;
        break label532;
        str = ", neteqIatFactor=" + this.neteqIatFactor;
        break label549;
        str = ", neteqPeakHeight=" + this.neteqPeakHeight;
        break label566;
        str = ", neteqPeakMaxPeriod=" + this.neteqPeakMaxPeriod;
        break label583;
        str = ", neteqCumulativePeakMaxPeriod=" + this.neteqCumulativePeakMaxPeriod;
        break label600;
        str = ", neteqMaxPacketsInBuf=" + this.neteqMaxPacketsInBuf;
        break label617;
        str = ", audioLevelAdjust=" + this.audioLevelAdjust;
        break label634;
        str = ", restartAudioOnWhiteNoise=" + this.restartAudioOnWhiteNoise;
        break label651;
        str = ", callOfferAckTimeout=" + this.callOfferAckTimeout;
        break label668;
        str = ", testKey=" + this.testKey;
        break label685;
        str = ", testValue=" + this.testValue;
        break label702;
        str = ", ipConfig=" + this.ipConfig;
        break label719;
        str = ", ipAutoSwitch=" + this.ipAutoSwitch;
        break label736;
        str = ", rtpExtType=" + this.rtpExtType;
        break label753;
        str = ", e2eDecryptEnable=" + this.e2eDecryptEnable;
        break label770;
        str = ", spamCallThresholdDuration=" + this.spamCallThresholdDuration;
        break label787;
        str = ", videoCodecPriority=" + this.videoCodecPriority;
        break label804;
        str = ", vp8Cpu=" + this.vp8Cpu;
        break label821;
        str = ", lowBatteryNotifyThreshold=" + this.lowBatteryNotifyThreshold;
        break label838;
        str = ", NextCallStartDelay=" + this.callStartDelay;
        break label855;
        str = ", dimScreenPercentage=" + this.dimScreenPercentage;
        break label872;
        str = ", enableUpnp=" + this.enableUpnp;
        break label889;
        str = ", enablePortPredicting=" + this.enablePortPredicting;
        break label906;
        str = ", portPredictingRange=" + this.portPredictingRange;
        break label923;
        str = ", doPortPredictingUnconditionally=" + this.doPortPredictingUnconditionally;
        break label940;
        str = ", enableNewTransportStats=" + this.enableNewTransportStats;
        break label957;
        str = ", transportStatsP2pThreshold=" + this.transportStatsP2pThreshold;
        break label974;
        str = ", enableP2pDuplex=" + this.enableP2pDuplex;
        break label991;
        str = ", txNetCondParamsInJson=" + this.txNetCondParamsInJson;
        break label1008;
        str = ", rxNetCondParamsInJson=" + this.rxNetCondParamsInJson;
        break label1025;
        str = ", isOpenGLYUVRenderEnabled=" + this.isOpenGLYUVRenderEnabled;
        break label1042;
        str = ", setupVideoStreamBeforeAccept=" + this.setupVideoStreamBeforeAccept;
        break label1059;
        str = ", preciseRxTimestampsMask=" + this.preciseRxTimestampsMask;
        break label1076;
        str = ", connectedIfReceivedData=" + this.connectedIfReceivedData;
        break label1093;
        str = ", mtuSize=" + this.mtuSize;
        break label1110;
        str = ", txCacheSizePkts=" + this.txCacheSizePkts;
        break label1127;
        str = ", vidJbMaxMs=" + this.vidJbMaxMs;
        break label1144;
        str = ", maxAudioTsJitterMs=" + this.maxAudioTsJitterMs;
        break label1161;
        str = ", enablePreacceptReceivedUpdate=" + this.enablePreacceptReceivedUpdate;
        break label1178;
        str = ", initAudioInPreaccept=" + this.initAudioInPreaccept;
        break label1195;
        str = ", enableVoipCapability=" + this.enableVoipCapability;
        break label1212;
        str = ", avSyncThresholdMs=" + this.avSyncThresholdMs;
        break label1229;
        str = ", doUpnpCallback=" + this.doUpnpCallback;
        break label1246;
        str = ", maxAudioFrameDisorderDistance=" + this.maxAudioFrameDisorderDistance;
        break label1263;
        str = ", enableLTRP=" + this.enableLTRP;
        break label1280;
      }
    }
  }
  
  @Keep
  public static final class NoiseSuppression
  {
    public final Boolean builtinEnabled;
    public final Short mode;
    public final Integer suppressThreshold;
    
    public NoiseSuppression(Short paramShort, Boolean paramBoolean, Integer paramInteger)
    {
      this.mode = paramShort;
      this.builtinEnabled = paramBoolean;
      this.suppressThreshold = paramInteger;
    }
    
    public static NoiseSuppression fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      String str = paramak.a("mode", null);
      Boolean localBoolean = VoipOptions.convertAttributeToBoolean(paramak.a("builtin", null));
      paramak = VoipOptions.convertAttributeToInteger(paramak.a("suppress_threshold", null), "suppress_threshold");
      return new NoiseSuppression(VoipOptions.convertAttributeToShort(str, "mode", 0, 3), localBoolean, paramak);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NoiseSuppression{");
      if (this.mode == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.suppressThreshold != null) {
          break label89;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.builtinEnabled != null) {
          break label112;
        }
      }
      label89:
      label112:
      for (String str = "";; str = ", builtinEnabled=" + this.builtinEnabled)
      {
        return str + '}';
        str = "mode=" + this.mode;
        break;
        str = ", suppressThreshold=" + this.suppressThreshold;
        break label36;
      }
    }
  }
  
  @Keep
  public static final class RateControl
  {
    public final Boolean audioOobFec;
    public final Integer audioOobFecMaxPkts;
    public final Integer audioOobFecMinPkts;
    public final Boolean audioOobFecPiggyback;
    public final Float audioOobFecRatio;
    public final Boolean audioPiggyback;
    public final Integer audioPiggybackTimeoutMsec;
    public final Integer cellularBitrate;
    public final Integer condMaxPacketLossPct;
    public final Integer condMaxRtt;
    public final Integer condMaxTargetTotalBitrate;
    public final Integer condMinPacketLossPct;
    public final Integer condMinRtt;
    public final Integer condMinTargetTotalBitrate;
    public final Integer condNetMedium;
    public final Boolean disableRateControl;
    public final Integer dtxBweThreshold;
    public final Integer dtxRttThreshold;
    public final Integer dtxWaitPeriod;
    public final Boolean earlyRtt;
    public final Boolean enableAudioOobFecFeature;
    public final Boolean enableAudioPiggybackFeature;
    public final Integer fppRttThreshold;
    public final Integer framesPerPacket;
    public final Integer initBitrate;
    public final Integer initBitrateOnCellular;
    public final Integer lowDataUsageBitrate;
    public final Integer maxBWE;
    public final Integer maxFramesPerPacket;
    public final Integer maxFramesPerPacketDuration;
    public final Integer maxRTT;
    public final Integer maxrttBitrateCap;
    public final Boolean maxrttPauseOnRttIncrease;
    public final Integer maxrttRateIncrease;
    public final Integer minFramesPerPacket;
    public final Integer minRTT;
    public final Integer packetLossHysteresis;
    public final Integer pktSizeThresholdBitrate;
    public final Integer rttHysteresis;
    public final Boolean sendEarlyBWE;
    public final Boolean stop;
    public final Integer totalBitrateHysteresis;
    
    public RateControl(Boolean paramBoolean1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, Boolean paramBoolean2, Integer paramInteger11, Integer paramInteger12, Integer paramInteger13, Integer paramInteger14, Integer paramInteger15, Integer paramInteger16, Integer paramInteger17, Integer paramInteger18, Integer paramInteger19, Integer paramInteger20, Integer paramInteger21, Integer paramInteger22, Integer paramInteger23, Integer paramInteger24, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Integer paramInteger25, Integer paramInteger26, Integer paramInteger27, Integer paramInteger28, Boolean paramBoolean6, Boolean paramBoolean7, Float paramFloat, Integer paramInteger29, Integer paramInteger30, Boolean paramBoolean8, Boolean paramBoolean9, Boolean paramBoolean10, Integer paramInteger31)
    {
      this.stop = paramBoolean1;
      this.condMinPacketLossPct = paramInteger1;
      this.condMaxPacketLossPct = paramInteger2;
      this.condMinTargetTotalBitrate = paramInteger3;
      this.condMaxTargetTotalBitrate = paramInteger4;
      this.condMinRtt = paramInteger5;
      this.condMaxRtt = paramInteger6;
      this.condNetMedium = paramInteger7;
      this.totalBitrateHysteresis = paramInteger8;
      this.packetLossHysteresis = paramInteger9;
      this.rttHysteresis = paramInteger10;
      this.disableRateControl = paramBoolean2;
      this.framesPerPacket = paramInteger11;
      this.minRTT = paramInteger12;
      this.maxRTT = paramInteger13;
      this.initBitrate = paramInteger14;
      this.minFramesPerPacket = paramInteger15;
      this.maxFramesPerPacket = paramInteger16;
      this.maxFramesPerPacketDuration = paramInteger17;
      this.cellularBitrate = paramInteger18;
      this.pktSizeThresholdBitrate = paramInteger19;
      this.lowDataUsageBitrate = paramInteger20;
      this.maxrttRateIncrease = paramInteger21;
      this.initBitrateOnCellular = paramInteger22;
      this.maxrttBitrateCap = paramInteger23;
      this.maxBWE = paramInteger24;
      this.maxrttPauseOnRttIncrease = paramBoolean3;
      this.earlyRtt = paramBoolean4;
      this.sendEarlyBWE = paramBoolean5;
      this.dtxRttThreshold = paramInteger25;
      this.dtxBweThreshold = paramInteger26;
      this.dtxWaitPeriod = paramInteger27;
      this.fppRttThreshold = paramInteger28;
      this.enableAudioOobFecFeature = paramBoolean6;
      this.audioOobFec = paramBoolean7;
      this.audioOobFecRatio = paramFloat;
      this.audioOobFecMinPkts = paramInteger29;
      this.audioOobFecMaxPkts = paramInteger30;
      this.enableAudioPiggybackFeature = paramBoolean8;
      this.audioPiggyback = paramBoolean9;
      this.audioOobFecPiggyback = paramBoolean10;
      this.audioPiggybackTimeoutMsec = paramInteger31;
    }
    
    public static RateControl fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      Boolean localBoolean = VoipOptions.convertAttributeToBoolean(paramak.a("stop", null));
      Integer localInteger1 = VoipOptions.convertAttributeToInteger(paramak.a("min_packet_loss_pct", null), "min_packet_loss_pct");
      Integer localInteger2 = VoipOptions.convertAttributeToInteger(paramak.a("max_packet_loss_pct", null), "max_packet_loss_pct");
      Integer localInteger3 = VoipOptions.convertAttributeToInteger(paramak.a("min_target_total_bitrate", null), "min_target_total_bitrate");
      Integer localInteger4 = VoipOptions.convertAttributeToInteger(paramak.a("max_target_total_bitrate", null), "max_target_total_bitrate");
      Integer localInteger5 = VoipOptions.convertAttributeToInteger(paramak.a("min_rtt", null), "min_rtt");
      Integer localInteger6 = VoipOptions.convertAttributeToInteger(paramak.a("max_rtt", null), "max_rtt");
      Integer localInteger7 = VoipOptions.convertAttributeToInteger(paramak.a("net_medium", null), "net_medium");
      Integer localInteger8 = VoipOptions.convertAttributeToInteger(paramak.a("total_bitrate_hysteresis", null), "total_bitrate_hysteresis");
      Integer localInteger9 = VoipOptions.convertAttributeToInteger(paramak.a("pkt_loss_hysteresis", null), "pkt_loss_hysteresis");
      Integer localInteger10 = VoipOptions.convertAttributeToInteger(paramak.a("rtt_hysteresis", null), "rtt_hysteresis");
      Object localObject2 = paramak.a("enable", null);
      Object localObject4 = paramak.a("fpp", null);
      String str1 = paramak.a("minfpp", null);
      String str2 = paramak.a("maxfpp", null);
      Object localObject6 = paramak.a("minrtt", null);
      Object localObject7 = paramak.a("maxrtt", null);
      Object localObject5 = paramak.a("init_bitrate", null);
      Object localObject3 = paramak.a("cellular_bitrate", null);
      Object localObject1 = paramak.a("pkt_size_thresh_bitrate", null);
      String str3 = paramak.a("low_data_usage_bitrate", null);
      localObject2 = VoipOptions.negate(VoipOptions.access$200((String)localObject2));
      localObject4 = VoipOptions.convertAttributeToInteger((String)localObject4, "fpp", 0, 8);
      localObject6 = VoipOptions.convertAttributeToInteger((String)localObject6, "minrtt");
      localObject7 = VoipOptions.convertAttributeToInteger((String)localObject7, "maxrtt");
      localObject5 = VoipOptions.convertAttributeToInteger((String)localObject5, "init_bitrate");
      localObject3 = VoipOptions.convertAttributeToInteger((String)localObject3, "cellular_bitrate");
      localObject1 = VoipOptions.convertAttributeToInteger((String)localObject1, "pkt_size_thresh_bitrate");
      return new RateControl(localBoolean, localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, localInteger6, localInteger7, localInteger8, localInteger9, localInteger10, (Boolean)localObject2, (Integer)localObject4, (Integer)localObject6, (Integer)localObject7, (Integer)localObject5, VoipOptions.convertAttributeToInteger(str1, "minfpp", 0, 8), VoipOptions.convertAttributeToInteger(str2, "maxfpp", 0, 8), VoipOptions.convertAttributeToInteger(paramak.a("maxfpp_duration", null), "maxfpp_duration"), (Integer)localObject3, (Integer)localObject1, VoipOptions.convertAttributeToInteger(str3, "low_data_usage_bitrate"), VoipOptions.convertAttributeToInteger(paramak.a("maxrtt_rate_increase", null), "maxrtt_rate_increase"), VoipOptions.convertAttributeToInteger(paramak.a("init_bitrate_on_cellular", null), "init_bitrate_on_cellular"), VoipOptions.convertAttributeToInteger(paramak.a("maxrtt_bitrate_cap", null), "maxrtt_bitrate_cap"), VoipOptions.convertAttributeToInteger(paramak.a("maxbwe", null), "maxbwe"), VoipOptions.convertAttributeToBoolean(paramak.a("maxrtt_pause_on_rtt_increase", null)), VoipOptions.convertAttributeToBoolean(paramak.a("early_rtt_computation", null)), VoipOptions.convertAttributeToBoolean(paramak.a("send_early_bitrate_estimate", null)), VoipOptions.convertAttributeToInteger(paramak.a("dtx_rtt_threshold", null), "dtx_rtt_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("dtx_bwe_threshold", null), "dtx_bwe_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("dtx_wait_period", null), "dtx_wait_period"), VoipOptions.convertAttributeToInteger(paramak.a("fpp_rtt_threshold", null), "fpp_rtt_threshold"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_audio_oob_fec_feature", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_audio_oob_fec_for_sender", null)), VoipOptions.convertAttributeToFloat(paramak.a("audio_oob_fec_ratio", null), "audio_oob_fec_ratio"), VoipOptions.convertAttributeToInteger(paramak.a("audio_oob_fec_min_pkts", null), "audio_oob_fec_min_pkts"), VoipOptions.convertAttributeToInteger(paramak.a("audio_oob_fec_max_pkts", null), "audio_oob_fec_max_pkts"), VoipOptions.convertAttributeToBoolean(paramak.a("enable_audio_piggyback_feature", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_audio_pkt_piggyback_for_sender", null)), VoipOptions.convertAttributeToBoolean(paramak.a("enable_audio_oob_fec_pkt_piggyback_for_sender", null)), VoipOptions.convertAttributeToInteger(paramak.a("audio_piggyback_timeout_msec", null), "audio_piggyback_timeout_msec"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("RateControl{");
      if (this.stop == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMinPacketLossPct != null) {
          break label757;
        }
        str = "";
        label39:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMaxPacketLossPct != null) {
          break label781;
        }
        str = "";
        label56:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMinTargetTotalBitrate != null) {
          break label805;
        }
        str = "";
        label73:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMaxTargetTotalBitrate != null) {
          break label829;
        }
        str = "";
        label90:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMinRtt != null) {
          break label853;
        }
        str = "";
        label107:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condMaxRtt != null) {
          break label877;
        }
        str = "";
        label124:
        localStringBuilder = localStringBuilder.append(str);
        if (this.condNetMedium != null) {
          break label901;
        }
        str = "";
        label141:
        localStringBuilder = localStringBuilder.append(str);
        if (this.totalBitrateHysteresis != null) {
          break label925;
        }
        str = "";
        label158:
        localStringBuilder = localStringBuilder.append(str);
        if (this.packetLossHysteresis != null) {
          break label949;
        }
        str = "";
        label175:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rttHysteresis != null) {
          break label973;
        }
        str = "";
        label192:
        localStringBuilder = localStringBuilder.append(str);
        if (this.disableRateControl != null) {
          break label997;
        }
        str = "";
        label209:
        localStringBuilder = localStringBuilder.append(str);
        if (this.framesPerPacket != null) {
          break label1021;
        }
        str = "";
        label226:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minRTT != null) {
          break label1045;
        }
        str = "";
        label243:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxRTT != null) {
          break label1069;
        }
        str = "";
        label260:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initBitrate != null) {
          break label1093;
        }
        str = "";
        label277:
        localStringBuilder = localStringBuilder.append(str);
        if (this.cellularBitrate != null) {
          break label1117;
        }
        str = "";
        label294:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pktSizeThresholdBitrate != null) {
          break label1141;
        }
        str = "";
        label311:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minFramesPerPacket != null) {
          break label1165;
        }
        str = "";
        label328:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxFramesPerPacket != null) {
          break label1189;
        }
        str = "";
        label345:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxFramesPerPacketDuration != null) {
          break label1213;
        }
        str = "";
        label362:
        localStringBuilder = localStringBuilder.append(str);
        if (this.lowDataUsageBitrate != null) {
          break label1237;
        }
        str = "";
        label379:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxrttRateIncrease != null) {
          break label1261;
        }
        str = "";
        label396:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initBitrateOnCellular != null) {
          break label1285;
        }
        str = "";
        label413:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxrttBitrateCap != null) {
          break label1309;
        }
        str = "";
        label430:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBWE != null) {
          break label1333;
        }
        str = "";
        label447:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxrttPauseOnRttIncrease != null) {
          break label1357;
        }
        str = "";
        label464:
        localStringBuilder = localStringBuilder.append(str);
        if (this.earlyRtt != null) {
          break label1381;
        }
        str = "";
        label481:
        localStringBuilder = localStringBuilder.append(str);
        if (this.sendEarlyBWE != null) {
          break label1405;
        }
        str = "";
        label498:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dtxRttThreshold != null) {
          break label1429;
        }
        str = "";
        label515:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dtxBweThreshold != null) {
          break label1453;
        }
        str = "";
        label532:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dtxWaitPeriod != null) {
          break label1477;
        }
        str = "";
        label549:
        localStringBuilder = localStringBuilder.append(str);
        if (this.fppRttThreshold != null) {
          break label1501;
        }
        str = "";
        label566:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableAudioOobFecFeature != null) {
          break label1525;
        }
        str = "";
        label583:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioOobFec != null) {
          break label1549;
        }
        str = "";
        label600:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioOobFecRatio != null) {
          break label1573;
        }
        str = "";
        label617:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioOobFecMinPkts != null) {
          break label1597;
        }
        str = "";
        label634:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioOobFecMaxPkts != null) {
          break label1621;
        }
        str = "";
        label651:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableAudioPiggybackFeature != null) {
          break label1645;
        }
        str = "";
        label668:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioPiggyback != null) {
          break label1669;
        }
        str = "";
        label685:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioOobFecPiggyback != null) {
          break label1693;
        }
        str = "";
        label702:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioPiggybackTimeoutMsec != null) {
          break label1717;
        }
      }
      label757:
      label781:
      label805:
      label829:
      label853:
      label877:
      label901:
      label925:
      label949:
      label973:
      label997:
      label1021:
      label1045:
      label1069:
      label1093:
      label1117:
      label1141:
      label1165:
      label1189:
      label1213:
      label1237:
      label1261:
      label1285:
      label1309:
      label1333:
      label1357:
      label1381:
      label1405:
      label1429:
      label1453:
      label1477:
      label1501:
      label1525:
      label1549:
      label1573:
      label1597:
      label1621:
      label1645:
      label1669:
      label1693:
      label1717:
      for (String str = "";; str = ", audioPiggybackTimeoutMsec=" + this.audioPiggybackTimeoutMsec)
      {
        return str + '}';
        str = ", stop=" + this.stop;
        break;
        str = ", condMinPacketLossPct=" + this.condMinPacketLossPct;
        break label39;
        str = ", condMaxPacketLossPct=" + this.condMaxPacketLossPct;
        break label56;
        str = ", condMinTargetVideoBitrate=" + this.condMinTargetTotalBitrate;
        break label73;
        str = ", condMaxTargetVideoBitrate=" + this.condMaxTargetTotalBitrate;
        break label90;
        str = ", condMinRtt=" + this.condMinRtt;
        break label107;
        str = ", condMaxRtt=" + this.condMaxRtt;
        break label124;
        str = ", condNetMedium=" + this.condNetMedium;
        break label141;
        str = ", totalBitrateHysteresis=" + this.totalBitrateHysteresis;
        break label158;
        str = ", packetLossHysteresis=" + this.packetLossHysteresis;
        break label175;
        str = ", rttHysteresis=" + this.rttHysteresis;
        break label192;
        str = ", disableRateControl=" + this.disableRateControl;
        break label209;
        str = ", framesPerPacket=" + this.framesPerPacket;
        break label226;
        str = ", minrtt=" + this.minRTT;
        break label243;
        str = ", maxrtt=" + this.maxRTT;
        break label260;
        str = ", initBitrate=" + this.initBitrate;
        break label277;
        str = ", cellularBitrate=" + this.cellularBitrate;
        break label294;
        str = ", pktSizeThresholdBitrate=" + this.pktSizeThresholdBitrate;
        break label311;
        str = ", minfpp=" + this.minFramesPerPacket;
        break label328;
        str = ", maxfpp=" + this.maxFramesPerPacket;
        break label345;
        str = ", maxfpp_duration=" + this.maxFramesPerPacketDuration;
        break label362;
        str = ", lowDataUsageBitrate=" + this.lowDataUsageBitrate;
        break label379;
        str = ", maxrttRateIncrease=" + this.maxrttRateIncrease;
        break label396;
        str = ", initBitrateOnCellular=" + this.initBitrateOnCellular;
        break label413;
        str = ", maxrttBitrateCap=" + this.maxrttBitrateCap;
        break label430;
        str = ", maxBWE=" + this.maxBWE;
        break label447;
        str = ", maxrttPauseOnRttIncrease=" + this.maxrttPauseOnRttIncrease;
        break label464;
        str = ", earlyRtt=" + this.earlyRtt;
        break label481;
        str = ", sendEarlyBWE=" + this.sendEarlyBWE;
        break label498;
        str = ", dtxRttThreshold=" + this.dtxRttThreshold;
        break label515;
        str = ", dtxBweThreshold=" + this.dtxBweThreshold;
        break label532;
        str = ", dtxWaitPeriod=" + this.dtxWaitPeriod;
        break label549;
        str = ", fppRttThreshold=" + this.fppRttThreshold;
        break label566;
        str = ", enableAudioOobFecFeature=" + this.enableAudioOobFecFeature;
        break label583;
        str = ", audioOobFec=" + this.audioOobFec;
        break label600;
        str = ", audioOobFec=" + this.audioOobFecRatio;
        break label617;
        str = ", audioOobFec=" + this.audioOobFecMinPkts;
        break label634;
        str = ", audioOobFec=" + this.audioOobFecMaxPkts;
        break label651;
        str = ", enableAudioPiggybackFeature=" + this.enableAudioPiggybackFeature;
        break label668;
        str = ", audioPiggyback=" + this.audioPiggyback;
        break label685;
        str = ", audioOobFecPiggyback=" + this.audioOobFecPiggyback;
        break label702;
      }
    }
  }
  
  @Keep
  public static final class RelayElection
  {
    public final Short mode;
    public final Integer p2pRequestTimeout;
    public final Short pingCalcMode;
    public final Integer pingInterval;
    public final Integer pingRounds;
    public final Integer pingUpdateInterval;
    public final Short timestampSource;
    
    public RelayElection(Short paramShort1, Short paramShort2, Short paramShort3, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
    {
      this.mode = paramShort1;
      this.timestampSource = paramShort2;
      this.pingCalcMode = paramShort3;
      this.pingInterval = paramInteger1;
      this.pingRounds = paramInteger2;
      this.pingUpdateInterval = paramInteger3;
      this.p2pRequestTimeout = paramInteger4;
    }
    
    public static RelayElection fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new RelayElection(VoipOptions.convertAttributeToShort(paramak.a("mode", null), "mode", 0, 7), VoipOptions.convertAttributeToShort(paramak.a("timestamp", null), "timestamp", 0, 7), VoipOptions.convertAttributeToShort(paramak.a("p_calc", null), "p_calc", 0, 7), VoipOptions.convertAttributeToInteger(paramak.a("p_interval", null), "p_interval"), VoipOptions.convertAttributeToInteger(paramak.a("p_rounds", null), "p_rounds"), VoipOptions.convertAttributeToInteger(paramak.a("p_update_interval", null), "p_update_interval"), VoipOptions.convertAttributeToInteger(paramak.a("p2p_request_timeout", null), "p2p_request_timeout"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("RelayElection{");
      if (this.mode == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.timestampSource != null) {
          break label153;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pingCalcMode != null) {
          break label176;
        }
        str = "";
        label52:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pingRounds != null) {
          break label199;
        }
        str = "";
        label68:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pingInterval != null) {
          break label222;
        }
        str = "";
        label84:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pingUpdateInterval != null) {
          break label245;
        }
        str = "";
        label100:
        localStringBuilder = localStringBuilder.append(str);
        if (this.p2pRequestTimeout != null) {
          break label268;
        }
      }
      label153:
      label176:
      label199:
      label222:
      label245:
      label268:
      for (String str = "";; str = ", p2pRequestTimeout=" + this.p2pRequestTimeout)
      {
        return str + '}';
        str = "mode=" + this.mode;
        break;
        str = ", timestampSource=" + this.timestampSource;
        break label36;
        str = ", pingCalcMode=" + this.pingCalcMode;
        break label52;
        str = ", pingRounds=" + this.pingRounds;
        break label68;
        str = ", pingInterval=" + this.pingInterval;
        break label84;
        str = ", pingUpdateInterval=" + this.pingUpdateInterval;
        break label100;
      }
    }
  }
  
  @Keep
  public static final class Resend
  {
    public final Integer bweThreshold;
    public final Integer delayPackets;
    public final Boolean dryRun;
    public final Boolean forceDtx;
    public final Integer maxBitrate;
    public final Integer packetLossThreshold;
    
    public Resend(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      this.packetLossThreshold = paramInteger1;
      this.bweThreshold = paramInteger2;
      this.maxBitrate = paramInteger3;
      this.delayPackets = paramInteger4;
      this.forceDtx = paramBoolean1;
      this.dryRun = paramBoolean2;
    }
    
    public static Resend fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new Resend(VoipOptions.convertAttributeToInteger(paramak.a("pl", null), "pl"), VoipOptions.convertAttributeToInteger(paramak.a("bwe_threshold", null), "bwe_threshold"), VoipOptions.convertAttributeToInteger(paramak.a("max_bitrate", null), "max_bitrate"), VoipOptions.convertAttributeToInteger(paramak.a("delay_pkts", null), "delay_pkts"), VoipOptions.convertAttributeToBoolean(paramak.a("force_dtx", null)), VoipOptions.convertAttributeToBoolean(paramak.a("dry_run", null)));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Resend{");
      if (this.packetLossThreshold == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.bweThreshold != null) {
          break label137;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBitrate != null) {
          break label160;
        }
        str = "";
        label52:
        localStringBuilder = localStringBuilder.append(str);
        if (this.delayPackets != null) {
          break label183;
        }
        str = "";
        label68:
        localStringBuilder = localStringBuilder.append(str);
        if (this.forceDtx != null) {
          break label206;
        }
        str = "";
        label84:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dryRun != null) {
          break label229;
        }
      }
      label137:
      label160:
      label183:
      label206:
      label229:
      for (String str = "";; str = "dryRun=" + this.dryRun)
      {
        return str + '}';
        str = "packetLossThreshold=" + this.packetLossThreshold;
        break;
        str = "bweThreshold=" + this.bweThreshold;
        break label36;
        str = "maxBitrate=" + this.maxBitrate;
        break label52;
        str = "delayPackets=" + this.delayPackets;
        break label68;
        str = "forceDtx=" + this.forceDtx;
        break label84;
      }
    }
  }
  
  @Keep
  public static final class TrafficShaper
  {
    public final Integer audioPriority;
    public final Integer dropThreshold;
    public final Float maxBitrateMultiplier;
    public final Integer maxDelay;
    public final Integer maxPackets;
    public final Integer minSpacing;
    public final Integer queueStrategy;
    public final Integer temporalPacketDrop;
    public final Integer tickLength;
    public final Integer windowSize;
    
    public TrafficShaper(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Float paramFloat, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9)
    {
      this.minSpacing = paramInteger1;
      this.tickLength = paramInteger2;
      this.windowSize = paramInteger3;
      this.audioPriority = paramInteger4;
      this.maxDelay = paramInteger5;
      this.maxPackets = paramInteger6;
      this.maxBitrateMultiplier = paramFloat;
      this.dropThreshold = paramInteger7;
      this.queueStrategy = paramInteger8;
      this.temporalPacketDrop = paramInteger9;
    }
    
    public static TrafficShaper fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new TrafficShaper(VoipOptions.convertAttributeToInteger(paramak, "min_spacing"), VoipOptions.convertAttributeToInteger(paramak, "tick_length"), VoipOptions.convertAttributeToInteger(paramak, "window_size"), VoipOptions.convertAttributeToInteger(paramak, "audio_priority"), VoipOptions.convertAttributeToInteger(paramak, "max_delay"), VoipOptions.convertAttributeToInteger(paramak, "max_packets"), VoipOptions.convertAttributeToFloat(paramak, "max_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "drop_threshold"), VoipOptions.convertAttributeToInteger(paramak, "queue_strategy"), VoipOptions.convertAttributeToInteger(paramak, "temporal_packet_drop"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("TrafficShaper{");
      if (this.minSpacing != null)
      {
        str = "minSpacing=" + this.minSpacing + "ms";
        localStringBuilder = localStringBuilder.append(str);
        if (this.tickLength == null) {
          break label369;
        }
        str = "tickLength=" + this.tickLength + "ms";
        label80:
        localStringBuilder = localStringBuilder.append(str);
        if (this.windowSize == null) {
          break label375;
        }
        str = "windowSize=" + this.windowSize;
        label113:
        localStringBuilder = localStringBuilder.append(str);
        if (this.audioPriority == null) {
          break label381;
        }
        str = "audioPriority=" + this.audioPriority;
        label146:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxDelay == null) {
          break label387;
        }
        str = "maxDelay=" + this.maxDelay + "ms";
        label184:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxPackets == null) {
          break label393;
        }
        str = "maxPackets=" + this.maxPackets;
        label217:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBitrateMultiplier == null) {
          break label399;
        }
        str = "maxBitrateMultiplier=" + this.maxBitrateMultiplier;
        label250:
        localStringBuilder = localStringBuilder.append(str);
        if (this.dropThreshold == null) {
          break label405;
        }
        str = "dropThreshold=" + this.dropThreshold;
        label283:
        localStringBuilder = localStringBuilder.append(str);
        if (this.queueStrategy == null) {
          break label411;
        }
        str = "queueStrategy=" + this.queueStrategy;
        label316:
        localStringBuilder = localStringBuilder.append(str);
        if (this.temporalPacketDrop == null) {
          break label417;
        }
      }
      label369:
      label375:
      label381:
      label387:
      label393:
      label399:
      label405:
      label411:
      label417:
      for (String str = "temporalPacketDrop=" + this.temporalPacketDrop;; str = "")
      {
        return str + '}';
        str = "";
        break;
        str = "";
        break label80;
        str = "";
        break label113;
        str = "";
        break label146;
        str = "";
        break label184;
        str = "";
        break label217;
        str = "";
        break label250;
        str = "";
        break label283;
        str = "";
        break label316;
      }
    }
  }
  
  @Keep
  public static final class VideoBatteryRateControl
  {
    public final Integer dropThreshold;
    public final Integer lowThreshold;
    public final Integer maxBitrate;
    public final Integer maxFps;
    public final Integer maxWidth;
    
    public VideoBatteryRateControl(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
    {
      this.dropThreshold = paramInteger1;
      this.lowThreshold = paramInteger2;
      this.maxBitrate = paramInteger3;
      this.maxFps = paramInteger4;
      this.maxWidth = paramInteger5;
    }
    
    public static VideoBatteryRateControl fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new VideoBatteryRateControl(VoipOptions.convertAttributeToInteger(paramak, "drop_threshold"), VoipOptions.convertAttributeToInteger(paramak, "low_threshold"), VoipOptions.convertAttributeToInteger(paramak, "max_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "max_fps"), VoipOptions.convertAttributeToInteger(paramak, "max_width"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("VideoBatteryRateControl{");
      if (this.dropThreshold != null)
      {
        str = "dropThreshold=" + this.dropThreshold;
        localStringBuilder = localStringBuilder.append(str);
        if (this.lowThreshold == null) {
          break label189;
        }
        str = "lowThreshold=" + this.lowThreshold;
        label70:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBitrate == null) {
          break label195;
        }
        str = ", maxBitrate=" + this.maxBitrate;
        label103:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxFps == null) {
          break label201;
        }
        str = ", maxFps=" + this.maxFps;
        label136:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxWidth == null) {
          break label207;
        }
      }
      label189:
      label195:
      label201:
      label207:
      for (String str = ", maxWidth=" + this.maxWidth;; str = "")
      {
        return str + '}';
        str = "";
        break;
        str = "";
        break label70;
        str = "";
        break label103;
        str = "";
        break label136;
      }
    }
  }
  
  @Keep
  public static final class VideoDriver
  {
    public final Integer backCameraHeight;
    public final Integer backCameraWidth;
    public final Integer cameraHeight;
    public final Integer cameraWidth;
    public final Integer decoderBaselineHack;
    public final Integer decoderColorFormat;
    public final Integer decoderConstrainedHighHack;
    public final Integer decoderCsdHack;
    public final Integer decoderFrameConverterColorId;
    public final String decoderName;
    public final Integer decoderRestartOnNewSpsPps;
    public final Integer decoderRestrictionHack;
    public final Integer encoderAlignment;
    public final Integer encoderColorFormat;
    public final Integer encoderFrameConverterColorId;
    public final Integer encoderH264Level;
    public final Integer encoderH264Profile;
    public final Integer encoderMinHeight;
    public final Integer encoderMinWidth;
    public final String encoderName;
    
    public VideoDriver(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, Integer paramInteger11, String paramString2, Integer paramInteger12, Integer paramInteger13, Integer paramInteger14, Integer paramInteger15, Integer paramInteger16, Integer paramInteger17, Integer paramInteger18)
    {
      this.cameraWidth = paramInteger1;
      this.cameraHeight = paramInteger2;
      this.backCameraWidth = paramInteger3;
      this.backCameraHeight = paramInteger4;
      this.encoderName = paramString1;
      this.encoderColorFormat = paramInteger5;
      this.encoderFrameConverterColorId = paramInteger6;
      this.encoderAlignment = paramInteger7;
      this.encoderMinWidth = paramInteger8;
      this.encoderMinHeight = paramInteger9;
      this.encoderH264Profile = paramInteger10;
      this.encoderH264Level = paramInteger11;
      this.decoderName = paramString2;
      this.decoderColorFormat = paramInteger12;
      this.decoderFrameConverterColorId = paramInteger13;
      this.decoderBaselineHack = paramInteger14;
      this.decoderRestrictionHack = paramInteger15;
      this.decoderConstrainedHighHack = paramInteger16;
      this.decoderCsdHack = paramInteger17;
      this.decoderRestartOnNewSpsPps = paramInteger18;
    }
    
    public static VideoDriver fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new VideoDriver(VoipOptions.convertAttributeToInteger(paramak, "camera_width"), VoipOptions.convertAttributeToInteger(paramak, "camera_height"), VoipOptions.convertAttributeToInteger(paramak, "back_camera_width"), VoipOptions.convertAttributeToInteger(paramak, "back_camera_height"), paramak.b("encoder_name"), VoipOptions.convertAttributeToInteger(paramak, "encoder_color_format"), VoipOptions.convertAttributeToInteger(paramak, "encoder_frame_converter_color_format"), VoipOptions.convertAttributeToInteger(paramak, "encoder_alignment"), VoipOptions.convertAttributeToInteger(paramak, "encoder_min_width"), VoipOptions.convertAttributeToInteger(paramak, "encoder_min_height"), VoipOptions.convertAttributeToInteger(paramak, "encoder_h264_profile"), VoipOptions.convertAttributeToInteger(paramak, "encoder_h264_level"), paramak.b("decoder_name"), VoipOptions.convertAttributeToInteger(paramak, "decoder_color_format"), VoipOptions.convertAttributeToInteger(paramak, "decoder_frame_converter_color_format"), VoipOptions.convertAttributeToInteger(paramak, "decoder_baseline_hack"), VoipOptions.convertAttributeToInteger(paramak, "decoder_restriction_hack"), VoipOptions.convertAttributeToInteger(paramak, "decoder_constrained_high_hack"), VoipOptions.convertAttributeToInteger(paramak, "decoder_sps_pps_in_csd"), VoipOptions.convertAttributeToInteger(paramak, "decoder_restart_on_new_sps_pps"));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("VideoDriver{");
      if (this.cameraWidth != null)
      {
        str = "cameraWidth=" + this.cameraWidth;
        localStringBuilder = localStringBuilder.append(str);
        if (this.cameraHeight == null) {
          break label684;
        }
        str = ", cameraHeight=" + this.cameraHeight;
        label70:
        localStringBuilder = localStringBuilder.append(str);
        if (this.backCameraWidth == null) {
          break label690;
        }
        str = "backCameraWidth=" + this.backCameraWidth;
        label103:
        localStringBuilder = localStringBuilder.append(str);
        if (this.backCameraHeight == null) {
          break label696;
        }
        str = ", backCameraHeight=" + this.backCameraHeight;
        label136:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderName == null) {
          break label702;
        }
        str = ", encoderName=" + this.encoderName;
        label169:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderColorFormat == null) {
          break label708;
        }
        str = ", encoderColorFormat=" + this.encoderColorFormat;
        label202:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderFrameConverterColorId == null) {
          break label714;
        }
        str = ", encoderFrameConverterColorId=" + this.encoderFrameConverterColorId;
        label235:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderAlignment == null) {
          break label720;
        }
        str = ", encoderAlignment=" + this.encoderAlignment;
        label268:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderMinWidth == null) {
          break label726;
        }
        str = ", encoderMinWidth=" + this.encoderMinWidth;
        label301:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderMinHeight == null) {
          break label732;
        }
        str = ", encoderMinHeight=" + this.encoderMinHeight;
        label334:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderH264Profile == null) {
          break label738;
        }
        str = ", encoderH264Profile=" + this.encoderH264Profile;
        label367:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderH264Level == null) {
          break label744;
        }
        str = ", encoderH264Level=" + this.encoderH264Level;
        label400:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderName == null) {
          break label750;
        }
        str = ", decoderName=" + this.decoderName;
        label433:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderColorFormat == null) {
          break label756;
        }
        str = ", decoderColorFormat=" + this.decoderColorFormat;
        label466:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderFrameConverterColorId == null) {
          break label762;
        }
        str = ", decoderFrameConverterColorId=" + this.decoderFrameConverterColorId;
        label499:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderBaselineHack == null) {
          break label768;
        }
        str = ", decoderBaselineHack=" + this.decoderBaselineHack;
        label532:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderRestrictionHack == null) {
          break label774;
        }
        str = ", decoderRestrictionHack=" + this.decoderRestrictionHack;
        label565:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderConstrainedHighHack == null) {
          break label780;
        }
        str = ", decoderConstrainedHighHack=" + this.decoderConstrainedHighHack;
        label598:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderCsdHack == null) {
          break label786;
        }
        str = ", decoderCsdHack=" + this.decoderCsdHack;
        label631:
        localStringBuilder = localStringBuilder.append(str);
        if (this.decoderRestartOnNewSpsPps == null) {
          break label792;
        }
      }
      label684:
      label690:
      label696:
      label702:
      label708:
      label714:
      label720:
      label726:
      label732:
      label738:
      label744:
      label750:
      label756:
      label762:
      label768:
      label774:
      label780:
      label786:
      label792:
      for (String str = ", decoderRestartOnNewSpsPps=" + this.decoderRestartOnNewSpsPps;; str = "")
      {
        return str + '}';
        str = "";
        break;
        str = "";
        break label70;
        str = "";
        break label103;
        str = "";
        break label136;
        str = "";
        break label169;
        str = "";
        break label202;
        str = "";
        break label235;
        str = "";
        break label268;
        str = "";
        break label301;
        str = "";
        break label334;
        str = "";
        break label367;
        str = "";
        break label400;
        str = "";
        break label433;
        str = "";
        break label466;
        str = "";
        break label499;
        str = "";
        break label532;
        str = "";
        break label565;
        str = "";
        break label598;
        str = "";
        break label631;
      }
    }
  }
  
  @Keep
  public static final class VideoRateControl
  {
    public final Integer bitrateHysteresis;
    public final Integer cellularBitrate;
    public final Integer codecSubType;
    public final Integer codecType;
    public final Integer constraintAudioBitrateThreshold;
    public final Integer doubleRttCongestionThreshold;
    public final Boolean enableFrameDropper;
    public final Integer encoderFormatChangeWaitMs;
    public final Boolean equalizePacketSizes;
    public final Integer fecForKeyFrame;
    public final Integer fecToPacketLossTimes10;
    public final Integer initBitrate;
    public final Integer initialRttCongestionThreshold;
    public final Integer keyFrameInterval;
    public final Integer lowDataUsageBitrate;
    public final Integer maxBwe;
    public final Integer maxCaptureWidth;
    public final Integer maxDecreaseFactorOnCongestion;
    public final Integer maxEncodeWidth;
    public final Integer maxFecRatio;
    public final Integer maxFps;
    public final Integer maxKeyFrameModeBitrate;
    public final Integer maxPacketLossPct;
    public final Integer maxRtt;
    public final Integer maxTargetBitrate;
    public final Integer minBwe;
    public final Integer minDecreaseFactorOnCongestion;
    public final Integer minFecRatio;
    public final Integer minFragmentationSize;
    public final Integer minPacketLossPct;
    public final Integer minPacketsPerFrame;
    public final Integer minRtt;
    public final Integer minSenderEstimateOnDrop;
    public final Integer minSenderEstimateOnTarget;
    public final Integer minTargetBitrate;
    public final Integer monochromeModeRatio;
    public final Boolean nackOnlyAfterKeyframe;
    public final Integer nackRttInteractiveThreshold;
    public final Integer nackRttUltraLowThreshold;
    public final Integer netMedium;
    public final Integer noDataReceivedThreshold;
    public final Integer noRtcpReceivedThreshold;
    public final Integer packetLossMode;
    public final Integer packetLossThresholdInMilliseconds;
    public final Integer packetLossThresholdInPackets;
    public final Integer pktLossHysteresis;
    public final Integer rcPolicy;
    public final Integer rttCongestionStepEMA;
    public final Integer rttCongestionStepHighest;
    public final Integer rttCongestionStepPrevious;
    public final Integer rttHysteresis;
    public final Integer senderDecRatio;
    public final Integer senderIncRatio;
    public final Integer senderLossHigh;
    public final Integer senderLossLow;
    public final Integer senderSideRcPolicy;
    public final Boolean stop;
    public final Integer stopVideoEncodingRttThreshold;
    public final Float vp8BitrateMultiplier;
    public final Integer vp8DropFrameThreshold;
    public final Integer vp8EncMaxLatency;
    public final Integer vp8ErrorResilient;
    public final Integer vp8MaxQp;
    public final Integer vp8MinQp;
    public final Integer vp8NoiseSensitivity;
    public final Integer vp8StaticThreshold;
    public final Integer vp8TemporalMode;
    public final Float vsceAbsLatencyTopEndThreshold;
    public final Integer vsceAlternateLatencyWindowSize;
    public final Float vsceBurstPktLossThreshold;
    public final Float vsceDelayResponseRttRatio;
    public final Float vsceEmaCrossMargin;
    public final Float vsceEmaHigherFreqWeight;
    public final Float vsceEmaLowerFreqWeight;
    public final Float vsceEmaPktLossSizeWeight;
    public final Boolean vsceEnabled;
    public final Float vsceFecPktLossRatio;
    public final Float vsceFecPktLossThreshold;
    public final Integer vsceHighRttThreshold;
    public final Integer vsceInitialCautiousPeriod;
    
    public VideoRateControl(Boolean paramBoolean1, Float paramFloat1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, Integer paramInteger8, Integer paramInteger9, Integer paramInteger10, Integer paramInteger11, Integer paramInteger12, Integer paramInteger13, Integer paramInteger14, Integer paramInteger15, Integer paramInteger16, Integer paramInteger17, Integer paramInteger18, Integer paramInteger19, Integer paramInteger20, Integer paramInteger21, Integer paramInteger22, Integer paramInteger23, Integer paramInteger24, Integer paramInteger25, Integer paramInteger26, Integer paramInteger27, Integer paramInteger28, Integer paramInteger29, Integer paramInteger30, Integer paramInteger31, Integer paramInteger32, Integer paramInteger33, Integer paramInteger34, Integer paramInteger35, Boolean paramBoolean2, Integer paramInteger36, Integer paramInteger37, Integer paramInteger38, Integer paramInteger39, Integer paramInteger40, Integer paramInteger41, Integer paramInteger42, Integer paramInteger43, Integer paramInteger44, Boolean paramBoolean3, Float paramFloat2, Float paramFloat3, Float paramFloat4, Float paramFloat5, Float paramFloat6, Integer paramInteger45, Float paramFloat7, Float paramFloat8, Integer paramInteger46, Float paramFloat9, Float paramFloat10, Integer paramInteger47, Integer paramInteger48, Integer paramInteger49, Integer paramInteger50, Integer paramInteger51, Integer paramInteger52, Integer paramInteger53, Integer paramInteger54, Integer paramInteger55, Integer paramInteger56, Integer paramInteger57, Integer paramInteger58, Integer paramInteger59, Integer paramInteger60, Integer paramInteger61, Boolean paramBoolean4, Integer paramInteger62, Integer paramInteger63, Integer paramInteger64, Integer paramInteger65, Boolean paramBoolean5)
    {
      this.stop = paramBoolean1;
      this.vp8BitrateMultiplier = paramFloat1;
      this.vp8DropFrameThreshold = paramInteger1;
      this.vp8NoiseSensitivity = paramInteger2;
      this.vp8MinQp = paramInteger3;
      this.vp8MaxQp = paramInteger4;
      this.vp8ErrorResilient = paramInteger5;
      this.vp8StaticThreshold = paramInteger6;
      this.vp8TemporalMode = paramInteger7;
      this.vp8EncMaxLatency = paramInteger8;
      this.minRtt = paramInteger9;
      this.maxRtt = paramInteger10;
      this.netMedium = paramInteger11;
      this.packetLossMode = paramInteger12;
      this.senderLossLow = paramInteger13;
      this.senderLossHigh = paramInteger14;
      this.senderIncRatio = paramInteger15;
      this.senderDecRatio = paramInteger16;
      this.minTargetBitrate = paramInteger17;
      this.maxTargetBitrate = paramInteger18;
      this.rcPolicy = paramInteger19;
      this.maxCaptureWidth = paramInteger20;
      this.maxEncodeWidth = paramInteger21;
      this.maxFps = paramInteger22;
      this.keyFrameInterval = paramInteger23;
      this.lowDataUsageBitrate = paramInteger24;
      this.cellularBitrate = paramInteger25;
      this.encoderFormatChangeWaitMs = paramInteger26;
      this.minPacketLossPct = paramInteger27;
      this.maxPacketLossPct = paramInteger28;
      this.minFecRatio = paramInteger29;
      this.maxFecRatio = paramInteger30;
      this.fecToPacketLossTimes10 = paramInteger31;
      this.fecForKeyFrame = paramInteger32;
      this.codecType = paramInteger33;
      this.codecSubType = paramInteger34;
      this.maxKeyFrameModeBitrate = paramInteger35;
      this.enableFrameDropper = paramBoolean2;
      this.minSenderEstimateOnDrop = paramInteger36;
      this.minSenderEstimateOnTarget = paramInteger37;
      this.monochromeModeRatio = paramInteger38;
      this.senderSideRcPolicy = paramInteger39;
      this.initBitrate = paramInteger40;
      this.packetLossThresholdInPackets = paramInteger41;
      this.packetLossThresholdInMilliseconds = paramInteger42;
      this.minBwe = paramInteger43;
      this.maxBwe = paramInteger44;
      this.vsceEnabled = paramBoolean3;
      this.vsceEmaHigherFreqWeight = paramFloat2;
      this.vsceEmaLowerFreqWeight = paramFloat3;
      this.vsceEmaCrossMargin = paramFloat4;
      this.vsceEmaPktLossSizeWeight = paramFloat5;
      this.vsceBurstPktLossThreshold = paramFloat6;
      this.vsceAlternateLatencyWindowSize = paramInteger45;
      this.vsceDelayResponseRttRatio = paramFloat7;
      this.vsceAbsLatencyTopEndThreshold = paramFloat8;
      this.vsceHighRttThreshold = paramInteger46;
      this.vsceFecPktLossThreshold = paramFloat9;
      this.vsceFecPktLossRatio = paramFloat10;
      this.vsceInitialCautiousPeriod = paramInteger47;
      this.bitrateHysteresis = paramInteger48;
      this.rttHysteresis = paramInteger49;
      this.pktLossHysteresis = paramInteger50;
      this.minDecreaseFactorOnCongestion = paramInteger51;
      this.maxDecreaseFactorOnCongestion = paramInteger52;
      this.initialRttCongestionThreshold = paramInteger53;
      this.rttCongestionStepHighest = paramInteger54;
      this.rttCongestionStepPrevious = paramInteger55;
      this.rttCongestionStepEMA = paramInteger56;
      this.stopVideoEncodingRttThreshold = paramInteger57;
      this.doubleRttCongestionThreshold = paramInteger58;
      this.noRtcpReceivedThreshold = paramInteger59;
      this.noDataReceivedThreshold = paramInteger60;
      this.minPacketsPerFrame = paramInteger61;
      this.equalizePacketSizes = paramBoolean4;
      this.minFragmentationSize = paramInteger62;
      this.constraintAudioBitrateThreshold = paramInteger63;
      this.nackRttInteractiveThreshold = paramInteger64;
      this.nackRttUltraLowThreshold = paramInteger65;
      this.nackOnlyAfterKeyframe = paramBoolean5;
    }
    
    public static VideoRateControl fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new VideoRateControl(VoipOptions.convertAttributeToBoolean(paramak.b("stop")), VoipOptions.convertAttributeToFloat(paramak, "vp8_bitrate_multiplier"), VoipOptions.convertAttributeToInteger(paramak, "vp8_drop_frame_threshold"), VoipOptions.convertAttributeToInteger(paramak, "vp8_noise_sensitivity"), VoipOptions.convertAttributeToInteger(paramak, "vp8_min_qp"), VoipOptions.convertAttributeToInteger(paramak, "vp8_max_qp"), VoipOptions.convertAttributeToInteger(paramak, "vp8_error_resilient"), VoipOptions.convertAttributeToInteger(paramak, "vp8_static_threshold"), VoipOptions.convertAttributeToInteger(paramak, "vp8_temporal_mode"), VoipOptions.convertAttributeToInteger(paramak, "vp8_enc_max_latency"), VoipOptions.convertAttributeToInteger(paramak, "min_rtt"), VoipOptions.convertAttributeToInteger(paramak, "max_rtt"), VoipOptions.convertAttributeToInteger(paramak, "net_medium"), VoipOptions.convertAttributeToInteger(paramak, "packet_loss_mode"), VoipOptions.convertAttributeToInteger(paramak, "sender_loss_low"), VoipOptions.convertAttributeToInteger(paramak, "sender_loss_high"), VoipOptions.convertAttributeToInteger(paramak, "sender_inc_ratio"), VoipOptions.convertAttributeToInteger(paramak, "sender_dec_ratio"), VoipOptions.convertAttributeToInteger(paramak, "min_target_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "max_target_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "rc_policy"), VoipOptions.convertAttributeToInteger(paramak, "max_capture_width"), VoipOptions.convertAttributeToInteger(paramak, "max_encode_width"), VoipOptions.convertAttributeToInteger(paramak, "max_fps"), VoipOptions.convertAttributeToInteger(paramak, "key_frame_interval"), VoipOptions.convertAttributeToInteger(paramak, "low_data_usage_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "cellular_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "encode_fmt_change_wait"), VoipOptions.convertAttributeToInteger(paramak, "min_packet_loss_pct"), VoipOptions.convertAttributeToInteger(paramak, "max_packet_loss_pct"), VoipOptions.convertAttributeToInteger(paramak, "min_fec_ratio"), VoipOptions.convertAttributeToInteger(paramak, "max_fec_ratio"), VoipOptions.convertAttributeToInteger(paramak, "fec_to_packet_loss_times_10"), VoipOptions.convertAttributeToInteger(paramak, "enable_fec_for_key_frames"), VoipOptions.convertAttributeToInteger(paramak, "codec_type"), VoipOptions.convertAttributeToInteger(paramak, "codec_sub_type"), VoipOptions.convertAttributeToInteger(paramak, "max_key_frame_mode_bitrate"), VoipOptions.convertAttributeToBoolean(paramak.b("enable_frame_dropper")), VoipOptions.convertAttributeToInteger(paramak, "min_sender_estimate_on_drop"), VoipOptions.convertAttributeToInteger(paramak, "min_sender_estimate_on_target"), VoipOptions.convertAttributeToInteger(paramak, "monochrome_mode_ratio"), VoipOptions.convertAttributeToInteger(paramak, "sender_side_rc_policy"), VoipOptions.convertAttributeToInteger(paramak, "init_bitrate"), VoipOptions.convertAttributeToInteger(paramak, "pkt_loss_threshold_in_packets"), VoipOptions.convertAttributeToInteger(paramak, "pkt_loss_threshold_in_milliseconds"), VoipOptions.convertAttributeToInteger(paramak, "minbwe"), VoipOptions.convertAttributeToInteger(paramak, "maxbwe"), VoipOptions.convertAttributeToBoolean(paramak.b("vsce_enabled")), VoipOptions.convertAttributeToFloat(paramak, "vsce_ema_higher_freq_weight"), VoipOptions.convertAttributeToFloat(paramak, "vsce_ema_lower_freq_weight"), VoipOptions.convertAttributeToFloat(paramak, "vsce_ema_cross_margin"), VoipOptions.convertAttributeToFloat(paramak, "vsce_ema_pkt_loss_size_weight"), VoipOptions.convertAttributeToFloat(paramak, "vsce_burst_pkt_loss_threshold"), VoipOptions.convertAttributeToInteger(paramak, "vsce_alternate_latency_window_size"), VoipOptions.convertAttributeToFloat(paramak, "vsce_delay_response_rtt_ratio"), VoipOptions.convertAttributeToFloat(paramak, "vsce_abs_latency_top_end_threshold"), VoipOptions.convertAttributeToInteger(paramak, "vsce_high_rtt_threshold"), VoipOptions.convertAttributeToFloat(paramak, "vsce_fec_pkt_loss_threshold"), VoipOptions.convertAttributeToFloat(paramak, "vsce_fec_pkt_loss_ratio"), VoipOptions.convertAttributeToInteger(paramak, "vsce_initial_cautious_period"), VoipOptions.convertAttributeToInteger(paramak, "bitrate_hysteresis"), VoipOptions.convertAttributeToInteger(paramak, "rtt_hysteresis"), VoipOptions.convertAttributeToInteger(paramak, "pkt_loss_hysteresis"), VoipOptions.convertAttributeToInteger(paramak, "min_decrease_factor_on_congestion"), VoipOptions.convertAttributeToInteger(paramak, "max_decrease_factor_on_congestion"), VoipOptions.convertAttributeToInteger(paramak, "initial_rtt_congestion_threshold"), VoipOptions.convertAttributeToInteger(paramak, "rtt_congestion_step"), VoipOptions.convertAttributeToInteger(paramak, "rtt_congestion_step_previous"), VoipOptions.convertAttributeToInteger(paramak, "rtt_congestion_step_ema"), VoipOptions.convertAttributeToInteger(paramak, "stop_video_encoding_rtt_threshold"), VoipOptions.convertAttributeToInteger(paramak, "double_rtt_congestion_threshold"), VoipOptions.convertAttributeToInteger(paramak, "no_rtcp_received_threshold"), VoipOptions.convertAttributeToInteger(paramak, "no_data_received_threshold"), VoipOptions.convertAttributeToInteger(paramak, "min_packets_per_frame"), VoipOptions.convertAttributeToBoolean(paramak.b("equalize_packet_sizes")), VoipOptions.convertAttributeToInteger(paramak, "min_fragmentation_size"), VoipOptions.convertAttributeToInteger(paramak, "constraint_audio_bitrate_threshold"), VoipOptions.convertAttributeToInteger(paramak, "nack_rtt_interactive_threshold"), VoipOptions.convertAttributeToInteger(paramak, "nack_rtt_ultra_low_threshold"), VoipOptions.convertAttributeToBoolean(paramak.b("nack_only_after_keyframe")));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("VideoRateControl{");
      if (this.stop != null)
      {
        str = "stop=" + this.stop;
        localStringBuilder = localStringBuilder.append(str);
        if (this.codecType == null) {
          break label2746;
        }
        str = "codecType=" + this.codecType;
        label73:
        localStringBuilder = localStringBuilder.append(str);
        if (this.codecSubType == null) {
          break label2753;
        }
        str = ", codecSubType=" + this.codecSubType;
        label107:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minPacketLossPct == null) {
          break label2760;
        }
        str = ", minPacketLossPct=" + this.minPacketLossPct;
        label141:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxPacketLossPct == null) {
          break label2767;
        }
        str = ", maxPacketLossPct=" + this.maxPacketLossPct;
        label175:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minTargetBitrate == null) {
          break label2774;
        }
        str = ", minTargetBitrate=" + this.minTargetBitrate;
        label209:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxTargetBitrate == null) {
          break label2781;
        }
        str = ", maxTargetBitrate=" + this.maxTargetBitrate;
        label243:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minBwe == null) {
          break label2788;
        }
        str = ", minBwe=" + this.minBwe;
        label277:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxBwe == null) {
          break label2795;
        }
        str = ", maxBwe=" + this.maxBwe;
        label311:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minRtt == null) {
          break label2802;
        }
        str = ", minRtt=" + this.minRtt;
        label345:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxRtt == null) {
          break label2809;
        }
        str = ", maxRtt=" + this.maxRtt;
        label379:
        localStringBuilder = localStringBuilder.append(str);
        if (this.netMedium == null) {
          break label2816;
        }
        str = ", netMedium=" + this.netMedium;
        label413:
        localStringBuilder = localStringBuilder.append(str);
        if (this.packetLossMode == null) {
          break label2823;
        }
        str = "packetLossMode=" + this.packetLossMode;
        label447:
        localStringBuilder = localStringBuilder.append(str);
        if (this.senderLossLow == null) {
          break label2830;
        }
        str = "senderLossLow=" + this.senderLossLow;
        label481:
        localStringBuilder = localStringBuilder.append(str);
        if (this.senderLossHigh == null) {
          break label2837;
        }
        str = ", senderLossHigh=" + this.senderLossHigh;
        label515:
        localStringBuilder = localStringBuilder.append(str);
        if (this.senderIncRatio == null) {
          break label2844;
        }
        str = ", senderIncRatio=" + this.senderIncRatio;
        label549:
        localStringBuilder = localStringBuilder.append(str);
        if (this.senderDecRatio == null) {
          break label2851;
        }
        str = ", senderDecRatio=" + this.senderDecRatio;
        label583:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxKeyFrameModeBitrate == null) {
          break label2858;
        }
        str = ", maxKeyFrameModeBitrate=" + this.maxKeyFrameModeBitrate;
        label617:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rcPolicy == null) {
          break label2865;
        }
        str = ", rcPolicy=" + this.rcPolicy;
        label651:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxCaptureWidth == null) {
          break label2872;
        }
        str = ", maxCaptureWidth=" + this.maxCaptureWidth;
        label685:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxEncodeWidth == null) {
          break label2879;
        }
        str = ", maxEncodeWidth=" + this.maxEncodeWidth;
        label719:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxFps == null) {
          break label2886;
        }
        str = ", maxFps=" + this.maxFps;
        label753:
        localStringBuilder = localStringBuilder.append(str);
        if (this.keyFrameInterval == null) {
          break label2893;
        }
        str = ", keyFrameInterval=" + this.keyFrameInterval;
        label787:
        localStringBuilder = localStringBuilder.append(str);
        if (this.lowDataUsageBitrate == null) {
          break label2900;
        }
        str = ", lowDataUsageBitrate=" + this.lowDataUsageBitrate;
        label821:
        localStringBuilder = localStringBuilder.append(str);
        if (this.cellularBitrate == null) {
          break label2907;
        }
        str = ", cellularBitrate=" + this.cellularBitrate;
        label855:
        localStringBuilder = localStringBuilder.append(str);
        if (this.encoderFormatChangeWaitMs == null) {
          break label2914;
        }
        str = ", encoderFormatChangeWaitMs=" + this.encoderFormatChangeWaitMs;
        label889:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minFecRatio == null) {
          break label2921;
        }
        str = ", minFecRatio=" + this.minFecRatio;
        label923:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxFecRatio == null) {
          break label2928;
        }
        str = ", maxFecRatio=" + this.maxFecRatio;
        label957:
        localStringBuilder = localStringBuilder.append(str);
        if (this.fecToPacketLossTimes10 == null) {
          break label2935;
        }
        str = ", fecToPacketLossTimes10=" + this.fecToPacketLossTimes10;
        label991:
        localStringBuilder = localStringBuilder.append(str);
        if (this.fecForKeyFrame == null) {
          break label2942;
        }
        str = ", fecForKeyFrame=" + this.fecForKeyFrame;
        label1025:
        localStringBuilder = localStringBuilder.append(str);
        if (this.enableFrameDropper == null) {
          break label2949;
        }
        str = ", enableFrameDropper=" + this.enableFrameDropper;
        label1059:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minSenderEstimateOnDrop == null) {
          break label2956;
        }
        str = ", minSenderEstimateOnDrop=" + this.minSenderEstimateOnDrop;
        label1093:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minSenderEstimateOnTarget == null) {
          break label2963;
        }
        str = ", minSenderEstimateOnTarget=" + this.minSenderEstimateOnTarget;
        label1127:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8BitrateMultiplier == null) {
          break label2970;
        }
        str = ", vp8BitrateMultiplier=" + this.vp8BitrateMultiplier;
        label1161:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8DropFrameThreshold == null) {
          break label2977;
        }
        str = ", vp8DropFrameThreshold=" + this.vp8DropFrameThreshold;
        label1195:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8MinQp == null) {
          break label2984;
        }
        str = ", vp8MinQp=" + this.vp8MinQp;
        label1229:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8MaxQp == null) {
          break label2991;
        }
        str = ", vp8MaxQp=" + this.vp8MaxQp;
        label1263:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8ErrorResilient == null) {
          break label2998;
        }
        str = ", vp8ErrorResilient=" + this.vp8ErrorResilient;
        label1297:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8NoiseSensitivity == null) {
          break label3005;
        }
        str = ", vp8NoiseSensitivity=" + this.vp8NoiseSensitivity;
        label1331:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8StaticThreshold == null) {
          break label3012;
        }
        str = ", vp8StaticThreshold=" + this.vp8StaticThreshold;
        label1365:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8TemporalMode == null) {
          break label3019;
        }
        str = ", vp8TemporalMode=" + this.vp8TemporalMode;
        label1399:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vp8EncMaxLatency == null) {
          break label3026;
        }
        str = ", vp8EncMaxLatency=" + this.vp8EncMaxLatency;
        label1433:
        localStringBuilder = localStringBuilder.append(str);
        if (this.monochromeModeRatio == null) {
          break label3033;
        }
        str = ", monochromeModeRatio=" + this.monochromeModeRatio;
        label1467:
        localStringBuilder = localStringBuilder.append(str);
        if (this.senderSideRcPolicy == null) {
          break label3040;
        }
        str = ", senderSideRcPolicy=" + this.senderSideRcPolicy;
        label1501:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initBitrate == null) {
          break label3047;
        }
        str = ", initBitrate=" + this.initBitrate;
        label1535:
        localStringBuilder = localStringBuilder.append(str);
        if (this.packetLossThresholdInPackets == null) {
          break label3054;
        }
        str = ", packetLossThresholdInPackets=" + this.packetLossThresholdInPackets;
        label1569:
        localStringBuilder = localStringBuilder.append(str);
        if (this.packetLossThresholdInMilliseconds == null) {
          break label3061;
        }
        str = ", packetLossThresholdInMilliseconds=" + this.packetLossThresholdInMilliseconds;
        label1603:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceEnabled == null) {
          break label3068;
        }
        str = ", vsceEnabled=" + this.vsceEnabled;
        label1637:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceEmaHigherFreqWeight == null) {
          break label3075;
        }
        str = ", vsceEmaHigherFreqWeight=" + this.vsceEmaHigherFreqWeight;
        label1671:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceEmaLowerFreqWeight == null) {
          break label3082;
        }
        str = ", vsceEmaLowerFreqWeight=" + this.vsceEmaLowerFreqWeight;
        label1705:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceEmaCrossMargin == null) {
          break label3089;
        }
        str = ", vsceEmaCrossMargin=" + this.vsceEmaCrossMargin;
        label1739:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceEmaPktLossSizeWeight == null) {
          break label3096;
        }
        str = ", vsceEmaPktLossSizeWeight=" + this.vsceEmaPktLossSizeWeight;
        label1773:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceBurstPktLossThreshold == null) {
          break label3103;
        }
        str = ", vsceBurstPktLossThreshold=" + this.vsceBurstPktLossThreshold;
        label1807:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceAlternateLatencyWindowSize == null) {
          break label3110;
        }
        str = ", vsceAlternateLatencyWindowSize=" + this.vsceAlternateLatencyWindowSize;
        label1841:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceDelayResponseRttRatio == null) {
          break label3117;
        }
        str = ", vsceDelayResponseRttRatio=" + this.vsceDelayResponseRttRatio;
        label1875:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceAbsLatencyTopEndThreshold == null) {
          break label3124;
        }
        str = ", vsceAbsLatencyTopEndThreshold=" + this.vsceAbsLatencyTopEndThreshold;
        label1909:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceHighRttThreshold == null) {
          break label3131;
        }
        str = ", vsceHighRttThreshold=" + this.vsceHighRttThreshold;
        label1943:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceFecPktLossThreshold == null) {
          break label3138;
        }
        str = ", vsceFecPktLossThreshold=" + this.vsceFecPktLossThreshold;
        label1977:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceFecPktLossRatio == null) {
          break label3145;
        }
        str = ", vsceFecPktLossRatio=" + this.vsceFecPktLossRatio;
        label2011:
        localStringBuilder = localStringBuilder.append(str);
        if (this.vsceInitialCautiousPeriod == null) {
          break label3152;
        }
        str = ", vsceInitialCautiousPeriod=" + this.vsceInitialCautiousPeriod;
        label2045:
        localStringBuilder = localStringBuilder.append(str);
        if (this.bitrateHysteresis == null) {
          break label3159;
        }
        str = ", bitrateHysteresis=" + this.bitrateHysteresis;
        label2079:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rttHysteresis == null) {
          break label3166;
        }
        str = ", rttHysteresis=" + this.rttHysteresis;
        label2113:
        localStringBuilder = localStringBuilder.append(str);
        if (this.pktLossHysteresis == null) {
          break label3173;
        }
        str = ", pktLossHysteresis=" + this.pktLossHysteresis;
        label2147:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minDecreaseFactorOnCongestion == null) {
          break label3180;
        }
        str = ", minDecreaseFactorOnCongestion=" + this.minDecreaseFactorOnCongestion;
        label2181:
        localStringBuilder = localStringBuilder.append(str);
        if (this.maxDecreaseFactorOnCongestion == null) {
          break label3187;
        }
        str = ", maxDecreaseFactorOnCongestion=" + this.maxDecreaseFactorOnCongestion;
        label2215:
        localStringBuilder = localStringBuilder.append(str);
        if (this.initialRttCongestionThreshold == null) {
          break label3194;
        }
        str = ", initialRttCongestionThreshold=" + this.initialRttCongestionThreshold;
        label2249:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rttCongestionStepHighest == null) {
          break label3201;
        }
        str = ", rttCongestionStepHighest=" + this.rttCongestionStepHighest;
        label2283:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rttCongestionStepPrevious == null) {
          break label3208;
        }
        str = ", rttCongestionStepPrevious=" + this.rttCongestionStepPrevious;
        label2317:
        localStringBuilder = localStringBuilder.append(str);
        if (this.rttCongestionStepEMA == null) {
          break label3215;
        }
        str = ", rttCongestionStepEMA=" + this.rttCongestionStepEMA;
        label2351:
        localStringBuilder = localStringBuilder.append(str);
        if (this.stopVideoEncodingRttThreshold == null) {
          break label3222;
        }
        str = ", stopVideoEncodingRttThreshold=" + this.stopVideoEncodingRttThreshold;
        label2385:
        localStringBuilder = localStringBuilder.append(str);
        if (this.doubleRttCongestionThreshold == null) {
          break label3229;
        }
        str = ", doubleRttCongestionThreshold=" + this.doubleRttCongestionThreshold;
        label2419:
        localStringBuilder = localStringBuilder.append(str);
        if (this.noRtcpReceivedThreshold == null) {
          break label3236;
        }
        str = ", noRtcpReceivedThreshold=" + this.noRtcpReceivedThreshold;
        label2453:
        localStringBuilder = localStringBuilder.append(str);
        if (this.noDataReceivedThreshold == null) {
          break label3243;
        }
        str = ", noDataReceivedThreshold=" + this.noDataReceivedThreshold;
        label2487:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minPacketsPerFrame == null) {
          break label3250;
        }
        str = ", minPacketsPerFrame=" + this.minPacketsPerFrame;
        label2521:
        localStringBuilder = localStringBuilder.append(str);
        if (this.equalizePacketSizes == null) {
          break label3257;
        }
        str = ", equalizePacketSizes=" + this.equalizePacketSizes;
        label2555:
        localStringBuilder = localStringBuilder.append(str);
        if (this.minFragmentationSize == null) {
          break label3264;
        }
        str = ", minFragmentationSize=" + this.minFragmentationSize;
        label2589:
        localStringBuilder = localStringBuilder.append(str);
        if (this.constraintAudioBitrateThreshold == null) {
          break label3271;
        }
        str = ", constraintAudioBitrateThreshold=" + this.constraintAudioBitrateThreshold;
        label2623:
        localStringBuilder = localStringBuilder.append(str);
        if (this.nackRttInteractiveThreshold == null) {
          break label3278;
        }
        str = ", nackRttInteractiveThreshold=" + this.nackRttInteractiveThreshold;
        label2657:
        localStringBuilder = localStringBuilder.append(str);
        if (this.nackRttUltraLowThreshold == null) {
          break label3285;
        }
        str = ", nackRttUltraLowThreshold=" + this.nackRttUltraLowThreshold;
        label2691:
        localStringBuilder = localStringBuilder.append(str);
        if (this.nackOnlyAfterKeyframe == null) {
          break label3292;
        }
      }
      label2746:
      label2753:
      label2760:
      label2767:
      label2774:
      label2781:
      label2788:
      label2795:
      label2802:
      label2809:
      label2816:
      label2823:
      label2830:
      label2837:
      label2844:
      label2851:
      label2858:
      label2865:
      label2872:
      label2879:
      label2886:
      label2893:
      label2900:
      label2907:
      label2914:
      label2921:
      label2928:
      label2935:
      label2942:
      label2949:
      label2956:
      label2963:
      label2970:
      label2977:
      label2984:
      label2991:
      label2998:
      label3005:
      label3012:
      label3019:
      label3026:
      label3033:
      label3040:
      label3047:
      label3054:
      label3061:
      label3068:
      label3075:
      label3082:
      label3089:
      label3096:
      label3103:
      label3110:
      label3117:
      label3124:
      label3131:
      label3138:
      label3145:
      label3152:
      label3159:
      label3166:
      label3173:
      label3180:
      label3187:
      label3194:
      label3201:
      label3208:
      label3215:
      label3222:
      label3229:
      label3236:
      label3243:
      label3250:
      label3257:
      label3264:
      label3271:
      label3278:
      label3285:
      label3292:
      for (String str = ", nackOnlyAfterKeyframe=" + this.nackOnlyAfterKeyframe;; str = "")
      {
        return str + '}';
        str = "";
        break;
        str = "";
        break label73;
        str = "";
        break label107;
        str = "";
        break label141;
        str = "";
        break label175;
        str = "";
        break label209;
        str = "";
        break label243;
        str = "";
        break label277;
        str = "";
        break label311;
        str = "";
        break label345;
        str = "";
        break label379;
        str = "";
        break label413;
        str = "";
        break label447;
        str = "";
        break label481;
        str = "";
        break label515;
        str = "";
        break label549;
        str = "";
        break label583;
        str = "";
        break label617;
        str = "";
        break label651;
        str = "";
        break label685;
        str = "";
        break label719;
        str = "";
        break label753;
        str = "";
        break label787;
        str = "";
        break label821;
        str = "";
        break label855;
        str = "";
        break label889;
        str = "";
        break label923;
        str = "";
        break label957;
        str = "";
        break label991;
        str = "";
        break label1025;
        str = "";
        break label1059;
        str = "";
        break label1093;
        str = "";
        break label1127;
        str = "";
        break label1161;
        str = "";
        break label1195;
        str = "";
        break label1229;
        str = "";
        break label1263;
        str = "";
        break label1297;
        str = "";
        break label1331;
        str = "";
        break label1365;
        str = "";
        break label1399;
        str = "";
        break label1433;
        str = "";
        break label1467;
        str = "";
        break label1501;
        str = "";
        break label1535;
        str = "";
        break label1569;
        str = "";
        break label1603;
        str = "";
        break label1637;
        str = "";
        break label1671;
        str = "";
        break label1705;
        str = "";
        break label1739;
        str = "";
        break label1773;
        str = "";
        break label1807;
        str = "";
        break label1841;
        str = "";
        break label1875;
        str = "";
        break label1909;
        str = "";
        break label1943;
        str = "";
        break label1977;
        str = "";
        break label2011;
        str = "";
        break label2045;
        str = "";
        break label2079;
        str = "";
        break label2113;
        str = "";
        break label2147;
        str = "";
        break label2181;
        str = "";
        break label2215;
        str = "";
        break label2249;
        str = "";
        break label2283;
        str = "";
        break label2317;
        str = "";
        break label2351;
        str = "";
        break label2385;
        str = "";
        break label2419;
        str = "";
        break label2453;
        str = "";
        break label2487;
        str = "";
        break label2521;
        str = "";
        break label2555;
        str = "";
        break label2589;
        str = "";
        break label2623;
        str = "";
        break label2657;
        str = "";
        break label2691;
      }
    }
  }
  
  @Keep
  public static final class XorCipher
  {
    public final Boolean onRtp;
    public final Integer p1;
    public final Integer p2;
    
    public XorCipher(Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean)
    {
      this.p1 = paramInteger1;
      this.p2 = paramInteger2;
      this.onRtp = paramBoolean;
    }
    
    public static XorCipher fromProtocolTreeNode(ak paramak)
    {
      if (paramak == null) {
        return null;
      }
      return new XorCipher(VoipOptions.convertAttributeToInteger(paramak.a("p1", null), "p1"), VoipOptions.convertAttributeToInteger(paramak.a("p2", null), "p2"), VoipOptions.convertAttributeToBoolean(paramak.a("on_rtp", null)));
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("XorCipher{");
      if (this.p1 == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.p2 != null) {
          break label89;
        }
        str = "";
        label36:
        localStringBuilder = localStringBuilder.append(str);
        if (this.onRtp != null) {
          break label112;
        }
      }
      label89:
      label112:
      for (String str = "";; str = "on_rtp=" + this.onRtp)
      {
        return str + "}";
        str = "p1=" + this.p1;
        break;
        str = "p2=" + this.p2;
        break label36;
      }
    }
  }
  
  public static final class a
  {
    public final Boolean a;
    public final Boolean b;
    
    public a(Boolean paramBoolean1, Boolean paramBoolean2)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("Client{");
      if (this.a == null)
      {
        str = "";
        localStringBuilder = localStringBuilder.append(str);
        if (this.b != null) {
          break label73;
        }
      }
      label73:
      for (String str = "";; str = ", calleeBadASN=" + this.b)
      {
        return str + "}";
        str = "callerBadASN=" + this.a;
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/VoipOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */