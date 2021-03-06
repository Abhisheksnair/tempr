package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class WamCall
  extends e
{
  @Deprecated
  public String abtestBucket;
  public Long androidApiLevel = a.d;
  public Long audioGetFrameUnderflowPs;
  public Long audioPutFrameOverflowPs;
  public Double avAvgDelta;
  public Double avMaxDelta;
  public Double avgClockCbT;
  public Double avgDecodeT;
  public Double avgEncodeT;
  public Double avgPlayCbT;
  public Double avgRecordCbT;
  public Double avgRecordGetFrameT;
  public Double avgTargetBitrate;
  public Boolean builtinAecAvailable;
  public Boolean builtinAecEnabled;
  public String builtinAecImplementor;
  public String builtinAecUuid;
  public Boolean builtinAgcAvailable;
  public Boolean builtinNsAvailable;
  public Double callAcceptFuncT;
  public Integer callAecMode;
  public Long callAecOffset;
  public Long callAecTailLength;
  public Integer callAgcMode;
  public Boolean callAndrGcmFgEnabled;
  public Long callAndroidAudioMode;
  public Long callAndroidRecordAudioPreset;
  public Long callAndroidRecordAudioSource;
  public Double callAppTrafficTxPct;
  public Integer callAudioEngineType;
  public Double callAudioRestartCount;
  public Double callAudioRestartReason;
  public Double callAvgRottRx;
  public Double callAvgRottTx;
  public Double callAvgRtt;
  public Double callBatteryChangePct;
  @Deprecated
  public Double callBatteryDropPct;
  public Long callCalculatedEcOffset;
  public Long callCalculatedEcOffsetStddev;
  public Double callEcRestartCount;
  public Double callEchoEnergy;
  public Long callEchoLikelihood;
  public Double callEchoLikelihoodBeforeEc;
  public Double callEndFuncT;
  public Boolean callEndReconnecting;
  public Boolean callEndedInterrupted;
  public Integer callFromUi;
  public Double callHistEchoLikelihood;
  public Double callInitialRtt;
  public Boolean callInterrupted;
  public Double callLastRtt;
  public Double callMaxRtt;
  public Double callMinRtt;
  public Integer callNetwork;
  public Long callNetworkSubtype;
  public Integer callNsMode;
  public Double callOfferAckTimout;
  public Double callOfferDelayT;
  public Double callOfferElapsedT;
  public Double callOfferReceiptDelay;
  public Boolean callP2pDisabled;
  public String callPeerAppVersion;
  public String callPeerIpStr;
  public Long callPeerIpv4;
  public String callPeerPlatform;
  public Long callPlaybackBufferSize;
  public Boolean callPlaybackCallbackStopped;
  public Double callPlaybackFramesPs;
  public Double callPlaybackSilenceRatio;
  public Integer callRadioType;
  public Double callRecentPlaybackFramesPs;
  public Double callRecentRecordFramesPs;
  public Long callRecordBufferSize;
  public Boolean callRecordCallbackStopped;
  public Long callRecordFramesPs;
  public Double callRecordMaxEnergyRatio;
  public Long callRecordSilenceRatio;
  public Double callRejectFuncT;
  public Integer callRelayBindStatus;
  public Double callRelayCreateT;
  public String callRelayServer;
  public Integer callResult;
  public Double callRingingT;
  public Double callRxAvgBitrate;
  public Double callRxAvgBwe;
  public Double callRxAvgJitter;
  public Double callRxAvgLossPeriod;
  public Double callRxMaxJitter;
  public Double callRxMaxLossPeriod;
  public Double callRxMinJitter;
  public Double callRxMinLossPeriod;
  public Double callRxPktLossPct;
  public Double callRxStoppedT;
  public Long callSamplingRate;
  public String callSelfIpStr;
  public Long callSelfIpv4;
  public Long callServerNackErrorCode;
  public Integer callSetupErrorType;
  public Double callSetupT;
  public Integer callSide;
  public Double callSoundPortFuncT;
  public Double callStartFuncT;
  public Long callSwAecMode;
  public Integer callSwAecType;
  public Double callT;
  public Integer callTermReason;
  public String callTestBucket;
  public Long callTonesDetectedInRecord;
  public Long callTonesDetectedInRingback;
  public Long callTransitionCount;
  public Integer callTransport;
  @Deprecated
  public Integer callTransportIpVersion;
  public Long callTransportP2pToRelayFallbackCount;
  public Long callTransportRelayToRelayFallbackCount;
  public Double callTxAvgBitrate;
  public Double callTxAvgBwe;
  public Double callTxAvgJitter;
  public Double callTxAvgLossPeriod;
  public Double callTxMaxJitter;
  public Double callTxMaxLossPeriod;
  public Double callTxMinJitter;
  public Double callTxMinLossPeriod;
  public Double callTxPktErrorPct;
  public Double callTxPktLossPct;
  public Long callUserRate;
  public Integer callWakeupSource;
  public Boolean callerHungupBeforeConnected;
  public Integer cameraStartMode;
  public String deviceBoard;
  public String deviceHardware;
  public Long encoderCompStepdowns;
  public Integer endCallAfterConfirmation;
  public Double initialEstimatedTxBitrate;
  public Boolean isIpv6Capable;
  public Boolean isUpnpExternalIpPrivate;
  public Boolean isUpnpExternalIpTheSameAsReflexiveIp;
  public Double jbAvgDelay;
  public Double jbDiscards;
  public Double jbEmpties;
  public Double jbGets;
  public Double jbLastDelay;
  public Double jbLost;
  public Double jbMaxDelay;
  public Double jbMinDelay;
  public Double jbPuts;
  @Deprecated
  public Integer locRelation;
  public Boolean longConnect;
  public Double lowDataUsageBitrate;
  public Long micAvgPower;
  public Long micMaxPower;
  public Long micMinPower;
  public String nativeSamplesPerFrame;
  public String nativeSamplingRate;
  public Long numberOfProcessors;
  public Integer peerCallNetwork;
  public Integer peerCallResult;
  public Long peerUserId;
  public Long peerVideoHeight;
  public Long peerVideoWidth;
  public Integer peerXmppStatus;
  public Double pingsSent;
  public Double pongsReceived;
  public Integer presentEndCallConfirmation;
  public Double previousCallInterval;
  public Boolean previousCallVideoEnabled;
  public Boolean previousCallWithSamePeer;
  public Double pushToCallOfferDelay;
  public Double rcMaxrtt;
  public Double rcMinrtt;
  public Long recordCircularBufferFrameCount;
  public Double reflectivePortsDiff;
  @Deprecated
  public Double renderFreezeT;
  public Double rxTotalBitrate;
  public Double rxTotalBytes;
  public Boolean smallCallButton;
  public Long speakerAvgPower;
  public Long speakerMaxPower;
  public Long speakerMinPower;
  public Long symmetricNatPortGap;
  @Deprecated
  public Long symmetricNatPortMax;
  @Deprecated
  public Long symmetricNatPortMin;
  public Double trafficShaperAvgQueueMs;
  public Long trafficShaperMaxDelayViolations;
  public Long trafficShaperMinDelayViolations;
  public Long trafficShaperOverflowCount;
  public Long trafficShaperQueueEmptyCount;
  public Long trafficShaperQueuedPacketCount;
  public Double txTotalBitrate;
  public Double txTotalBytes;
  public Integer upnpAddResultCode;
  @Deprecated
  public Boolean upnpEnabled;
  @Deprecated
  public String upnpExternalIpAddress;
  public Integer upnpRemoveResultCode;
  public String userDescription;
  public Long userProblems;
  public Long userRating;
  public Double videoActiveTime;
  public Double videoAvgSenderBwe;
  public Double videoAvgTargetBitrate;
  @Deprecated
  public Long videoCameraCallbacks;
  public Long videoCaptureAvgFps;
  public Double videoCaptureConverterTs;
  public Long videoCaptureHeight;
  public Long videoCaptureWidth;
  public Long videoCodecType;
  public Long videoDecAvgBitrate;
  public Double videoDecAvgFps;
  public Long videoDecColorId;
  public Long videoDecErrorFrames;
  public Long videoDecInputFrames;
  public Long videoDecKeyframes;
  public Double videoDecLatency;
  public Long videoDecLostPackets;
  public Long videoDecName;
  public Long videoDecOutputFrames;
  public Long videoDecRestart;
  public Long videoDecSkipPackets;
  public Long videoDecodePausedCount;
  public Long videoDowngradeCount;
  public Boolean videoEnabled;
  public Boolean videoEnabledAtCallStart;
  public Long videoEncAvgBitrate;
  public Double videoEncAvgFps;
  public Double videoEncAvgTargetFps;
  public Long videoEncColorId;
  public Long videoEncDiscardFrame;
  public Long videoEncDropFrames;
  public Long videoEncErrorFrames;
  public Long videoEncInputFrames;
  public Long videoEncKeyframes;
  public Double videoEncLatency;
  public Long videoEncName;
  public Long videoEncOutputFrames;
  public Long videoEncRestart;
  public Long videoFecRecovered;
  public Long videoHeight;
  public Double videoLastSenderBwe;
  public Integer videoPeerState;
  public Long videoRenderAvgFps;
  public Double videoRenderConverterTs;
  public Double videoRenderDelayT;
  public Double videoRenderFreezeT;
  public Double videoRxBitrate;
  public Boolean videoRxBweHitTxBwe;
  public Double videoRxFecBitrate;
  public Long videoRxFecFrames;
  public Long videoRxPackets;
  public Double videoRxPktErrorPct;
  public Double videoRxPktLossPct;
  public Long videoRxRtcpNack;
  public Long videoRxRtcpPli;
  public Double videoRxTotalBytes;
  public Integer videoSelfState;
  public Double videoTxBitrate;
  public Double videoTxFecBitrate;
  public Long videoTxFecFrames;
  public Long videoTxPackets;
  public Double videoTxPktErrorPct;
  public Double videoTxPktLossPct;
  public Long videoTxResendPackets;
  public Long videoTxRtcpNack;
  public Long videoTxRtcpPli;
  public Double videoTxTotalBytes;
  public Long videoUpgradeCount;
  public Long videoUpgradeRequestCount;
  public Long videoWidth;
  public Long wifiRssiAtCallStart;
  public Long wpNotifyCallFailed;
  public Boolean wpSoftwareEcMatches;
  public Integer xmppStatus;
  public Integer xorCipher;
  
  public WamCall()
  {
    super(462);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramd != null)
    {
      if (!a.a(this.androidApiLevel, a.d)) {
        break label2769;
      }
      paramd.a(617);
    }
    for (;;)
    {
      if (paramg != null)
      {
        paramg.a(1, this.callSide);
        paramg.a(2, this.callFromUi);
        paramg.a(3, this.xmppStatus);
        paramg.a(4, this.peerXmppStatus);
        paramg.a(5, this.callPeerPlatform);
        paramg.a(6, this.smallCallButton);
        paramg.a(7, this.callSelfIpv4);
        paramg.a(8, this.callPeerIpv4);
        paramg.a(9, this.callSelfIpStr);
        paramg.a(10, this.callPeerIpStr);
        paramg.a(15, this.callPeerAppVersion);
        paramg.a(16, this.callRelayBindStatus);
        paramg.a(17, this.callRelayServer);
        paramg.a(18, this.callP2pDisabled);
        paramg.a(19, this.callTestBucket);
        paramg.a(20, this.callUserRate);
        paramg.a(21, this.longConnect);
        paramg.a(22, this.callInterrupted);
        paramg.a(23, this.callEndedInterrupted);
        paramg.a(24, this.callRecordCallbackStopped);
        paramg.a(25, this.callPlaybackCallbackStopped);
        paramg.a(26, this.callRecordSilenceRatio);
        paramg.a(27, this.numberOfProcessors);
        paramg.a(28, this.callRecordFramesPs);
        paramg.a(29, this.callRecentRecordFramesPs);
        paramg.a(30, this.callSamplingRate);
        paramg.a(31, this.nativeSamplingRate);
        paramg.a(32, this.nativeSamplesPerFrame);
        paramg.a(229, this.deviceHardware);
        paramg.a(230, this.deviceBoard);
        paramg.a(33, this.builtinAecAvailable);
        paramg.a(34, this.builtinAgcAvailable);
        paramg.a(35, this.builtinNsAvailable);
        paramg.a(36, this.builtinAecImplementor);
        paramg.a(37, this.builtinAecUuid);
        paramg.a(38, this.builtinAecEnabled);
        paramg.a(39, this.callAecMode);
        paramg.a(40, this.callSwAecType);
        paramg.a(41, this.callSwAecMode);
        paramg.a(42, this.callAecOffset);
        paramg.a(43, this.callAecTailLength);
        paramg.a(44, this.callEchoLikelihood);
        paramg.a(45, this.callHistEchoLikelihood);
        paramg.a(46, this.callEchoEnergy);
        paramg.a(47, this.callEchoLikelihoodBeforeEc);
        paramg.a(48, this.callTonesDetectedInRingback);
        paramg.a(49, this.callTonesDetectedInRecord);
        paramg.a(50, this.callCalculatedEcOffset);
        paramg.a(51, this.callCalculatedEcOffsetStddev);
        paramg.a(52, this.callAgcMode);
        paramg.a(53, this.callNsMode);
        paramg.a(54, this.callAudioEngineType);
        paramg.a(55, this.callAndroidAudioMode);
        paramg.a(56, this.callAndroidRecordAudioSource);
        paramg.a(57, this.callAndroidRecordAudioPreset);
        paramg.a(58, this.callRecordBufferSize);
        paramg.a(59, this.callPlaybackBufferSize);
        paramg.a(60, this.peerUserId);
        paramg.a(63, this.callResult);
        paramg.a(64, this.wpNotifyCallFailed);
        paramg.a(65, this.wpSoftwareEcMatches);
        paramg.a(66, this.peerCallResult);
        paramg.a(67, this.callerHungupBeforeConnected);
        paramg.a(68, this.callServerNackErrorCode);
        paramg.a(69, this.callTermReason);
        paramg.a(70, this.callEndReconnecting);
        paramg.a(260, this.isUpnpExternalIpPrivate);
        paramg.a(261, this.isUpnpExternalIpTheSameAsReflexiveIp);
        paramg.a(257, this.symmetricNatPortGap);
        paramg.a(246, this.upnpAddResultCode);
        paramg.a(247, this.upnpRemoveResultCode);
        paramg.a(263, this.wifiRssiAtCallStart);
        paramg.a(71, this.callSetupErrorType);
        paramg.a(72, this.callTransport);
        paramg.a(76, this.callNetwork);
        paramg.a(264, this.peerCallNetwork);
        paramg.a(269, this.xorCipher);
        paramg.a(77, this.callNetworkSubtype);
        paramg.a(78, this.callTransitionCount);
        paramg.a(79, this.callTransportRelayToRelayFallbackCount);
        paramg.a(80, this.callTransportP2pToRelayFallbackCount);
        paramg.a(81, this.encoderCompStepdowns);
        paramg.a(82, this.audioPutFrameOverflowPs);
        paramg.a(83, this.audioGetFrameUnderflowPs);
        paramg.a(84, this.recordCircularBufferFrameCount);
        paramg.a(86, this.userRating);
        paramg.a(87, this.userDescription);
        paramg.a(88, this.userProblems);
        paramg.a(89, this.presentEndCallConfirmation);
        paramg.a(90, this.endCallAfterConfirmation);
        paramg.a(91, this.isIpv6Capable);
        paramg.a(92, this.callT);
        paramg.a(93, this.callPlaybackFramesPs);
        paramg.a(94, this.callRecentPlaybackFramesPs);
        paramg.a(95, this.callPlaybackSilenceRatio);
        paramg.a(96, this.callAudioRestartCount);
        paramg.a(97, this.callAudioRestartReason);
        paramg.a(98, this.callRecordMaxEnergyRatio);
        paramg.a(99, this.callEcRestartCount);
        paramg.a(100, this.callRxStoppedT);
        paramg.a(101, this.callSetupT);
        paramg.a(102, this.callOfferElapsedT);
        paramg.a(103, this.callRingingT);
        paramg.a(104, this.callRelayCreateT);
        paramg.a(105, this.callMinRtt);
        paramg.a(106, this.callMaxRtt);
        paramg.a(107, this.callAvgRtt);
        paramg.a(108, this.callLastRtt);
        paramg.a(109, this.callInitialRtt);
        paramg.a(110, this.callTxPktLossPct);
        paramg.a(111, this.callTxPktErrorPct);
        paramg.a(112, this.callTxAvgBitrate);
        paramg.a(113, this.callTxAvgBwe);
        paramg.a(114, this.callTxMinJitter);
        paramg.a(115, this.callTxMaxJitter);
        paramg.a(116, this.callTxAvgJitter);
        paramg.a(117, this.callTxMinLossPeriod);
        paramg.a(118, this.callTxMaxLossPeriod);
        paramg.a(119, this.callTxAvgLossPeriod);
        paramg.a(120, this.callRxPktLossPct);
        paramg.a(121, this.callRxAvgBitrate);
        paramg.a(122, this.callRxAvgBwe);
        paramg.a(123, this.callRxMinJitter);
        paramg.a(124, this.callRxMaxJitter);
        paramg.a(125, this.callRxAvgJitter);
        paramg.a(126, this.callRxMinLossPeriod);
        paramg.a(127, this.callRxMaxLossPeriod);
        paramg.a(128, this.callRxAvgLossPeriod);
        paramg.a(129, this.callStartFuncT);
        paramg.a(130, this.callEndFuncT);
        paramg.a(131, this.callRejectFuncT);
        paramg.a(132, this.callAcceptFuncT);
        paramg.a(133, this.callSoundPortFuncT);
        paramg.a(134, this.callOfferReceiptDelay);
        paramg.a(135, this.avgEncodeT);
        paramg.a(136, this.avgDecodeT);
        paramg.a(137, this.avgPlayCbT);
        paramg.a(138, this.avgRecordCbT);
        paramg.a(139, this.avgClockCbT);
        paramg.a(140, this.avgRecordGetFrameT);
        paramg.a(196, this.videoRenderDelayT);
        paramg.a(141, this.avgTargetBitrate);
        paramg.a(142, this.txTotalBytes);
        paramg.a(143, this.rxTotalBytes);
        paramg.a(144, this.txTotalBitrate);
        paramg.a(145, this.rxTotalBitrate);
        paramg.a(277, this.jbLost);
        paramg.a(146, this.jbAvgDelay);
        paramg.a(147, this.jbMinDelay);
        paramg.a(148, this.jbMaxDelay);
        paramg.a(149, this.jbLastDelay);
        paramg.a(150, this.jbDiscards);
        paramg.a(151, this.jbEmpties);
        paramg.a(152, this.jbGets);
        paramg.a(153, this.jbPuts);
        paramg.a(154, this.rcMinrtt);
        paramg.a(155, this.rcMaxrtt);
        paramg.a(248, this.speakerMinPower);
        paramg.a(249, this.speakerMaxPower);
        paramg.a(250, this.speakerAvgPower);
        paramg.a(251, this.micMinPower);
        paramg.a(252, this.micMaxPower);
        paramg.a(253, this.micAvgPower);
        paramg.a(156, this.callWakeupSource);
        paramg.a(157, this.lowDataUsageBitrate);
        paramg.a(158, this.pushToCallOfferDelay);
        paramg.a(159, this.callOfferAckTimout);
        paramg.a(160, this.pingsSent);
        paramg.a(161, this.pongsReceived);
        paramg.a(162, this.reflectivePortsDiff);
        paramg.a(195, this.callBatteryChangePct);
        paramg.a(163, this.videoEnabled);
        paramg.a(270, this.videoEnabledAtCallStart);
        paramg.a(236, this.videoCodecType);
        paramg.a(197, this.videoTxPackets);
        paramg.a(198, this.videoTxResendPackets);
        paramg.a(199, this.videoTxRtcpPli);
        paramg.a(200, this.videoTxRtcpNack);
        paramg.a(164, this.videoTxTotalBytes);
        paramg.a(165, this.videoTxBitrate);
        paramg.a(166, this.videoTxPktLossPct);
        paramg.a(167, this.videoTxPktErrorPct);
        paramg.a(201, this.videoRxPackets);
        paramg.a(202, this.videoRxRtcpPli);
        paramg.a(203, this.videoRxRtcpNack);
        paramg.a(168, this.videoRxTotalBytes);
        paramg.a(169, this.videoRxBitrate);
        paramg.a(170, this.videoRxPktLossPct);
        paramg.a(171, this.videoRxPktErrorPct);
        paramg.a(204, this.videoDecName);
        paramg.a(205, this.videoDecColorId);
        paramg.a(206, this.videoDecRestart);
        paramg.a(207, this.videoDecAvgFps);
        paramg.a(208, this.videoRenderAvgFps);
        paramg.a(225, this.videoRenderConverterTs);
        paramg.a(220, this.videoDecAvgBitrate);
        paramg.a(209, this.videoDecSkipPackets);
        paramg.a(210, this.videoDecLostPackets);
        paramg.a(172, this.videoDecInputFrames);
        paramg.a(173, this.videoDecOutputFrames);
        paramg.a(174, this.videoDecErrorFrames);
        paramg.a(175, this.videoDecKeyframes);
        paramg.a(222, this.videoCaptureAvgFps);
        paramg.a(226, this.videoCaptureConverterTs);
        paramg.a(223, this.videoDecLatency);
        paramg.a(224, this.videoEncLatency);
        paramg.a(212, this.videoEncName);
        paramg.a(213, this.videoEncColorId);
        paramg.a(214, this.videoEncRestart);
        paramg.a(215, this.videoEncAvgTargetFps);
        paramg.a(221, this.videoEncAvgBitrate);
        paramg.a(216, this.videoEncAvgFps);
        paramg.a(176, this.videoEncInputFrames);
        paramg.a(177, this.videoEncOutputFrames);
        paramg.a(178, this.videoEncErrorFrames);
        paramg.a(179, this.videoEncDropFrames);
        paramg.a(217, this.videoEncDiscardFrame);
        paramg.a(180, this.videoEncKeyframes);
        paramg.a(218, this.videoTxFecBitrate);
        paramg.a(181, this.videoTxFecFrames);
        paramg.a(219, this.videoRxFecBitrate);
        paramg.a(182, this.videoRxFecFrames);
        paramg.a(183, this.videoFecRecovered);
        paramg.a(184, this.videoAvgTargetBitrate);
        paramg.a(185, this.videoLastSenderBwe);
        paramg.a(186, this.videoAvgSenderBwe);
        paramg.a(187, this.videoRxBweHitTxBwe);
        paramg.a(227, this.videoCaptureWidth);
        paramg.a(228, this.videoCaptureHeight);
        paramg.a(188, this.videoWidth);
        paramg.a(189, this.videoHeight);
        paramg.a(190, this.peerVideoWidth);
        paramg.a(191, this.peerVideoHeight);
        paramg.a(192, this.avAvgDelta);
        paramg.a(193, this.avMaxDelta);
        paramg.a(231, this.callRadioType);
        paramg.a(232, this.videoDecodePausedCount);
        paramg.a(235, this.videoRenderFreezeT);
        paramg.a(233, this.cameraStartMode);
        paramg.a(237, this.trafficShaperOverflowCount);
        paramg.a(238, this.trafficShaperQueueEmptyCount);
        paramg.a(239, this.trafficShaperQueuedPacketCount);
        paramg.a(240, this.trafficShaperMaxDelayViolations);
        paramg.a(241, this.trafficShaperMinDelayViolations);
        paramg.a(242, this.trafficShaperAvgQueueMs);
        paramg.a(243, this.callOfferDelayT);
        paramg.a(244, this.initialEstimatedTxBitrate);
        paramg.a(258, this.callAvgRottTx);
        paramg.a(259, this.callAvgRottRx);
        paramg.a(262, this.callAppTrafficTxPct);
        paramg.a(265, this.previousCallVideoEnabled);
        paramg.a(267, this.previousCallWithSamePeer);
        paramg.a(266, this.previousCallInterval);
        paramg.a(268, this.callAndrGcmFgEnabled);
        paramg.a(276, this.videoActiveTime);
        paramg.a(271, this.videoUpgradeRequestCount);
        paramg.a(272, this.videoUpgradeCount);
        paramg.a(273, this.videoDowngradeCount);
        paramg.a(274, this.videoSelfState);
        paramg.a(275, this.videoPeerState);
      }
      return;
      label2769:
      paramd.a(617, this.androidApiLevel);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/WamCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */