package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.ae;
import com.google.protobuf.af;
import com.google.protobuf.ag;
import com.google.protobuf.ah;
import com.google.protobuf.aj;
import com.google.protobuf.an;
import com.google.protobuf.b.a;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.i.a;
import com.google.protobuf.i.d;
import com.google.protobuf.i.e;
import com.google.protobuf.i.g;
import com.google.protobuf.i.g.a;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.o;
import com.google.protobuf.o.a;
import com.google.protobuf.o.b;
import com.google.protobuf.o.f;
import com.google.protobuf.p.a;
import com.google.protobuf.q;
import com.google.protobuf.t;
import com.google.protobuf.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class E2E
{
  private static final i.a A;
  private static o.f B;
  private static final i.a C;
  private static o.f D;
  private static final i.a E;
  private static o.f F;
  private static final i.a G;
  private static o.f H;
  private static final i.a I;
  private static o.f J;
  private static final i.a K;
  private static o.f L;
  private static final i.a M;
  private static o.f N;
  private static final i.a O;
  private static o.f P;
  private static i.g Q;
  private static final i.a a;
  private static o.f b;
  private static final i.a c;
  private static o.f d;
  private static final i.a e;
  private static o.f f;
  private static final i.a g;
  private static o.f h;
  private static final i.a i;
  private static o.f j;
  private static final i.a k;
  private static o.f l;
  private static final i.a m;
  private static o.f n;
  private static final i.a o;
  private static o.f p;
  private static final i.a q;
  private static o.f r;
  private static final i.a s;
  private static o.f t;
  private static final i.a u;
  private static o.f v;
  private static final i.a w;
  private static o.f x;
  private static final i.a y;
  private static o.f z;
  
  static
  {
    i.g.a local1 = new i.g.a()
    {
      public final l a(i.g paramAnonymousg)
      {
        E2E.a(paramAnonymousg);
        return null;
      }
    };
    i.g localg = Protocol.a();
    i.g.a(new String[] { "\n\te2e.proto\022\bwhatsapp\032\016protocol.proto\"±&\n\007Message\022\024\n\fconversation\030\001 \001(\t\022W\n\037sender_key_distribution_message\030\002 \001(\0132..whatsapp.Message.SenderKeyDistributionMessage\0225\n\rimage_message\030\003 \001(\0132\036.whatsapp.Message.ImageMessage\0229\n\017contact_message\030\004 \001(\0132 .whatsapp.Message.ContactMessage\022;\n\020location_message\030\005 \001(\0132!.whatsapp.Message.LocationMessage\022D\n\025extended_text_message\030\006 \001(\0132%.whatsapp.Message.ExtendedTextMe", "ssage\022;\n\020document_message\030\007 \001(\0132!.whatsapp.Message.DocumentMessage\0225\n\raudio_message\030\b \001(\0132\036.whatsapp.Message.AudioMessage\0225\n\rvideo_message\030\t \001(\0132\036.whatsapp.Message.VideoMessage\022$\n\004call\030\n \001(\0132\026.whatsapp.Message.Call\022$\n\004chat\030\013 \001(\0132\026.whatsapp.Message.Chat\022;\n\020protocol_message\030\f \001(\0132!.whatsapp.Message.ProtocolMessage\022F\n\026contacts_array_message\030\r \001(\0132&.whatsapp.Message.ContactsArrayMessage\022L\n\031highly_stru", "ctured_message\030\016 \001(\0132).whatsapp.Message.HighlyStructuredMessage\022h\n0fast_ratchet_key_sender_key_distribution_message\030\017 \001(\0132..whatsapp.Message.SenderKeyDistributionMessage\022D\n\025live_location_message\030\022 \001(\0132%.whatsapp.Message.LiveLocationMessage\032a\n\034SenderKeyDistributionMessage\022\020\n\bgroup_id\030\001 \001(\t\022/\n'axolotl_sender_key_distribution_message\030\002 \001(\f\032ø\001\n\fImageMessage\022\013\n\003url\030\001 \001(\t\022\020\n\bmimetype\030\002 \001(\t\022\017\n\007caption\030\003 ", "\001(\t\022\023\n\013file_sha256\030\004 \001(\f\022\023\n\013file_length\030\005 \001(\004\022\016\n\006height\030\006 \001(\r\022\r\n\005width\030\007 \001(\r\022\021\n\tmedia_key\030\b \001(\f\022\027\n\017file_enc_sha256\030\t \001(\f\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\032b\n\016ContactMessage\022\024\n\fdisplay_name\030\001 \001(\t\022\r\n\005vcard\030\020 \001(\t\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\032·\001\n\017LocationMessage\022\030\n\020degrees_latitude\030\001 \001(\001\022\031\n\021degrees_longitude\030\002 \001(\001\022\f\n\004name\030\003 \001(\t\022\017\n\007address\030\004 \001(\t\022\013\n\003url", "\030\005 \001(\t\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\032\002\n\023LiveLocationMessage\022\030\n\020degrees_latitude\030\001 \001(\001\022\031\n\021degrees_longitude\030\002 \001(\001\022\032\n\022accuracy_in_meters\030\003 \001(\r\022\024\n\fspeed_in_mps\030\004 \001(\002\022-\n%degrees_clockwise_from_magnetic_north\030\005 \001(\r\022\017\n\007caption\030\006 \001(\t\022\027\n\017sequence_number\030\007 \001(\003\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\032Ê\002\n\023ExtendedTextMessage\022\f\n\004text\030\001 \001(\t\022\024", "\n\fmatched_text\030\002 \001(\t\022\025\n\rcanonical_url\030\004 \001(\t\022\023\n\013description\030\005 \001(\t\022\r\n\005title\030\006 \001(\t\022\021\n\ttext_argb\030\007 \001(\007\022\027\n\017background_argb\030\b \001(\007\022<\n\004font\030\t \001(\0162..whatsapp.Message.ExtendedTextMessage.FontType\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\"%\n\bFontType\022\016\n\nSANS_SERIF\020\000\022\t\n\005SERIF\020\001\032\002\n\017DocumentMessage\022\013\n\003url\030\001 \001(\t\022\020\n\bmimetype\030\002 \001(\t\022\r\n\005title\030\003 \001(\t\022\023\n\013file_sha256\030\004 \001(\f\022\023\n\013file_length\030\005 \001(", "\004\022\022\n\npage_count\030\006 \001(\r\022\021\n\tmedia_key\030\007 \001(\f\022\021\n\tfile_name\030\b \001(\t\022\027\n\017file_enc_sha256\030\t \001(\f\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\032é\001\n\fAudioMessage\022\013\n\003url\030\001 \001(\t\022\020\n\bmimetype\030\002 \001(\t\022\023\n\013file_sha256\030\003 \001(\f\022\023\n\013file_length\030\004 \001(\004\022\017\n\007seconds\030\005 \001(\r\022\013\n\003ptt\030\006 \001(\b\022\021\n\tmedia_key\030\007 \001(\f\022\027\n\017file_enc_sha256\030\b \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\022\031\n\021streaming_sidecar\030\022 \001(\f\032®\003\n\fVideoM", "essage\022\013\n\003url\030\001 \001(\t\022\020\n\bmimetype\030\002 \001(\t\022\023\n\013file_sha256\030\003 \001(\f\022\023\n\013file_length\030\004 \001(\004\022\017\n\007seconds\030\005 \001(\r\022\021\n\tmedia_key\030\006 \001(\f\022\017\n\007caption\030\007 \001(\t\022\024\n\fgif_playback\030\b \001(\b\022\016\n\006height\030\t \001(\r\022\r\n\005width\030\n \001(\r\022\027\n\017file_enc_sha256\030\013 \001(\f\022\026\n\016jpeg_thumbnail\030\020 \001(\f\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\022\031\n\021streaming_sidecar\030\022 \001(\f\022C\n\017gif_attribution\030\023 \001(\0162*.whatsapp.Message.VideoMessage.Attribution\"-\n\013Attribution\022\b\n\004NONE\020\000", "\022\t\n\005GIPHY\020\001\022\t\n\005TENOR\020\002\032ì\n\n\027HighlyStructuredMessage\022\021\n\tnamespace\030\001 \001(\t\022\024\n\felement_name\030\002 \001(\t\022\016\n\006params\030\003 \003(\t\022\023\n\013fallback_lg\030\004 \001(\t\022\023\n\013fallback_lc\030\005 \001(\t\022]\n\022localizable_params\030\006 \003(\0132A.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter\032\t\n\027HSMLocalizableParameter\022\017\n\007default\030\001 \001(\t\022a\n\bcurrency\030\002 \001(\0132M.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrencyH\000\022b\n\tdate_tim", "e\030\003 \001(\0132M.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTimeH\000\0329\n\013HSMCurrency\022\025\n\rcurrency_code\030\001 \001(\t\022\023\n\013amount_1000\030\002 \001(\003\032Ð\006\n\013HSMDateTime\022w\n\tcomponent\030\001 \001(\0132b.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponentH\000\022x\n\nunix_epoch\030\002 \001(\0132b.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixE", "pochH\000\032\004\n\024HSMDateTimeComponent\022\001\n\013day_of_week\030\001 \001(\0162p.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.DayOfWeekType\022\f\n\004year\030\002 \001(\r\022\r\n\005month\030\003 \001(\r\022\024\n\fday_of_month\030\004 \001(\r\022\f\n\004hour\030\005 \001(\r\022\016\n\006minute\030\006 \001(\r\022\001\n\bcalendar\030\007 \001(\0162o.whatsapp.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.CalendarType\"k\n\rDayOfWeekType\022\n\n", "\006MONDAY\020\001\022\013\n\007TUESDAY\020\002\022\r\n\tWEDNESDAY\020\003\022\f\n\bTHURSDAY\020\004\022\n\n\006FRIDAY\020\005\022\f\n\bSATURDAY\020\006\022\n\n\006SUNDAY\020\007\".\n\fCalendarType\022\r\n\tGREGORIAN\020\001\022\017\n\013SOLAR_HIJRI\020\002\032)\n\024HSMDateTimeUnixEpoch\022\021\n\ttimestamp\030\001 \001(\003B\020\n\016datetime_oneofB\r\n\013param_oneof\032\030\n\004Call\022\020\n\bcall_key\030\001 \001(\f\032(\n\004Chat\022\024\n\fdisplay_name\030\001 \001(\t\022\n\n\002id\030\002 \001(\t\032~\n\017ProtocolMessage\022!\n\003key\030\001 \001(\0132\024.whatsapp.MessageKey\0224\n\004type\030\002 \001(\0162&.whatsapp.Message.ProtocolMessage.Type\"\022\n\004Type\022\n\n", "\006REVOKE\020\000\032\001\n\024ContactsArrayMessage\022\024\n\fdisplay_name\030\001 \001(\t\0222\n\bcontacts\030\002 \003(\0132 .whatsapp.Message.ContactMessage\022+\n\fcontext_info\030\021 \001(\0132\025.whatsapp.ContextInfo\"\002\n\013ContextInfo\022\021\n\tstanza_id\030\001 \001(\t\022\023\n\013participant\030\002 \001(\t\022)\n\016quoted_message\030\003 \001(\0132\021.whatsapp.Message\022\022\n\nremote_jid\030\004 \001(\t\022\025\n\rmentioned_jid\030\017 \003(\t\022\024\n\fedit_version\030\020 \001(\r\022\026\n\016revoke_message\030\021 \001(\b\022\031\n\021conversion_source\030\022 \001(\t\022\027\n\017conversion_data\030\023 \001(\f\022 \n\030con", "version_delay_seconds\030\024 \001(\rB\026\n\022com.whatsapp.protoH\002" }, new i.g[] { localg }, local1);
    a = (i.a)Q.e().get(0);
    b = new o.f(a, new String[] { "Conversation", "SenderKeyDistributionMessage", "ImageMessage", "ContactMessage", "LocationMessage", "ExtendedTextMessage", "DocumentMessage", "AudioMessage", "VideoMessage", "Call", "Chat", "ProtocolMessage", "ContactsArrayMessage", "HighlyStructuredMessage", "FastRatchetKeySenderKeyDistributionMessage", "LiveLocationMessage" });
    c = (i.a)a.f().get(0);
    d = new o.f(c, new String[] { "GroupId", "AxolotlSenderKeyDistributionMessage" });
    e = (i.a)a.f().get(1);
    f = new o.f(e, new String[] { "Url", "Mimetype", "Caption", "FileSha256", "FileLength", "Height", "Width", "MediaKey", "FileEncSha256", "JpegThumbnail", "ContextInfo" });
    g = (i.a)a.f().get(2);
    h = new o.f(g, new String[] { "DisplayName", "Vcard", "ContextInfo" });
    i = (i.a)a.f().get(3);
    j = new o.f(i, new String[] { "DegreesLatitude", "DegreesLongitude", "Name", "Address", "Url", "JpegThumbnail", "ContextInfo" });
    k = (i.a)a.f().get(4);
    l = new o.f(k, new String[] { "DegreesLatitude", "DegreesLongitude", "AccuracyInMeters", "SpeedInMps", "DegreesClockwiseFromMagneticNorth", "Caption", "SequenceNumber", "JpegThumbnail", "ContextInfo" });
    m = (i.a)a.f().get(5);
    n = new o.f(m, new String[] { "Text", "MatchedText", "CanonicalUrl", "Description", "Title", "TextArgb", "BackgroundArgb", "Font", "JpegThumbnail", "ContextInfo" });
    o = (i.a)a.f().get(6);
    p = new o.f(o, new String[] { "Url", "Mimetype", "Title", "FileSha256", "FileLength", "PageCount", "MediaKey", "FileName", "FileEncSha256", "JpegThumbnail", "ContextInfo" });
    q = (i.a)a.f().get(7);
    r = new o.f(q, new String[] { "Url", "Mimetype", "FileSha256", "FileLength", "Seconds", "Ptt", "MediaKey", "FileEncSha256", "ContextInfo", "StreamingSidecar" });
    s = (i.a)a.f().get(8);
    t = new o.f(s, new String[] { "Url", "Mimetype", "FileSha256", "FileLength", "Seconds", "MediaKey", "Caption", "GifPlayback", "Height", "Width", "FileEncSha256", "JpegThumbnail", "ContextInfo", "StreamingSidecar", "GifAttribution" });
    u = (i.a)a.f().get(9);
    v = new o.f(u, new String[] { "Namespace", "ElementName", "Params", "FallbackLg", "FallbackLc", "LocalizableParams" });
    w = (i.a)u.f().get(0);
    x = new o.f(w, new String[] { "Default", "Currency", "DateTime", "ParamOneof" });
    y = (i.a)w.f().get(0);
    z = new o.f(y, new String[] { "CurrencyCode", "Amount1000" });
    A = (i.a)w.f().get(1);
    B = new o.f(A, new String[] { "Component", "UnixEpoch", "DatetimeOneof" });
    C = (i.a)A.f().get(0);
    D = new o.f(C, new String[] { "DayOfWeek", "Year", "Month", "DayOfMonth", "Hour", "Minute", "Calendar" });
    E = (i.a)A.f().get(1);
    F = new o.f(E, new String[] { "Timestamp" });
    G = (i.a)a.f().get(10);
    H = new o.f(G, new String[] { "CallKey" });
    I = (i.a)a.f().get(11);
    J = new o.f(I, new String[] { "DisplayName", "Id" });
    K = (i.a)a.f().get(12);
    L = new o.f(K, new String[] { "Key", "Type" });
    M = (i.a)a.f().get(13);
    N = new o.f(M, new String[] { "DisplayName", "Contacts", "ContextInfo" });
    O = (i.a)Q.e().get(1);
    P = new o.f(O, new String[] { "StanzaId", "Participant", "QuotedMessage", "RemoteJid", "MentionedJid", "EditVersion", "RevokeMessage", "ConversionSource", "ConversionData", "ConversionDelaySeconds" });
    Protocol.a();
  }
  
  public static final class ContextInfo
    extends o
    implements f.a
  {
    public static final int CONVERSION_DATA_FIELD_NUMBER = 19;
    public static final int CONVERSION_DELAY_SECONDS_FIELD_NUMBER = 20;
    public static final int CONVERSION_SOURCE_FIELD_NUMBER = 18;
    public static final int EDIT_VERSION_FIELD_NUMBER = 16;
    public static final int MENTIONED_JID_FIELD_NUMBER = 15;
    public static ae<ContextInfo> PARSER = new c()
    {
      private static E2E.ContextInfo c(f paramAnonymousf, m paramAnonymousm)
      {
        E2E.ContextInfo.a locala = E2E.ContextInfo.newBuilder();
        try
        {
          locala.mergeFrom(paramAnonymousf, paramAnonymousm);
          return locala.buildPartial();
        }
        catch (q paramAnonymousf)
        {
          paramAnonymousf.a = locala.buildPartial();
          throw paramAnonymousf;
        }
        catch (IOException paramAnonymousf)
        {
          paramAnonymousf = new q(paramAnonymousf.getMessage());
          paramAnonymousf.a = locala.buildPartial();
          throw paramAnonymousf;
        }
      }
    };
    public static final int PARTICIPANT_FIELD_NUMBER = 2;
    public static final int QUOTED_MESSAGE_FIELD_NUMBER = 3;
    public static final int REMOTE_JID_FIELD_NUMBER = 4;
    public static final int REVOKE_MESSAGE_FIELD_NUMBER = 17;
    public static final int STANZA_ID_FIELD_NUMBER = 1;
    private static final ContextInfo defaultInstance;
    private int bitField0_;
    private e conversionData_;
    private int conversionDelaySeconds_;
    private Object conversionSource_;
    private int editVersion_;
    private u mentionedJid_;
    private Object participant_;
    private E2E.Message quotedMessage_;
    private Object remoteJid_;
    private boolean revokeMessage_;
    private Object stanzaId_;
    private final an unknownFields;
    
    static
    {
      ContextInfo localContextInfo = new ContextInfo(true);
      defaultInstance = localContextInfo;
      localContextInfo.initFields();
    }
    
    private ContextInfo(o.a<?> parama)
    {
      super();
      this.unknownFields = parama.getUnknownFields();
    }
    
    private ContextInfo(boolean paramBoolean)
    {
      this.unknownFields = an.b();
    }
    
    public static ContextInfo getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final i.a getDescriptor()
    {
      return E2E.O();
    }
    
    private void initFields()
    {
      this.stanzaId_ = "";
      this.participant_ = "";
      this.quotedMessage_ = E2E.Message.getDefaultInstance();
      this.remoteJid_ = "";
      this.mentionedJid_ = t.a;
      this.editVersion_ = 0;
      this.revokeMessage_ = false;
      this.conversionSource_ = "";
      this.conversionData_ = e.b;
      this.conversionDelaySeconds_ = 0;
    }
    
    public static a newBuilder()
    {
      return a.a();
    }
    
    public static a newBuilder(ContextInfo paramContextInfo)
    {
      return (a)newBuilder().mergeFrom(paramContextInfo);
    }
    
    public static ContextInfo parseDelimitedFrom(InputStream paramInputStream)
    {
      return (ContextInfo)PARSER.a(paramInputStream);
    }
    
    public static ContextInfo parseDelimitedFrom(InputStream paramInputStream, m paramm)
    {
      return (ContextInfo)PARSER.a(paramInputStream, paramm);
    }
    
    public static ContextInfo parseFrom(e parame)
    {
      return (ContextInfo)PARSER.a(parame);
    }
    
    public static ContextInfo parseFrom(e parame, m paramm)
    {
      return (ContextInfo)PARSER.a(parame, paramm);
    }
    
    public static ContextInfo parseFrom(f paramf)
    {
      return (ContextInfo)PARSER.a(paramf);
    }
    
    public static ContextInfo parseFrom(f paramf, m paramm)
    {
      return (ContextInfo)PARSER.a(paramf, paramm);
    }
    
    public static ContextInfo parseFrom(InputStream paramInputStream)
    {
      return (ContextInfo)PARSER.b(paramInputStream);
    }
    
    public static ContextInfo parseFrom(InputStream paramInputStream, m paramm)
    {
      return (ContextInfo)PARSER.b(paramInputStream, paramm);
    }
    
    public static ContextInfo parseFrom(byte[] paramArrayOfByte)
    {
      return (ContextInfo)PARSER.a(paramArrayOfByte);
    }
    
    public static ContextInfo parseFrom(byte[] paramArrayOfByte, m paramm)
    {
      return (ContextInfo)PARSER.a(paramArrayOfByte, paramm);
    }
    
    public final e getConversionData()
    {
      return this.conversionData_;
    }
    
    public final int getConversionDelaySeconds()
    {
      return this.conversionDelaySeconds_;
    }
    
    public final String getConversionSource()
    {
      Object localObject = this.conversionSource_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.conversionSource_ = str;
      }
      return str;
    }
    
    public final e getConversionSourceBytes()
    {
      Object localObject = this.conversionSource_;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.conversionSource_ = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    public final ContextInfo getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final int getEditVersion()
    {
      return this.editVersion_;
    }
    
    public final String getMentionedJid(int paramInt)
    {
      return (String)this.mentionedJid_.get(paramInt);
    }
    
    public final e getMentionedJidBytes(int paramInt)
    {
      return this.mentionedJid_.a(paramInt);
    }
    
    public final int getMentionedJidCount()
    {
      return this.mentionedJid_.size();
    }
    
    public final ag getMentionedJidList()
    {
      return this.mentionedJid_;
    }
    
    public final ae<ContextInfo> getParserForType()
    {
      return PARSER;
    }
    
    public final String getParticipant()
    {
      Object localObject = this.participant_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.participant_ = str;
      }
      return str;
    }
    
    public final e getParticipantBytes()
    {
      Object localObject = this.participant_;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.participant_ = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    public final E2E.Message getQuotedMessage()
    {
      return this.quotedMessage_;
    }
    
    public final f.a getQuotedMessageOrBuilder$4bebb5ad$1ec9fbcb$5f20f411()
    {
      return this.quotedMessage_;
    }
    
    public final String getRemoteJid()
    {
      Object localObject = this.remoteJid_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.remoteJid_ = str;
      }
      return str;
    }
    
    public final e getRemoteJidBytes()
    {
      Object localObject = this.remoteJid_;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.remoteJid_ = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    public final boolean getRevokeMessage()
    {
      return this.revokeMessage_;
    }
    
    public final String getStanzaId()
    {
      Object localObject = this.stanzaId_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.stanzaId_ = str;
      }
      return str;
    }
    
    public final e getStanzaIdBytes()
    {
      Object localObject = this.stanzaId_;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.stanzaId_ = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    public final an getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasConversionData()
    {
      return (this.bitField0_ & 0x80) == 128;
    }
    
    public final boolean hasConversionDelaySeconds()
    {
      return (this.bitField0_ & 0x100) == 256;
    }
    
    public final boolean hasConversionSource()
    {
      return (this.bitField0_ & 0x40) == 64;
    }
    
    public final boolean hasEditVersion()
    {
      return (this.bitField0_ & 0x10) == 16;
    }
    
    public final boolean hasParticipant()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public final boolean hasQuotedMessage()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public final boolean hasRemoteJid()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public final boolean hasRevokeMessage()
    {
      return (this.bitField0_ & 0x20) == 32;
    }
    
    public final boolean hasStanzaId()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    protected final o.f internalGetFieldAccessorTable()
    {
      return E2E.P().a(ContextInfo.class, a.class);
    }
    
    public final a newBuilderForType()
    {
      return newBuilder();
    }
    
    protected final a newBuilderForType(o.b paramb)
    {
      return new a(paramb, (byte)0);
    }
    
    public final a toBuilder()
    {
      return newBuilder(this);
    }
    
    public static final class a
      extends o.a<a>
      implements f.a
    {
      private int a;
      private Object b = "";
      private Object c = "";
      private E2E.Message d = E2E.Message.getDefaultInstance();
      private aj<E2E.Message, E2E.Message.a, f.a> e;
      private Object h = "";
      private u i = t.a;
      private int j;
      private boolean k;
      private Object l = "";
      private e m = e.b;
      private int n;
      
      private a()
      {
        b();
      }
      
      private a(o.b paramb)
      {
        super();
        b();
      }
      
      private void b()
      {
        if (E2E.ContextInfo.alwaysUseFieldBuilders) {
          c();
        }
      }
      
      private aj<E2E.Message, E2E.Message.a, f.a> c()
      {
        if (this.e == null)
        {
          this.e = new aj(getQuotedMessage(), getParentForChildren(), this.g);
          this.d = null;
        }
        return this.e;
      }
      
      private void d()
      {
        if ((this.a & 0x10) != 16)
        {
          this.i = new t(this.i);
          this.a |= 0x10;
        }
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.O();
      }
      
      public final a addAllMentionedJid(Iterable<String> paramIterable)
      {
        d();
        b.a.addAll(paramIterable, this.i);
        onChanged();
        return this;
      }
      
      public final a addMentionedJid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        d();
        this.i.add(paramString);
        onChanged();
        return this;
      }
      
      public final a addMentionedJidBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        d();
        this.i.a(parame);
        onChanged();
        return this;
      }
      
      public final E2E.ContextInfo build()
      {
        E2E.ContextInfo localContextInfo = buildPartial();
        if (!localContextInfo.isInitialized()) {
          throw newUninitializedMessageException(localContextInfo);
        }
        return localContextInfo;
      }
      
      public final E2E.ContextInfo buildPartial()
      {
        int i1 = 1;
        E2E.ContextInfo localContextInfo = new E2E.ContextInfo(this, null);
        int i3 = this.a;
        if ((i3 & 0x1) == 1) {}
        for (;;)
        {
          E2E.ContextInfo.access$26902(localContextInfo, this.b);
          int i2 = i1;
          if ((i3 & 0x2) == 2) {
            i2 = i1 | 0x2;
          }
          E2E.ContextInfo.access$27002(localContextInfo, this.c);
          if ((i3 & 0x4) == 4) {
            i2 |= 0x4;
          }
          for (;;)
          {
            if (this.e == null) {
              E2E.ContextInfo.access$27102(localContextInfo, this.d);
            }
            for (;;)
            {
              i1 = i2;
              if ((i3 & 0x8) == 8) {
                i1 = i2 | 0x8;
              }
              E2E.ContextInfo.access$27202(localContextInfo, this.h);
              if ((this.a & 0x10) == 16)
              {
                this.i = this.i.b();
                this.a &= 0xFFFFFFEF;
              }
              E2E.ContextInfo.access$27302(localContextInfo, this.i);
              i2 = i1;
              if ((i3 & 0x20) == 32) {
                i2 = i1 | 0x10;
              }
              E2E.ContextInfo.access$27402(localContextInfo, this.j);
              i1 = i2;
              if ((i3 & 0x40) == 64) {
                i1 = i2 | 0x20;
              }
              E2E.ContextInfo.access$27502(localContextInfo, this.k);
              i2 = i1;
              if ((i3 & 0x80) == 128) {
                i2 = i1 | 0x40;
              }
              E2E.ContextInfo.access$27602(localContextInfo, this.l);
              i1 = i2;
              if ((i3 & 0x100) == 256) {
                i1 = i2 | 0x80;
              }
              E2E.ContextInfo.access$27702(localContextInfo, this.m);
              i2 = i1;
              if ((i3 & 0x200) == 512) {
                i2 = i1 | 0x100;
              }
              E2E.ContextInfo.access$27802(localContextInfo, this.n);
              E2E.ContextInfo.access$27902(localContextInfo, i2);
              onBuilt();
              return localContextInfo;
              E2E.ContextInfo.access$27102(localContextInfo, (E2E.Message)this.e.c());
            }
          }
          i1 = 0;
        }
      }
      
      public final a clear()
      {
        super.clear();
        this.b = "";
        this.a &= 0xFFFFFFFE;
        this.c = "";
        this.a &= 0xFFFFFFFD;
        if (this.e == null) {
          this.d = E2E.Message.getDefaultInstance();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFFB;
          this.h = "";
          this.a &= 0xFFFFFFF7;
          this.i = t.a;
          this.a &= 0xFFFFFFEF;
          this.j = 0;
          this.a &= 0xFFFFFFDF;
          this.k = false;
          this.a &= 0xFFFFFFBF;
          this.l = "";
          this.a &= 0xFF7F;
          this.m = e.b;
          this.a &= 0xFEFF;
          this.n = 0;
          this.a &= 0xFDFF;
          return this;
          this.e.f();
        }
      }
      
      public final a clearConversionData()
      {
        this.a &= 0xFEFF;
        this.m = E2E.ContextInfo.getDefaultInstance().getConversionData();
        onChanged();
        return this;
      }
      
      public final a clearConversionDelaySeconds()
      {
        this.a &= 0xFDFF;
        this.n = 0;
        onChanged();
        return this;
      }
      
      public final a clearConversionSource()
      {
        this.a &= 0xFF7F;
        this.l = E2E.ContextInfo.getDefaultInstance().getConversionSource();
        onChanged();
        return this;
      }
      
      public final a clearEditVersion()
      {
        this.a &= 0xFFFFFFDF;
        this.j = 0;
        onChanged();
        return this;
      }
      
      public final a clearMentionedJid()
      {
        this.i = t.a;
        this.a &= 0xFFFFFFEF;
        onChanged();
        return this;
      }
      
      public final a clearParticipant()
      {
        this.a &= 0xFFFFFFFD;
        this.c = E2E.ContextInfo.getDefaultInstance().getParticipant();
        onChanged();
        return this;
      }
      
      public final a clearQuotedMessage()
      {
        if (this.e == null)
        {
          this.d = E2E.Message.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFFB;
          return this;
          this.e.f();
        }
      }
      
      public final a clearRemoteJid()
      {
        this.a &= 0xFFFFFFF7;
        this.h = E2E.ContextInfo.getDefaultInstance().getRemoteJid();
        onChanged();
        return this;
      }
      
      public final a clearRevokeMessage()
      {
        this.a &= 0xFFFFFFBF;
        this.k = false;
        onChanged();
        return this;
      }
      
      public final a clearStanzaId()
      {
        this.a &= 0xFFFFFFFE;
        this.b = E2E.ContextInfo.getDefaultInstance().getStanzaId();
        onChanged();
        return this;
      }
      
      public final a clone()
      {
        return (a)new a().mergeFrom(buildPartial());
      }
      
      public final e getConversionData()
      {
        return this.m;
      }
      
      public final int getConversionDelaySeconds()
      {
        return this.n;
      }
      
      public final String getConversionSource()
      {
        Object localObject = this.l;
        if (!(localObject instanceof String))
        {
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.l = str;
          }
          return str;
        }
        return (String)localObject;
      }
      
      public final e getConversionSourceBytes()
      {
        Object localObject = this.l;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.l = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getDefaultInstanceForType()
      {
        return E2E.ContextInfo.getDefaultInstance();
      }
      
      public final i.a getDescriptorForType()
      {
        return E2E.O();
      }
      
      public final int getEditVersion()
      {
        return this.j;
      }
      
      public final String getMentionedJid(int paramInt)
      {
        return (String)this.i.get(paramInt);
      }
      
      public final e getMentionedJidBytes(int paramInt)
      {
        return this.i.a(paramInt);
      }
      
      public final int getMentionedJidCount()
      {
        return this.i.size();
      }
      
      public final ag getMentionedJidList()
      {
        return this.i.b();
      }
      
      public final String getParticipant()
      {
        Object localObject = this.c;
        if (!(localObject instanceof String))
        {
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.c = str;
          }
          return str;
        }
        return (String)localObject;
      }
      
      public final e getParticipantBytes()
      {
        Object localObject = this.c;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.c = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.Message getQuotedMessage()
      {
        if (this.e == null) {
          return this.d;
        }
        return (E2E.Message)this.e.b();
      }
      
      public final E2E.Message.a getQuotedMessageBuilder()
      {
        this.a |= 0x4;
        onChanged();
        return (E2E.Message.a)c().d();
      }
      
      public final f.a getQuotedMessageOrBuilder$4bebb5ad$1ec9fbcb$5f20f411()
      {
        if (this.e != null) {
          return (f.a)this.e.e();
        }
        return this.d;
      }
      
      public final String getRemoteJid()
      {
        Object localObject = this.h;
        if (!(localObject instanceof String))
        {
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.h = str;
          }
          return str;
        }
        return (String)localObject;
      }
      
      public final e getRemoteJidBytes()
      {
        Object localObject = this.h;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.h = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean getRevokeMessage()
      {
        return this.k;
      }
      
      public final String getStanzaId()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.b = str;
          }
          return str;
        }
        return (String)localObject;
      }
      
      public final e getStanzaIdBytes()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.b = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean hasConversionData()
      {
        return (this.a & 0x100) == 256;
      }
      
      public final boolean hasConversionDelaySeconds()
      {
        return (this.a & 0x200) == 512;
      }
      
      public final boolean hasConversionSource()
      {
        return (this.a & 0x80) == 128;
      }
      
      public final boolean hasEditVersion()
      {
        return (this.a & 0x20) == 32;
      }
      
      public final boolean hasParticipant()
      {
        return (this.a & 0x2) == 2;
      }
      
      public final boolean hasQuotedMessage()
      {
        return (this.a & 0x4) == 4;
      }
      
      public final boolean hasRemoteJid()
      {
        return (this.a & 0x8) == 8;
      }
      
      public final boolean hasRevokeMessage()
      {
        return (this.a & 0x40) == 64;
      }
      
      public final boolean hasStanzaId()
      {
        return (this.a & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.P().a(E2E.ContextInfo.class, a.class);
      }
      
      public final a mergeQuotedMessage(E2E.Message paramMessage)
      {
        if (this.e == null) {
          if (((this.a & 0x4) == 4) && (this.d != E2E.Message.getDefaultInstance()))
          {
            this.d = ((E2E.Message.a)E2E.Message.newBuilder(this.d).mergeFrom(paramMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.d = paramMessage;
          break;
          this.e.b(paramMessage);
        }
      }
      
      public final a setConversionData(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x100;
        this.m = parame;
        onChanged();
        return this;
      }
      
      public final a setConversionDelaySeconds(int paramInt)
      {
        this.a |= 0x200;
        this.n = paramInt;
        onChanged();
        return this;
      }
      
      public final a setConversionSource(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x80;
        this.l = paramString;
        onChanged();
        return this;
      }
      
      public final a setConversionSourceBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x80;
        this.l = parame;
        onChanged();
        return this;
      }
      
      public final a setEditVersion(int paramInt)
      {
        this.a |= 0x20;
        this.j = paramInt;
        onChanged();
        return this;
      }
      
      public final a setMentionedJid(int paramInt, String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        d();
        this.i.set(paramInt, paramString);
        onChanged();
        return this;
      }
      
      public final a setParticipant(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x2;
        this.c = paramString;
        onChanged();
        return this;
      }
      
      public final a setParticipantBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x2;
        this.c = parame;
        onChanged();
        return this;
      }
      
      public final a setQuotedMessage(E2E.Message.a parama)
      {
        if (this.e == null)
        {
          this.d = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.e.a(parama.build());
        }
      }
      
      public final a setQuotedMessage(E2E.Message paramMessage)
      {
        if (this.e == null)
        {
          if (paramMessage == null) {
            throw new NullPointerException();
          }
          this.d = paramMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.e.a(paramMessage);
        }
      }
      
      public final a setRemoteJid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.h = paramString;
        onChanged();
        return this;
      }
      
      public final a setRemoteJidBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.h = parame;
        onChanged();
        return this;
      }
      
      public final a setRevokeMessage(boolean paramBoolean)
      {
        this.a |= 0x40;
        this.k = paramBoolean;
        onChanged();
        return this;
      }
      
      public final a setStanzaId(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = paramString;
        onChanged();
        return this;
      }
      
      public final a setStanzaIdBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = parame;
        onChanged();
        return this;
      }
    }
  }
  
  public static final class Message
    extends o
    implements f.a
  {
    public static final int AUDIO_MESSAGE_FIELD_NUMBER = 8;
    public static final int CALL_FIELD_NUMBER = 10;
    public static final int CHAT_FIELD_NUMBER = 11;
    public static final int CONTACTS_ARRAY_MESSAGE_FIELD_NUMBER = 13;
    public static final int CONTACT_MESSAGE_FIELD_NUMBER = 4;
    public static final int CONVERSATION_FIELD_NUMBER = 1;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 7;
    public static final int EXTENDED_TEXT_MESSAGE_FIELD_NUMBER = 6;
    public static final int FAST_RATCHET_KEY_SENDER_KEY_DISTRIBUTION_MESSAGE_FIELD_NUMBER = 15;
    public static final int HIGHLY_STRUCTURED_MESSAGE_FIELD_NUMBER = 14;
    public static final int IMAGE_MESSAGE_FIELD_NUMBER = 3;
    public static final int LIVE_LOCATION_MESSAGE_FIELD_NUMBER = 18;
    public static final int LOCATION_MESSAGE_FIELD_NUMBER = 5;
    public static ae<Message> PARSER = new c()
    {
      private static E2E.Message c(f paramAnonymousf, m paramAnonymousm)
      {
        E2E.Message.a locala = E2E.Message.newBuilder();
        try
        {
          locala.mergeFrom(paramAnonymousf, paramAnonymousm);
          return locala.buildPartial();
        }
        catch (q paramAnonymousf)
        {
          paramAnonymousf.a = locala.buildPartial();
          throw paramAnonymousf;
        }
        catch (IOException paramAnonymousf)
        {
          paramAnonymousf = new q(paramAnonymousf.getMessage());
          paramAnonymousf.a = locala.buildPartial();
          throw paramAnonymousf;
        }
      }
    };
    public static final int PROTOCOL_MESSAGE_FIELD_NUMBER = 12;
    public static final int SENDER_KEY_DISTRIBUTION_MESSAGE_FIELD_NUMBER = 2;
    public static final int VIDEO_MESSAGE_FIELD_NUMBER = 9;
    private static final Message defaultInstance;
    private AudioMessage audioMessage_;
    private int bitField0_;
    private Call call_;
    private Chat chat_;
    private ContactMessage contactMessage_;
    private ContactsArrayMessage contactsArrayMessage_;
    private Object conversation_;
    private DocumentMessage documentMessage_;
    private ExtendedTextMessage extendedTextMessage_;
    private SenderKeyDistributionMessage fastRatchetKeySenderKeyDistributionMessage_;
    private HighlyStructuredMessage highlyStructuredMessage_;
    private ImageMessage imageMessage_;
    private LiveLocationMessage liveLocationMessage_;
    private LocationMessage locationMessage_;
    private ProtocolMessage protocolMessage_;
    private SenderKeyDistributionMessage senderKeyDistributionMessage_;
    private final an unknownFields;
    private VideoMessage videoMessage_;
    
    static
    {
      Message localMessage = new Message(true);
      defaultInstance = localMessage;
      localMessage.initFields();
    }
    
    private Message(o.a<?> parama)
    {
      super();
      this.unknownFields = parama.getUnknownFields();
    }
    
    private Message(boolean paramBoolean)
    {
      this.unknownFields = an.b();
    }
    
    public static Message getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final i.a getDescriptor()
    {
      return E2E.a();
    }
    
    private void initFields()
    {
      this.conversation_ = "";
      this.senderKeyDistributionMessage_ = SenderKeyDistributionMessage.getDefaultInstance();
      this.imageMessage_ = ImageMessage.getDefaultInstance();
      this.contactMessage_ = ContactMessage.getDefaultInstance();
      this.locationMessage_ = LocationMessage.getDefaultInstance();
      this.extendedTextMessage_ = ExtendedTextMessage.getDefaultInstance();
      this.documentMessage_ = DocumentMessage.getDefaultInstance();
      this.audioMessage_ = AudioMessage.getDefaultInstance();
      this.videoMessage_ = VideoMessage.getDefaultInstance();
      this.call_ = Call.getDefaultInstance();
      this.chat_ = Chat.getDefaultInstance();
      this.protocolMessage_ = ProtocolMessage.getDefaultInstance();
      this.contactsArrayMessage_ = ContactsArrayMessage.getDefaultInstance();
      this.highlyStructuredMessage_ = HighlyStructuredMessage.getDefaultInstance();
      this.fastRatchetKeySenderKeyDistributionMessage_ = SenderKeyDistributionMessage.getDefaultInstance();
      this.liveLocationMessage_ = LiveLocationMessage.getDefaultInstance();
    }
    
    public static a newBuilder()
    {
      return a.a();
    }
    
    public static a newBuilder(Message paramMessage)
    {
      return (a)newBuilder().mergeFrom(paramMessage);
    }
    
    public static Message parseDelimitedFrom(InputStream paramInputStream)
    {
      return (Message)PARSER.a(paramInputStream);
    }
    
    public static Message parseDelimitedFrom(InputStream paramInputStream, m paramm)
    {
      return (Message)PARSER.a(paramInputStream, paramm);
    }
    
    public static Message parseFrom(e parame)
    {
      return (Message)PARSER.a(parame);
    }
    
    public static Message parseFrom(e parame, m paramm)
    {
      return (Message)PARSER.a(parame, paramm);
    }
    
    public static Message parseFrom(f paramf)
    {
      return (Message)PARSER.a(paramf);
    }
    
    public static Message parseFrom(f paramf, m paramm)
    {
      return (Message)PARSER.a(paramf, paramm);
    }
    
    public static Message parseFrom(InputStream paramInputStream)
    {
      return (Message)PARSER.b(paramInputStream);
    }
    
    public static Message parseFrom(InputStream paramInputStream, m paramm)
    {
      return (Message)PARSER.b(paramInputStream, paramm);
    }
    
    public static Message parseFrom(byte[] paramArrayOfByte)
    {
      return (Message)PARSER.a(paramArrayOfByte);
    }
    
    public static Message parseFrom(byte[] paramArrayOfByte, m paramm)
    {
      return (Message)PARSER.a(paramArrayOfByte, paramm);
    }
    
    public final AudioMessage getAudioMessage()
    {
      return this.audioMessage_;
    }
    
    public final f.a getAudioMessageOrBuilder$12b3f6b8$1ec9fbcb$5f20f411()
    {
      return this.audioMessage_;
    }
    
    public final Call getCall()
    {
      return this.call_;
    }
    
    public final f.a getCallOrBuilder$78a3f3eb$1ec9fbcb$5f20f411()
    {
      return this.call_;
    }
    
    public final Chat getChat()
    {
      return this.chat_;
    }
    
    public final f.a getChatOrBuilder$5f74b48f$1ec9fbcb$5f20f411()
    {
      return this.chat_;
    }
    
    public final ContactMessage getContactMessage()
    {
      return this.contactMessage_;
    }
    
    public final f.a getContactMessageOrBuilder$1ba8293e$1ec9fbcb$5f20f411()
    {
      return this.contactMessage_;
    }
    
    public final ContactsArrayMessage getContactsArrayMessage()
    {
      return this.contactsArrayMessage_;
    }
    
    public final f.a getContactsArrayMessageOrBuilder$3fc5eea8$1ec9fbcb$5f20f411()
    {
      return this.contactsArrayMessage_;
    }
    
    public final String getConversation()
    {
      Object localObject = this.conversation_;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.conversation_ = str;
      }
      return str;
    }
    
    public final e getConversationBytes()
    {
      Object localObject = this.conversation_;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.conversation_ = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    public final Message getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final DocumentMessage getDocumentMessage()
    {
      return this.documentMessage_;
    }
    
    public final f.a getDocumentMessageOrBuilder$255045fb$1ec9fbcb$5f20f411()
    {
      return this.documentMessage_;
    }
    
    public final ExtendedTextMessage getExtendedTextMessage()
    {
      return this.extendedTextMessage_;
    }
    
    public final f.a getExtendedTextMessageOrBuilder$7d4dcd90$1ec9fbcb$5f20f411()
    {
      return this.extendedTextMessage_;
    }
    
    public final SenderKeyDistributionMessage getFastRatchetKeySenderKeyDistributionMessage()
    {
      return this.fastRatchetKeySenderKeyDistributionMessage_;
    }
    
    public final f.a getFastRatchetKeySenderKeyDistributionMessageOrBuilder$be31370$1ec9fbcb$5f20f411()
    {
      return this.fastRatchetKeySenderKeyDistributionMessage_;
    }
    
    public final HighlyStructuredMessage getHighlyStructuredMessage()
    {
      return this.highlyStructuredMessage_;
    }
    
    public final f.a getHighlyStructuredMessageOrBuilder$694fc456$1ec9fbcb$5f20f411()
    {
      return this.highlyStructuredMessage_;
    }
    
    public final ImageMessage getImageMessage()
    {
      return this.imageMessage_;
    }
    
    public final f.a getImageMessageOrBuilder$433ae99d$1ec9fbcb$5f20f411()
    {
      return this.imageMessage_;
    }
    
    public final LiveLocationMessage getLiveLocationMessage()
    {
      return this.liveLocationMessage_;
    }
    
    public final f.a getLiveLocationMessageOrBuilder$7333f915$1ec9fbcb$5f20f411()
    {
      return this.liveLocationMessage_;
    }
    
    public final LocationMessage getLocationMessage()
    {
      return this.locationMessage_;
    }
    
    public final f.a getLocationMessageOrBuilder$12aac15f$1ec9fbcb$5f20f411()
    {
      return this.locationMessage_;
    }
    
    public final ae<Message> getParserForType()
    {
      return PARSER;
    }
    
    public final ProtocolMessage getProtocolMessage()
    {
      return this.protocolMessage_;
    }
    
    public final f.a getProtocolMessageOrBuilder$326f921e$1ec9fbcb$5f20f411()
    {
      return this.protocolMessage_;
    }
    
    public final SenderKeyDistributionMessage getSenderKeyDistributionMessage()
    {
      return this.senderKeyDistributionMessage_;
    }
    
    public final f.a getSenderKeyDistributionMessageOrBuilder$be31370$1ec9fbcb$5f20f411()
    {
      return this.senderKeyDistributionMessage_;
    }
    
    public final an getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final VideoMessage getVideoMessage()
    {
      return this.videoMessage_;
    }
    
    public final f.a getVideoMessageOrBuilder$286f4f43$1ec9fbcb$5f20f411()
    {
      return this.videoMessage_;
    }
    
    public final boolean hasAudioMessage()
    {
      return (this.bitField0_ & 0x80) == 128;
    }
    
    public final boolean hasCall()
    {
      return (this.bitField0_ & 0x200) == 512;
    }
    
    public final boolean hasChat()
    {
      return (this.bitField0_ & 0x400) == 1024;
    }
    
    public final boolean hasContactMessage()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public final boolean hasContactsArrayMessage()
    {
      return (this.bitField0_ & 0x1000) == 4096;
    }
    
    public final boolean hasConversation()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    public final boolean hasDocumentMessage()
    {
      return (this.bitField0_ & 0x40) == 64;
    }
    
    public final boolean hasExtendedTextMessage()
    {
      return (this.bitField0_ & 0x20) == 32;
    }
    
    public final boolean hasFastRatchetKeySenderKeyDistributionMessage()
    {
      return (this.bitField0_ & 0x4000) == 16384;
    }
    
    public final boolean hasHighlyStructuredMessage()
    {
      return (this.bitField0_ & 0x2000) == 8192;
    }
    
    public final boolean hasImageMessage()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public final boolean hasLiveLocationMessage()
    {
      return (this.bitField0_ & 0x8000) == 32768;
    }
    
    public final boolean hasLocationMessage()
    {
      return (this.bitField0_ & 0x10) == 16;
    }
    
    public final boolean hasProtocolMessage()
    {
      return (this.bitField0_ & 0x800) == 2048;
    }
    
    public final boolean hasSenderKeyDistributionMessage()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public final boolean hasVideoMessage()
    {
      return (this.bitField0_ & 0x100) == 256;
    }
    
    protected final o.f internalGetFieldAccessorTable()
    {
      return E2E.b().a(Message.class, a.class);
    }
    
    public final a newBuilderForType()
    {
      return newBuilder();
    }
    
    protected final a newBuilderForType(o.b paramb)
    {
      return new a(paramb, (byte)0);
    }
    
    public final a toBuilder()
    {
      return newBuilder(this);
    }
    
    public static final class AudioMessage
      extends o
      implements f.a
    {
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int FILE_ENC_SHA256_FIELD_NUMBER = 8;
      public static final int FILE_LENGTH_FIELD_NUMBER = 4;
      public static final int FILE_SHA256_FIELD_NUMBER = 3;
      public static final int MEDIA_KEY_FIELD_NUMBER = 7;
      public static final int MIMETYPE_FIELD_NUMBER = 2;
      public static ae<AudioMessage> PARSER = new c()
      {
        private static E2E.Message.AudioMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.AudioMessage.a locala = E2E.Message.AudioMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int PTT_FIELD_NUMBER = 6;
      public static final int SECONDS_FIELD_NUMBER = 5;
      public static final int STREAMING_SIDECAR_FIELD_NUMBER = 18;
      public static final int URL_FIELD_NUMBER = 1;
      private static final AudioMessage defaultInstance;
      private int bitField0_;
      private E2E.ContextInfo contextInfo_;
      private e fileEncSha256_;
      private long fileLength_;
      private e fileSha256_;
      private e mediaKey_;
      private Object mimetype_;
      private boolean ptt_;
      private int seconds_;
      private e streamingSidecar_;
      private final an unknownFields;
      private Object url_;
      
      static
      {
        AudioMessage localAudioMessage = new AudioMessage(true);
        defaultInstance = localAudioMessage;
        localAudioMessage.initFields();
      }
      
      private AudioMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private AudioMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static AudioMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.q();
      }
      
      private void initFields()
      {
        this.url_ = "";
        this.mimetype_ = "";
        this.fileSha256_ = e.b;
        this.fileLength_ = 0L;
        this.seconds_ = 0;
        this.ptt_ = false;
        this.mediaKey_ = e.b;
        this.fileEncSha256_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
        this.streamingSidecar_ = e.b;
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(AudioMessage paramAudioMessage)
      {
        return (a)newBuilder().mergeFrom(paramAudioMessage);
      }
      
      public static AudioMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (AudioMessage)PARSER.a(paramInputStream);
      }
      
      public static AudioMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (AudioMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static AudioMessage parseFrom(e parame)
      {
        return (AudioMessage)PARSER.a(parame);
      }
      
      public static AudioMessage parseFrom(e parame, m paramm)
      {
        return (AudioMessage)PARSER.a(parame, paramm);
      }
      
      public static AudioMessage parseFrom(f paramf)
      {
        return (AudioMessage)PARSER.a(paramf);
      }
      
      public static AudioMessage parseFrom(f paramf, m paramm)
      {
        return (AudioMessage)PARSER.a(paramf, paramm);
      }
      
      public static AudioMessage parseFrom(InputStream paramInputStream)
      {
        return (AudioMessage)PARSER.b(paramInputStream);
      }
      
      public static AudioMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (AudioMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static AudioMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (AudioMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static AudioMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (AudioMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final AudioMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final e getFileEncSha256()
      {
        return this.fileEncSha256_;
      }
      
      public final long getFileLength()
      {
        return this.fileLength_;
      }
      
      public final e getFileSha256()
      {
        return this.fileSha256_;
      }
      
      public final e getMediaKey()
      {
        return this.mediaKey_;
      }
      
      public final String getMimetype()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.mimetype_ = str;
        }
        return str;
      }
      
      public final e getMimetypeBytes()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.mimetype_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<AudioMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final boolean getPtt()
      {
        return this.ptt_;
      }
      
      public final int getSeconds()
      {
        return this.seconds_;
      }
      
      public final e getStreamingSidecar()
      {
        return this.streamingSidecar_;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getUrl()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.url_ = str;
        }
        return str;
      }
      
      public final e getUrlBytes()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.url_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasFileEncSha256()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasFileLength()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasFileSha256()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasMediaKey()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasMimetype()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasPtt()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasSeconds()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final boolean hasStreamingSidecar()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      public final boolean hasUrl()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.r().a(AudioMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private e d = e.b;
        private long e;
        private int h;
        private boolean i;
        private e j = e.b;
        private e k = e.b;
        private E2E.ContextInfo l = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> m;
        private e n = e.b;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.AudioMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.m == null)
          {
            this.m = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.l = null;
          }
          return this.m;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.q();
        }
        
        public final E2E.Message.AudioMessage build()
        {
          E2E.Message.AudioMessage localAudioMessage = buildPartial();
          if (!localAudioMessage.isInitialized()) {
            throw newUninitializedMessageException(localAudioMessage);
          }
          return localAudioMessage;
        }
        
        public final E2E.Message.AudioMessage buildPartial()
        {
          int i2 = 1;
          E2E.Message.AudioMessage localAudioMessage = new E2E.Message.AudioMessage(this, null);
          int i3 = this.a;
          if ((i3 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.AudioMessage.access$11002(localAudioMessage, this.b);
            int i1 = i2;
            if ((i3 & 0x2) == 2) {
              i1 = i2 | 0x2;
            }
            E2E.Message.AudioMessage.access$11102(localAudioMessage, this.c);
            i2 = i1;
            if ((i3 & 0x4) == 4) {
              i2 = i1 | 0x4;
            }
            E2E.Message.AudioMessage.access$11202(localAudioMessage, this.d);
            i1 = i2;
            if ((i3 & 0x8) == 8) {
              i1 = i2 | 0x8;
            }
            E2E.Message.AudioMessage.access$11302(localAudioMessage, this.e);
            i2 = i1;
            if ((i3 & 0x10) == 16) {
              i2 = i1 | 0x10;
            }
            E2E.Message.AudioMessage.access$11402(localAudioMessage, this.h);
            i1 = i2;
            if ((i3 & 0x20) == 32) {
              i1 = i2 | 0x20;
            }
            E2E.Message.AudioMessage.access$11502(localAudioMessage, this.i);
            i2 = i1;
            if ((i3 & 0x40) == 64) {
              i2 = i1 | 0x40;
            }
            E2E.Message.AudioMessage.access$11602(localAudioMessage, this.j);
            i1 = i2;
            if ((i3 & 0x80) == 128) {
              i1 = i2 | 0x80;
            }
            E2E.Message.AudioMessage.access$11702(localAudioMessage, this.k);
            if ((i3 & 0x100) == 256) {
              i1 |= 0x100;
            }
            for (;;)
            {
              if (this.m == null) {
                E2E.Message.AudioMessage.access$11802(localAudioMessage, this.l);
              }
              for (;;)
              {
                i2 = i1;
                if ((i3 & 0x200) == 512) {
                  i2 = i1 | 0x200;
                }
                E2E.Message.AudioMessage.access$11902(localAudioMessage, this.n);
                E2E.Message.AudioMessage.access$12002(localAudioMessage, i2);
                onBuilt();
                return localAudioMessage;
                E2E.Message.AudioMessage.access$11802(localAudioMessage, (E2E.ContextInfo)this.m.c());
              }
            }
            i2 = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = e.b;
          this.a &= 0xFFFFFFFB;
          this.e = 0L;
          this.a &= 0xFFFFFFF7;
          this.h = 0;
          this.a &= 0xFFFFFFEF;
          this.i = false;
          this.a &= 0xFFFFFFDF;
          this.j = e.b;
          this.a &= 0xFFFFFFBF;
          this.k = e.b;
          this.a &= 0xFF7F;
          if (this.m == null) {
            this.l = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFEFF;
            this.n = e.b;
            this.a &= 0xFDFF;
            return this;
            this.m.f();
          }
        }
        
        public final a clearContextInfo()
        {
          if (this.m == null)
          {
            this.l = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFEFF;
            return this;
            this.m.f();
          }
        }
        
        public final a clearFileEncSha256()
        {
          this.a &= 0xFF7F;
          this.k = E2E.Message.AudioMessage.getDefaultInstance().getFileEncSha256();
          onChanged();
          return this;
        }
        
        public final a clearFileLength()
        {
          this.a &= 0xFFFFFFF7;
          this.e = 0L;
          onChanged();
          return this;
        }
        
        public final a clearFileSha256()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.AudioMessage.getDefaultInstance().getFileSha256();
          onChanged();
          return this;
        }
        
        public final a clearMediaKey()
        {
          this.a &= 0xFFFFFFBF;
          this.j = E2E.Message.AudioMessage.getDefaultInstance().getMediaKey();
          onChanged();
          return this;
        }
        
        public final a clearMimetype()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.AudioMessage.getDefaultInstance().getMimetype();
          onChanged();
          return this;
        }
        
        public final a clearPtt()
        {
          this.a &= 0xFFFFFFDF;
          this.i = false;
          onChanged();
          return this;
        }
        
        public final a clearSeconds()
        {
          this.a &= 0xFFFFFFEF;
          this.h = 0;
          onChanged();
          return this;
        }
        
        public final a clearStreamingSidecar()
        {
          this.a &= 0xFDFF;
          this.n = E2E.Message.AudioMessage.getDefaultInstance().getStreamingSidecar();
          onChanged();
          return this;
        }
        
        public final a clearUrl()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.AudioMessage.getDefaultInstance().getUrl();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.m == null) {
            return this.l;
          }
          return (E2E.ContextInfo)this.m.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x100;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.m != null) {
            return (f.a)this.m.e();
          }
          return this.l;
        }
        
        public final E2E.Message.AudioMessage getDefaultInstanceForType()
        {
          return E2E.Message.AudioMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.q();
        }
        
        public final e getFileEncSha256()
        {
          return this.k;
        }
        
        public final long getFileLength()
        {
          return this.e;
        }
        
        public final e getFileSha256()
        {
          return this.d;
        }
        
        public final e getMediaKey()
        {
          return this.j;
        }
        
        public final String getMimetype()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getMimetypeBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean getPtt()
        {
          return this.i;
        }
        
        public final int getSeconds()
        {
          return this.h;
        }
        
        public final e getStreamingSidecar()
        {
          return this.n;
        }
        
        public final String getUrl()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getUrlBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasFileEncSha256()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasFileLength()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasFileSha256()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasMediaKey()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasMimetype()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasPtt()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasSeconds()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasStreamingSidecar()
        {
          return (this.a & 0x200) == 512;
        }
        
        public final boolean hasUrl()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.r().a(E2E.Message.AudioMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.m == null) {
            if (((this.a & 0x100) == 256) && (this.l != E2E.ContextInfo.getDefaultInstance()))
            {
              this.l = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.l).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.l = paramContextInfo;
            break;
            this.m.b(paramContextInfo);
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.m == null)
          {
            this.l = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.m.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.m == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.l = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.m.a(paramContextInfo);
          }
        }
        
        public final a setFileEncSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = parame;
          onChanged();
          return this;
        }
        
        public final a setFileLength(long paramLong)
        {
          this.a |= 0x8;
          this.e = paramLong;
          onChanged();
          return this;
        }
        
        public final a setFileSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final a setMediaKey(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x40;
          this.j = parame;
          onChanged();
          return this;
        }
        
        public final a setMimetype(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setMimetypeBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setPtt(boolean paramBoolean)
        {
          this.a |= 0x20;
          this.i = paramBoolean;
          onChanged();
          return this;
        }
        
        public final a setSeconds(int paramInt)
        {
          this.a |= 0x10;
          this.h = paramInt;
          onChanged();
          return this;
        }
        
        public final a setStreamingSidecar(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x200;
          this.n = parame;
          onChanged();
          return this;
        }
        
        public final a setUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class Call
      extends o
      implements f.a
    {
      public static final int CALL_KEY_FIELD_NUMBER = 1;
      public static ae<Call> PARSER = new c()
      {
        private static E2E.Message.Call c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.Call.a locala = E2E.Message.Call.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      private static final Call defaultInstance;
      private int bitField0_;
      private e callKey_;
      private final an unknownFields;
      
      static
      {
        Call localCall = new Call(true);
        defaultInstance = localCall;
        localCall.initFields();
      }
      
      private Call(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private Call(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static Call getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.G();
      }
      
      private void initFields()
      {
        this.callKey_ = e.b;
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(Call paramCall)
      {
        return (a)newBuilder().mergeFrom(paramCall);
      }
      
      public static Call parseDelimitedFrom(InputStream paramInputStream)
      {
        return (Call)PARSER.a(paramInputStream);
      }
      
      public static Call parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (Call)PARSER.a(paramInputStream, paramm);
      }
      
      public static Call parseFrom(e parame)
      {
        return (Call)PARSER.a(parame);
      }
      
      public static Call parseFrom(e parame, m paramm)
      {
        return (Call)PARSER.a(parame, paramm);
      }
      
      public static Call parseFrom(f paramf)
      {
        return (Call)PARSER.a(paramf);
      }
      
      public static Call parseFrom(f paramf, m paramm)
      {
        return (Call)PARSER.a(paramf, paramm);
      }
      
      public static Call parseFrom(InputStream paramInputStream)
      {
        return (Call)PARSER.b(paramInputStream);
      }
      
      public static Call parseFrom(InputStream paramInputStream, m paramm)
      {
        return (Call)PARSER.b(paramInputStream, paramm);
      }
      
      public static Call parseFrom(byte[] paramArrayOfByte)
      {
        return (Call)PARSER.a(paramArrayOfByte);
      }
      
      public static Call parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (Call)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final e getCallKey()
      {
        return this.callKey_;
      }
      
      public final Call getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final ae<Call> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasCallKey()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.H().a(Call.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private e b = e.b;
        
        private a() {}
        
        private a(o.b paramb)
        {
          super();
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.G();
        }
        
        public final E2E.Message.Call build()
        {
          E2E.Message.Call localCall = buildPartial();
          if (!localCall.isInitialized()) {
            throw newUninitializedMessageException(localCall);
          }
          return localCall;
        }
        
        public final E2E.Message.Call buildPartial()
        {
          int i = 1;
          E2E.Message.Call localCall = new E2E.Message.Call(this, null);
          if ((this.a & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.Call.access$21202(localCall, this.b);
            E2E.Message.Call.access$21302(localCall, i);
            onBuilt();
            return localCall;
            i = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = e.b;
          this.a &= 0xFFFFFFFE;
          return this;
        }
        
        public final a clearCallKey()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.Call.getDefaultInstance().getCallKey();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final e getCallKey()
        {
          return this.b;
        }
        
        public final E2E.Message.Call getDefaultInstanceForType()
        {
          return E2E.Message.Call.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.G();
        }
        
        public final boolean hasCallKey()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.H().a(E2E.Message.Call.class, a.class);
        }
        
        public final a setCallKey(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class Chat
      extends o
      implements f.a
    {
      public static final int DISPLAY_NAME_FIELD_NUMBER = 1;
      public static final int ID_FIELD_NUMBER = 2;
      public static ae<Chat> PARSER = new c()
      {
        private static E2E.Message.Chat c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.Chat.a locala = E2E.Message.Chat.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      private static final Chat defaultInstance;
      private int bitField0_;
      private Object displayName_;
      private Object id_;
      private final an unknownFields;
      
      static
      {
        Chat localChat = new Chat(true);
        defaultInstance = localChat;
        localChat.initFields();
      }
      
      private Chat(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private Chat(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static Chat getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.I();
      }
      
      private void initFields()
      {
        this.displayName_ = "";
        this.id_ = "";
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(Chat paramChat)
      {
        return (a)newBuilder().mergeFrom(paramChat);
      }
      
      public static Chat parseDelimitedFrom(InputStream paramInputStream)
      {
        return (Chat)PARSER.a(paramInputStream);
      }
      
      public static Chat parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (Chat)PARSER.a(paramInputStream, paramm);
      }
      
      public static Chat parseFrom(e parame)
      {
        return (Chat)PARSER.a(parame);
      }
      
      public static Chat parseFrom(e parame, m paramm)
      {
        return (Chat)PARSER.a(parame, paramm);
      }
      
      public static Chat parseFrom(f paramf)
      {
        return (Chat)PARSER.a(paramf);
      }
      
      public static Chat parseFrom(f paramf, m paramm)
      {
        return (Chat)PARSER.a(paramf, paramm);
      }
      
      public static Chat parseFrom(InputStream paramInputStream)
      {
        return (Chat)PARSER.b(paramInputStream);
      }
      
      public static Chat parseFrom(InputStream paramInputStream, m paramm)
      {
        return (Chat)PARSER.b(paramInputStream, paramm);
      }
      
      public static Chat parseFrom(byte[] paramArrayOfByte)
      {
        return (Chat)PARSER.a(paramArrayOfByte);
      }
      
      public static Chat parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (Chat)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final Chat getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getDisplayName()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.displayName_ = str;
        }
        return str;
      }
      
      public final e getDisplayNameBytes()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.displayName_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final String getId()
      {
        Object localObject = this.id_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.id_ = str;
        }
        return str;
      }
      
      public final e getIdBytes()
      {
        Object localObject = this.id_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.id_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<Chat> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasDisplayName()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasId()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.J().a(Chat.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        
        private a() {}
        
        private a(o.b paramb)
        {
          super();
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.I();
        }
        
        public final E2E.Message.Chat build()
        {
          E2E.Message.Chat localChat = buildPartial();
          if (!localChat.isInitialized()) {
            throw newUninitializedMessageException(localChat);
          }
          return localChat;
        }
        
        public final E2E.Message.Chat buildPartial()
        {
          int i = 1;
          E2E.Message.Chat localChat = new E2E.Message.Chat(this, null);
          int k = this.a;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.Chat.access$22002(localChat, this.b);
            int j = i;
            if ((k & 0x2) == 2) {
              j = i | 0x2;
            }
            E2E.Message.Chat.access$22102(localChat, this.c);
            E2E.Message.Chat.access$22202(localChat, j);
            onBuilt();
            return localChat;
            i = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          return this;
        }
        
        public final a clearDisplayName()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.Chat.getDefaultInstance().getDisplayName();
          onChanged();
          return this;
        }
        
        public final a clearId()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.Chat.getDefaultInstance().getId();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.Message.Chat getDefaultInstanceForType()
        {
          return E2E.Message.Chat.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.I();
        }
        
        public final String getDisplayName()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getDisplayNameBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getId()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getIdBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasDisplayName()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasId()
        {
          return (this.a & 0x2) == 2;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.J().a(E2E.Message.Chat.class, a.class);
        }
        
        public final a setDisplayName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setDisplayNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final a setId(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setIdBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class ContactMessage
      extends o
      implements f.a
    {
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int DISPLAY_NAME_FIELD_NUMBER = 1;
      public static ae<ContactMessage> PARSER = new c()
      {
        private static E2E.Message.ContactMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.ContactMessage.a locala = E2E.Message.ContactMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int VCARD_FIELD_NUMBER = 16;
      private static final ContactMessage defaultInstance;
      private int bitField0_;
      private E2E.ContextInfo contextInfo_;
      private Object displayName_;
      private final an unknownFields;
      private Object vcard_;
      
      static
      {
        ContactMessage localContactMessage = new ContactMessage(true);
        defaultInstance = localContactMessage;
        localContactMessage.initFields();
      }
      
      private ContactMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private ContactMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static ContactMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.g();
      }
      
      private void initFields()
      {
        this.displayName_ = "";
        this.vcard_ = "";
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(ContactMessage paramContactMessage)
      {
        return (a)newBuilder().mergeFrom(paramContactMessage);
      }
      
      public static ContactMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (ContactMessage)PARSER.a(paramInputStream);
      }
      
      public static ContactMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (ContactMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static ContactMessage parseFrom(e parame)
      {
        return (ContactMessage)PARSER.a(parame);
      }
      
      public static ContactMessage parseFrom(e parame, m paramm)
      {
        return (ContactMessage)PARSER.a(parame, paramm);
      }
      
      public static ContactMessage parseFrom(f paramf)
      {
        return (ContactMessage)PARSER.a(paramf);
      }
      
      public static ContactMessage parseFrom(f paramf, m paramm)
      {
        return (ContactMessage)PARSER.a(paramf, paramm);
      }
      
      public static ContactMessage parseFrom(InputStream paramInputStream)
      {
        return (ContactMessage)PARSER.b(paramInputStream);
      }
      
      public static ContactMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (ContactMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static ContactMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (ContactMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static ContactMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (ContactMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final ContactMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getDisplayName()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.displayName_ = str;
        }
        return str;
      }
      
      public final e getDisplayNameBytes()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.displayName_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<ContactMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getVcard()
      {
        Object localObject = this.vcard_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.vcard_ = str;
        }
        return str;
      }
      
      public final e getVcardBytes()
      {
        Object localObject = this.vcard_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.vcard_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasDisplayName()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasVcard()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.h().a(ContactMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private E2E.ContextInfo d = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> e;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.ContactMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.e == null)
          {
            this.e = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.d = null;
          }
          return this.e;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.g();
        }
        
        public final E2E.Message.ContactMessage build()
        {
          E2E.Message.ContactMessage localContactMessage = buildPartial();
          if (!localContactMessage.isInitialized()) {
            throw newUninitializedMessageException(localContactMessage);
          }
          return localContactMessage;
        }
        
        public final E2E.Message.ContactMessage buildPartial()
        {
          int i = 1;
          E2E.Message.ContactMessage localContactMessage = new E2E.Message.ContactMessage(this, null);
          int k = this.a;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.ContactMessage.access$3502(localContactMessage, this.b);
            int j = i;
            if ((k & 0x2) == 2) {
              j = i | 0x2;
            }
            E2E.Message.ContactMessage.access$3602(localContactMessage, this.c);
            if ((k & 0x4) == 4) {}
            for (i = j | 0x4;; i = j)
            {
              if (this.e == null) {
                E2E.Message.ContactMessage.access$3702(localContactMessage, this.d);
              }
              for (;;)
              {
                E2E.Message.ContactMessage.access$3802(localContactMessage, i);
                onBuilt();
                return localContactMessage;
                E2E.Message.ContactMessage.access$3702(localContactMessage, (E2E.ContextInfo)this.e.c());
              }
            }
            i = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          if (this.e == null) {
            this.d = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFB;
            return this;
            this.e.f();
          }
        }
        
        public final a clearContextInfo()
        {
          if (this.e == null)
          {
            this.d = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFB;
            return this;
            this.e.f();
          }
        }
        
        public final a clearDisplayName()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.ContactMessage.getDefaultInstance().getDisplayName();
          onChanged();
          return this;
        }
        
        public final a clearVcard()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.ContactMessage.getDefaultInstance().getVcard();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.e == null) {
            return this.d;
          }
          return (E2E.ContextInfo)this.e.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x4;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.e != null) {
            return (f.a)this.e.e();
          }
          return this.d;
        }
        
        public final E2E.Message.ContactMessage getDefaultInstanceForType()
        {
          return E2E.Message.ContactMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.g();
        }
        
        public final String getDisplayName()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getDisplayNameBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getVcard()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getVcardBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasDisplayName()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasVcard()
        {
          return (this.a & 0x2) == 2;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.h().a(E2E.Message.ContactMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.e == null) {
            if (((this.a & 0x4) == 4) && (this.d != E2E.ContextInfo.getDefaultInstance()))
            {
              this.d = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.d).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.d = paramContextInfo;
            break;
            this.e.b(paramContextInfo);
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.e == null)
          {
            this.d = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.e.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.e == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.d = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.e.a(paramContextInfo);
          }
        }
        
        public final a setDisplayName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setDisplayNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final a setVcard(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setVcardBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class ContactsArrayMessage
      extends o
      implements f.a
    {
      public static final int CONTACTS_FIELD_NUMBER = 2;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int DISPLAY_NAME_FIELD_NUMBER = 1;
      public static ae<ContactsArrayMessage> PARSER = new c()
      {
        private static E2E.Message.ContactsArrayMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.ContactsArrayMessage.a locala = E2E.Message.ContactsArrayMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      private static final ContactsArrayMessage defaultInstance;
      private int bitField0_;
      private List<E2E.Message.ContactMessage> contacts_;
      private E2E.ContextInfo contextInfo_;
      private Object displayName_;
      private final an unknownFields;
      
      static
      {
        ContactsArrayMessage localContactsArrayMessage = new ContactsArrayMessage(true);
        defaultInstance = localContactsArrayMessage;
        localContactsArrayMessage.initFields();
      }
      
      private ContactsArrayMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private ContactsArrayMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static ContactsArrayMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.M();
      }
      
      private void initFields()
      {
        this.displayName_ = "";
        this.contacts_ = Collections.emptyList();
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(ContactsArrayMessage paramContactsArrayMessage)
      {
        return (a)newBuilder().mergeFrom(paramContactsArrayMessage);
      }
      
      public static ContactsArrayMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (ContactsArrayMessage)PARSER.a(paramInputStream);
      }
      
      public static ContactsArrayMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (ContactsArrayMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static ContactsArrayMessage parseFrom(e parame)
      {
        return (ContactsArrayMessage)PARSER.a(parame);
      }
      
      public static ContactsArrayMessage parseFrom(e parame, m paramm)
      {
        return (ContactsArrayMessage)PARSER.a(parame, paramm);
      }
      
      public static ContactsArrayMessage parseFrom(f paramf)
      {
        return (ContactsArrayMessage)PARSER.a(paramf);
      }
      
      public static ContactsArrayMessage parseFrom(f paramf, m paramm)
      {
        return (ContactsArrayMessage)PARSER.a(paramf, paramm);
      }
      
      public static ContactsArrayMessage parseFrom(InputStream paramInputStream)
      {
        return (ContactsArrayMessage)PARSER.b(paramInputStream);
      }
      
      public static ContactsArrayMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (ContactsArrayMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static ContactsArrayMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (ContactsArrayMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static ContactsArrayMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (ContactsArrayMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final E2E.Message.ContactMessage getContacts(int paramInt)
      {
        return (E2E.Message.ContactMessage)this.contacts_.get(paramInt);
      }
      
      public final int getContactsCount()
      {
        return this.contacts_.size();
      }
      
      public final List<E2E.Message.ContactMessage> getContactsList()
      {
        return this.contacts_;
      }
      
      public final f.a getContactsOrBuilder$1d5fdd9b$70c9c44e$244156ca(int paramInt)
      {
        return (f.a)this.contacts_.get(paramInt);
      }
      
      public final List<? extends f.a> getContactsOrBuilderList()
      {
        return this.contacts_;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final ContactsArrayMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getDisplayName()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.displayName_ = str;
        }
        return str;
      }
      
      public final e getDisplayNameBytes()
      {
        Object localObject = this.displayName_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.displayName_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<ContactsArrayMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasDisplayName()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.N().a(ContactsArrayMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private List<E2E.Message.ContactMessage> c = Collections.emptyList();
        private ah<E2E.Message.ContactMessage, E2E.Message.ContactMessage.a, f.a> d;
        private E2E.ContextInfo e = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> h;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.ContactsArrayMessage.alwaysUseFieldBuilders)
          {
            d();
            f();
          }
        }
        
        private void c()
        {
          if ((this.a & 0x2) != 2)
          {
            this.c = new ArrayList(this.c);
            this.a |= 0x2;
          }
        }
        
        private ah<E2E.Message.ContactMessage, E2E.Message.ContactMessage.a, f.a> d()
        {
          List localList;
          if (this.d == null)
          {
            localList = this.c;
            if ((this.a & 0x2) != 2) {
              break label55;
            }
          }
          label55:
          for (boolean bool = true;; bool = false)
          {
            this.d = new ah(localList, bool, getParentForChildren(), this.g);
            this.c = null;
            return this.d;
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> f()
        {
          if (this.h == null)
          {
            this.h = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.e = null;
          }
          return this.h;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.M();
        }
        
        public final a addAllContacts(Iterable<? extends E2E.Message.ContactMessage> paramIterable)
        {
          if (this.d == null)
          {
            c();
            b.a.addAll(paramIterable, this.c);
            onChanged();
            return this;
          }
          this.d.a(paramIterable);
          return this;
        }
        
        public final a addContacts(int paramInt, E2E.Message.ContactMessage.a parama)
        {
          if (this.d == null)
          {
            c();
            this.c.add(paramInt, parama.build());
            onChanged();
            return this;
          }
          this.d.b(paramInt, parama.build());
          return this;
        }
        
        public final a addContacts(int paramInt, E2E.Message.ContactMessage paramContactMessage)
        {
          if (this.d == null)
          {
            if (paramContactMessage == null) {
              throw new NullPointerException();
            }
            c();
            this.c.add(paramInt, paramContactMessage);
            onChanged();
            return this;
          }
          this.d.b(paramInt, paramContactMessage);
          return this;
        }
        
        public final a addContacts(E2E.Message.ContactMessage.a parama)
        {
          if (this.d == null)
          {
            c();
            this.c.add(parama.build());
            onChanged();
            return this;
          }
          this.d.a(parama.build());
          return this;
        }
        
        public final a addContacts(E2E.Message.ContactMessage paramContactMessage)
        {
          if (this.d == null)
          {
            if (paramContactMessage == null) {
              throw new NullPointerException();
            }
            c();
            this.c.add(paramContactMessage);
            onChanged();
            return this;
          }
          this.d.a(paramContactMessage);
          return this;
        }
        
        public final E2E.Message.ContactMessage.a addContactsBuilder()
        {
          return (E2E.Message.ContactMessage.a)d().b(E2E.Message.ContactMessage.getDefaultInstance());
        }
        
        public final E2E.Message.ContactMessage.a addContactsBuilder(int paramInt)
        {
          return (E2E.Message.ContactMessage.a)d().c(paramInt, E2E.Message.ContactMessage.getDefaultInstance());
        }
        
        public final E2E.Message.ContactsArrayMessage build()
        {
          E2E.Message.ContactsArrayMessage localContactsArrayMessage = buildPartial();
          if (!localContactsArrayMessage.isInitialized()) {
            throw newUninitializedMessageException(localContactsArrayMessage);
          }
          return localContactsArrayMessage;
        }
        
        public final E2E.Message.ContactsArrayMessage buildPartial()
        {
          int i = 1;
          E2E.Message.ContactsArrayMessage localContactsArrayMessage = new E2E.Message.ContactsArrayMessage(this, null);
          int j = this.a;
          if ((j & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.ContactsArrayMessage.access$23802(localContactsArrayMessage, this.b);
            if (this.d == null)
            {
              if ((this.a & 0x2) == 2)
              {
                this.c = Collections.unmodifiableList(this.c);
                this.a &= 0xFFFFFFFD;
              }
              E2E.Message.ContactsArrayMessage.access$23902(localContactsArrayMessage, this.c);
              if ((j & 0x4) != 4) {
                break label153;
              }
              i |= 0x2;
            }
            label153:
            for (;;)
            {
              if (this.h == null) {
                E2E.Message.ContactsArrayMessage.access$24002(localContactsArrayMessage, this.e);
              }
              for (;;)
              {
                E2E.Message.ContactsArrayMessage.access$24102(localContactsArrayMessage, i);
                onBuilt();
                return localContactsArrayMessage;
                E2E.Message.ContactsArrayMessage.access$23902(localContactsArrayMessage, this.d.e());
                break;
                E2E.Message.ContactsArrayMessage.access$24002(localContactsArrayMessage, (E2E.ContextInfo)this.h.c());
              }
            }
            i = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          if (this.d == null)
          {
            this.c = Collections.emptyList();
            this.a &= 0xFFFFFFFD;
            if (this.h != null) {
              break label84;
            }
            this.e = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFB;
            return this;
            this.d.d();
            break;
            label84:
            this.h.f();
          }
        }
        
        public final a clearContacts()
        {
          if (this.d == null)
          {
            this.c = Collections.emptyList();
            this.a &= 0xFFFFFFFD;
            onChanged();
            return this;
          }
          this.d.d();
          return this;
        }
        
        public final a clearContextInfo()
        {
          if (this.h == null)
          {
            this.e = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFB;
            return this;
            this.h.f();
          }
        }
        
        public final a clearDisplayName()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.ContactsArrayMessage.getDefaultInstance().getDisplayName();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.Message.ContactMessage getContacts(int paramInt)
        {
          if (this.d == null) {
            return (E2E.Message.ContactMessage)this.c.get(paramInt);
          }
          return (E2E.Message.ContactMessage)this.d.a(paramInt, false);
        }
        
        public final E2E.Message.ContactMessage.a getContactsBuilder(int paramInt)
        {
          return (E2E.Message.ContactMessage.a)d().a(paramInt);
        }
        
        public final List<E2E.Message.ContactMessage.a> getContactsBuilderList()
        {
          return d().g();
        }
        
        public final int getContactsCount()
        {
          if (this.d == null) {
            return this.c.size();
          }
          return this.d.b();
        }
        
        public final List<E2E.Message.ContactMessage> getContactsList()
        {
          if (this.d == null) {
            return Collections.unmodifiableList(this.c);
          }
          return this.d.f();
        }
        
        public final f.a getContactsOrBuilder$1d5fdd9b$70c9c44e$244156ca(int paramInt)
        {
          if (this.d == null) {
            return (f.a)this.c.get(paramInt);
          }
          return (f.a)this.d.b(paramInt);
        }
        
        public final List<? extends f.a> getContactsOrBuilderList()
        {
          if (this.d != null) {
            return this.d.h();
          }
          return Collections.unmodifiableList(this.c);
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.h == null) {
            return this.e;
          }
          return (E2E.ContextInfo)this.h.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x4;
          onChanged();
          return (E2E.ContextInfo.a)f().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.h != null) {
            return (f.a)this.h.e();
          }
          return this.e;
        }
        
        public final E2E.Message.ContactsArrayMessage getDefaultInstanceForType()
        {
          return E2E.Message.ContactsArrayMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.M();
        }
        
        public final String getDisplayName()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getDisplayNameBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasDisplayName()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.N().a(E2E.Message.ContactsArrayMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.h == null) {
            if (((this.a & 0x4) == 4) && (this.e != E2E.ContextInfo.getDefaultInstance()))
            {
              this.e = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.e).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.e = paramContextInfo;
            break;
            this.h.b(paramContextInfo);
          }
        }
        
        public final a removeContacts(int paramInt)
        {
          if (this.d == null)
          {
            c();
            this.c.remove(paramInt);
            onChanged();
            return this;
          }
          this.d.c(paramInt);
          return this;
        }
        
        public final a setContacts(int paramInt, E2E.Message.ContactMessage.a parama)
        {
          if (this.d == null)
          {
            c();
            this.c.set(paramInt, parama.build());
            onChanged();
            return this;
          }
          this.d.a(paramInt, parama.build());
          return this;
        }
        
        public final a setContacts(int paramInt, E2E.Message.ContactMessage paramContactMessage)
        {
          if (this.d == null)
          {
            if (paramContactMessage == null) {
              throw new NullPointerException();
            }
            c();
            this.c.set(paramInt, paramContactMessage);
            onChanged();
            return this;
          }
          this.d.a(paramInt, paramContactMessage);
          return this;
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.h == null)
          {
            this.e = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.h.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.h == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.e = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x4;
            return this;
            this.h.a(paramContextInfo);
          }
        }
        
        public final a setDisplayName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setDisplayNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class DocumentMessage
      extends o
      implements f.a
    {
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int FILE_ENC_SHA256_FIELD_NUMBER = 9;
      public static final int FILE_LENGTH_FIELD_NUMBER = 5;
      public static final int FILE_NAME_FIELD_NUMBER = 8;
      public static final int FILE_SHA256_FIELD_NUMBER = 4;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static final int MEDIA_KEY_FIELD_NUMBER = 7;
      public static final int MIMETYPE_FIELD_NUMBER = 2;
      public static final int PAGE_COUNT_FIELD_NUMBER = 6;
      public static ae<DocumentMessage> PARSER = new c()
      {
        private static E2E.Message.DocumentMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.DocumentMessage.a locala = E2E.Message.DocumentMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int TITLE_FIELD_NUMBER = 3;
      public static final int URL_FIELD_NUMBER = 1;
      private static final DocumentMessage defaultInstance;
      private int bitField0_;
      private E2E.ContextInfo contextInfo_;
      private e fileEncSha256_;
      private long fileLength_;
      private Object fileName_;
      private e fileSha256_;
      private e jpegThumbnail_;
      private e mediaKey_;
      private Object mimetype_;
      private int pageCount_;
      private Object title_;
      private final an unknownFields;
      private Object url_;
      
      static
      {
        DocumentMessage localDocumentMessage = new DocumentMessage(true);
        defaultInstance = localDocumentMessage;
        localDocumentMessage.initFields();
      }
      
      private DocumentMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private DocumentMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static DocumentMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.o();
      }
      
      private void initFields()
      {
        this.url_ = "";
        this.mimetype_ = "";
        this.title_ = "";
        this.fileSha256_ = e.b;
        this.fileLength_ = 0L;
        this.pageCount_ = 0;
        this.mediaKey_ = e.b;
        this.fileName_ = "";
        this.fileEncSha256_ = e.b;
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(DocumentMessage paramDocumentMessage)
      {
        return (a)newBuilder().mergeFrom(paramDocumentMessage);
      }
      
      public static DocumentMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (DocumentMessage)PARSER.a(paramInputStream);
      }
      
      public static DocumentMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (DocumentMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static DocumentMessage parseFrom(e parame)
      {
        return (DocumentMessage)PARSER.a(parame);
      }
      
      public static DocumentMessage parseFrom(e parame, m paramm)
      {
        return (DocumentMessage)PARSER.a(parame, paramm);
      }
      
      public static DocumentMessage parseFrom(f paramf)
      {
        return (DocumentMessage)PARSER.a(paramf);
      }
      
      public static DocumentMessage parseFrom(f paramf, m paramm)
      {
        return (DocumentMessage)PARSER.a(paramf, paramm);
      }
      
      public static DocumentMessage parseFrom(InputStream paramInputStream)
      {
        return (DocumentMessage)PARSER.b(paramInputStream);
      }
      
      public static DocumentMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (DocumentMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static DocumentMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (DocumentMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static DocumentMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (DocumentMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final DocumentMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final e getFileEncSha256()
      {
        return this.fileEncSha256_;
      }
      
      public final long getFileLength()
      {
        return this.fileLength_;
      }
      
      public final String getFileName()
      {
        Object localObject = this.fileName_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.fileName_ = str;
        }
        return str;
      }
      
      public final e getFileNameBytes()
      {
        Object localObject = this.fileName_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.fileName_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final e getFileSha256()
      {
        return this.fileSha256_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final e getMediaKey()
      {
        return this.mediaKey_;
      }
      
      public final String getMimetype()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.mimetype_ = str;
        }
        return str;
      }
      
      public final e getMimetypeBytes()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.mimetype_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final int getPageCount()
      {
        return this.pageCount_;
      }
      
      public final ae<DocumentMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final String getTitle()
      {
        Object localObject = this.title_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.title_ = str;
        }
        return str;
      }
      
      public final e getTitleBytes()
      {
        Object localObject = this.title_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.title_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getUrl()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.url_ = str;
        }
        return str;
      }
      
      public final e getUrlBytes()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.url_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x400) == 1024;
      }
      
      public final boolean hasFileEncSha256()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasFileLength()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final boolean hasFileName()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasFileSha256()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      public final boolean hasMediaKey()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasMimetype()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasPageCount()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasTitle()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasUrl()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.p().a(DocumentMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private Object d = "";
        private e e = e.b;
        private long h;
        private int i;
        private e j = e.b;
        private Object k = "";
        private e l = e.b;
        private e m = e.b;
        private E2E.ContextInfo n = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> o;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.DocumentMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.o == null)
          {
            this.o = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.n = null;
          }
          return this.o;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.o();
        }
        
        public final E2E.Message.DocumentMessage build()
        {
          E2E.Message.DocumentMessage localDocumentMessage = buildPartial();
          if (!localDocumentMessage.isInitialized()) {
            throw newUninitializedMessageException(localDocumentMessage);
          }
          return localDocumentMessage;
        }
        
        public final E2E.Message.DocumentMessage buildPartial()
        {
          int i2 = 1;
          E2E.Message.DocumentMessage localDocumentMessage = new E2E.Message.DocumentMessage(this, null);
          int i3 = this.a;
          if ((i3 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.DocumentMessage.access$9202(localDocumentMessage, this.b);
            int i1 = i2;
            if ((i3 & 0x2) == 2) {
              i1 = i2 | 0x2;
            }
            E2E.Message.DocumentMessage.access$9302(localDocumentMessage, this.c);
            i2 = i1;
            if ((i3 & 0x4) == 4) {
              i2 = i1 | 0x4;
            }
            E2E.Message.DocumentMessage.access$9402(localDocumentMessage, this.d);
            i1 = i2;
            if ((i3 & 0x8) == 8) {
              i1 = i2 | 0x8;
            }
            E2E.Message.DocumentMessage.access$9502(localDocumentMessage, this.e);
            i2 = i1;
            if ((i3 & 0x10) == 16) {
              i2 = i1 | 0x10;
            }
            E2E.Message.DocumentMessage.access$9602(localDocumentMessage, this.h);
            i1 = i2;
            if ((i3 & 0x20) == 32) {
              i1 = i2 | 0x20;
            }
            E2E.Message.DocumentMessage.access$9702(localDocumentMessage, this.i);
            i2 = i1;
            if ((i3 & 0x40) == 64) {
              i2 = i1 | 0x40;
            }
            E2E.Message.DocumentMessage.access$9802(localDocumentMessage, this.j);
            i1 = i2;
            if ((i3 & 0x80) == 128) {
              i1 = i2 | 0x80;
            }
            E2E.Message.DocumentMessage.access$9902(localDocumentMessage, this.k);
            i2 = i1;
            if ((i3 & 0x100) == 256) {
              i2 = i1 | 0x100;
            }
            E2E.Message.DocumentMessage.access$10002(localDocumentMessage, this.l);
            i1 = i2;
            if ((i3 & 0x200) == 512) {
              i1 = i2 | 0x200;
            }
            E2E.Message.DocumentMessage.access$10102(localDocumentMessage, this.m);
            if ((i3 & 0x400) == 1024) {
              i1 |= 0x400;
            }
            for (;;)
            {
              if (this.o == null) {
                E2E.Message.DocumentMessage.access$10202(localDocumentMessage, this.n);
              }
              for (;;)
              {
                E2E.Message.DocumentMessage.access$10302(localDocumentMessage, i1);
                onBuilt();
                return localDocumentMessage;
                E2E.Message.DocumentMessage.access$10202(localDocumentMessage, (E2E.ContextInfo)this.o.c());
              }
            }
            i2 = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = "";
          this.a &= 0xFFFFFFFB;
          this.e = e.b;
          this.a &= 0xFFFFFFF7;
          this.h = 0L;
          this.a &= 0xFFFFFFEF;
          this.i = 0;
          this.a &= 0xFFFFFFDF;
          this.j = e.b;
          this.a &= 0xFFFFFFBF;
          this.k = "";
          this.a &= 0xFF7F;
          this.l = e.b;
          this.a &= 0xFEFF;
          this.m = e.b;
          this.a &= 0xFDFF;
          if (this.o == null) {
            this.n = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFBFF;
            return this;
            this.o.f();
          }
        }
        
        public final a clearContextInfo()
        {
          if (this.o == null)
          {
            this.n = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFBFF;
            return this;
            this.o.f();
          }
        }
        
        public final a clearFileEncSha256()
        {
          this.a &= 0xFEFF;
          this.l = E2E.Message.DocumentMessage.getDefaultInstance().getFileEncSha256();
          onChanged();
          return this;
        }
        
        public final a clearFileLength()
        {
          this.a &= 0xFFFFFFEF;
          this.h = 0L;
          onChanged();
          return this;
        }
        
        public final a clearFileName()
        {
          this.a &= 0xFF7F;
          this.k = E2E.Message.DocumentMessage.getDefaultInstance().getFileName();
          onChanged();
          return this;
        }
        
        public final a clearFileSha256()
        {
          this.a &= 0xFFFFFFF7;
          this.e = E2E.Message.DocumentMessage.getDefaultInstance().getFileSha256();
          onChanged();
          return this;
        }
        
        public final a clearJpegThumbnail()
        {
          this.a &= 0xFDFF;
          this.m = E2E.Message.DocumentMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final a clearMediaKey()
        {
          this.a &= 0xFFFFFFBF;
          this.j = E2E.Message.DocumentMessage.getDefaultInstance().getMediaKey();
          onChanged();
          return this;
        }
        
        public final a clearMimetype()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.DocumentMessage.getDefaultInstance().getMimetype();
          onChanged();
          return this;
        }
        
        public final a clearPageCount()
        {
          this.a &= 0xFFFFFFDF;
          this.i = 0;
          onChanged();
          return this;
        }
        
        public final a clearTitle()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.DocumentMessage.getDefaultInstance().getTitle();
          onChanged();
          return this;
        }
        
        public final a clearUrl()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.DocumentMessage.getDefaultInstance().getUrl();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.o == null) {
            return this.n;
          }
          return (E2E.ContextInfo)this.o.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x400;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.o != null) {
            return (f.a)this.o.e();
          }
          return this.n;
        }
        
        public final E2E.Message.DocumentMessage getDefaultInstanceForType()
        {
          return E2E.Message.DocumentMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.o();
        }
        
        public final e getFileEncSha256()
        {
          return this.l;
        }
        
        public final long getFileLength()
        {
          return this.h;
        }
        
        public final String getFileName()
        {
          Object localObject = this.k;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.k = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getFileNameBytes()
        {
          Object localObject = this.k;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.k = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final e getFileSha256()
        {
          return this.e;
        }
        
        public final e getJpegThumbnail()
        {
          return this.m;
        }
        
        public final e getMediaKey()
        {
          return this.j;
        }
        
        public final String getMimetype()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getMimetypeBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final int getPageCount()
        {
          return this.i;
        }
        
        public final String getTitle()
        {
          Object localObject = this.d;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.d = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getTitleBytes()
        {
          Object localObject = this.d;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.d = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getUrl()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getUrlBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x400) == 1024;
        }
        
        public final boolean hasFileEncSha256()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasFileLength()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasFileName()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasFileSha256()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x200) == 512;
        }
        
        public final boolean hasMediaKey()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasMimetype()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasPageCount()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasTitle()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasUrl()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.p().a(E2E.Message.DocumentMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.o == null) {
            if (((this.a & 0x400) == 1024) && (this.n != E2E.ContextInfo.getDefaultInstance()))
            {
              this.n = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.n).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.n = paramContextInfo;
            break;
            this.o.b(paramContextInfo);
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.o == null)
          {
            this.n = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.o.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.o == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.n = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.o.a(paramContextInfo);
          }
        }
        
        public final a setFileEncSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x100;
          this.l = parame;
          onChanged();
          return this;
        }
        
        public final a setFileLength(long paramLong)
        {
          this.a |= 0x10;
          this.h = paramLong;
          onChanged();
          return this;
        }
        
        public final a setFileName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = paramString;
          onChanged();
          return this;
        }
        
        public final a setFileNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = parame;
          onChanged();
          return this;
        }
        
        public final a setFileSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = parame;
          onChanged();
          return this;
        }
        
        public final a setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x200;
          this.m = parame;
          onChanged();
          return this;
        }
        
        public final a setMediaKey(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x40;
          this.j = parame;
          onChanged();
          return this;
        }
        
        public final a setMimetype(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setMimetypeBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setPageCount(int paramInt)
        {
          this.a |= 0x20;
          this.i = paramInt;
          onChanged();
          return this;
        }
        
        public final a setTitle(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = paramString;
          onChanged();
          return this;
        }
        
        public final a setTitleBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final a setUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class ExtendedTextMessage
      extends o
      implements f.a
    {
      public static final int BACKGROUND_ARGB_FIELD_NUMBER = 8;
      public static final int CANONICAL_URL_FIELD_NUMBER = 4;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int DESCRIPTION_FIELD_NUMBER = 5;
      public static final int FONT_FIELD_NUMBER = 9;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static final int MATCHED_TEXT_FIELD_NUMBER = 2;
      public static ae<ExtendedTextMessage> PARSER = new c()
      {
        private static E2E.Message.ExtendedTextMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.ExtendedTextMessage.a locala = E2E.Message.ExtendedTextMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int TEXT_ARGB_FIELD_NUMBER = 7;
      public static final int TEXT_FIELD_NUMBER = 1;
      public static final int TITLE_FIELD_NUMBER = 6;
      private static final ExtendedTextMessage defaultInstance;
      private int backgroundArgb_;
      private int bitField0_;
      private Object canonicalUrl_;
      private E2E.ContextInfo contextInfo_;
      private Object description_;
      private b font_;
      private e jpegThumbnail_;
      private Object matchedText_;
      private int textArgb_;
      private Object text_;
      private Object title_;
      private final an unknownFields;
      
      static
      {
        ExtendedTextMessage localExtendedTextMessage = new ExtendedTextMessage(true);
        defaultInstance = localExtendedTextMessage;
        localExtendedTextMessage.initFields();
      }
      
      private ExtendedTextMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private ExtendedTextMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static ExtendedTextMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.m();
      }
      
      private void initFields()
      {
        this.text_ = "";
        this.matchedText_ = "";
        this.canonicalUrl_ = "";
        this.description_ = "";
        this.title_ = "";
        this.textArgb_ = 0;
        this.backgroundArgb_ = 0;
        this.font_ = b.a;
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(ExtendedTextMessage paramExtendedTextMessage)
      {
        return (a)newBuilder().mergeFrom(paramExtendedTextMessage);
      }
      
      public static ExtendedTextMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (ExtendedTextMessage)PARSER.a(paramInputStream);
      }
      
      public static ExtendedTextMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (ExtendedTextMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static ExtendedTextMessage parseFrom(e parame)
      {
        return (ExtendedTextMessage)PARSER.a(parame);
      }
      
      public static ExtendedTextMessage parseFrom(e parame, m paramm)
      {
        return (ExtendedTextMessage)PARSER.a(parame, paramm);
      }
      
      public static ExtendedTextMessage parseFrom(f paramf)
      {
        return (ExtendedTextMessage)PARSER.a(paramf);
      }
      
      public static ExtendedTextMessage parseFrom(f paramf, m paramm)
      {
        return (ExtendedTextMessage)PARSER.a(paramf, paramm);
      }
      
      public static ExtendedTextMessage parseFrom(InputStream paramInputStream)
      {
        return (ExtendedTextMessage)PARSER.b(paramInputStream);
      }
      
      public static ExtendedTextMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (ExtendedTextMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static ExtendedTextMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (ExtendedTextMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static ExtendedTextMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (ExtendedTextMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final int getBackgroundArgb()
      {
        return this.backgroundArgb_;
      }
      
      public final String getCanonicalUrl()
      {
        Object localObject = this.canonicalUrl_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.canonicalUrl_ = str;
        }
        return str;
      }
      
      public final e getCanonicalUrlBytes()
      {
        Object localObject = this.canonicalUrl_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.canonicalUrl_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final ExtendedTextMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getDescription()
      {
        Object localObject = this.description_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.description_ = str;
        }
        return str;
      }
      
      public final e getDescriptionBytes()
      {
        Object localObject = this.description_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.description_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final b getFont()
      {
        return this.font_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final String getMatchedText()
      {
        Object localObject = this.matchedText_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.matchedText_ = str;
        }
        return str;
      }
      
      public final e getMatchedTextBytes()
      {
        Object localObject = this.matchedText_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.matchedText_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<ExtendedTextMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final String getText()
      {
        Object localObject = this.text_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.text_ = str;
        }
        return str;
      }
      
      public final int getTextArgb()
      {
        return this.textArgb_;
      }
      
      public final e getTextBytes()
      {
        Object localObject = this.text_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.text_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final String getTitle()
      {
        Object localObject = this.title_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.title_ = str;
        }
        return str;
      }
      
      public final e getTitleBytes()
      {
        Object localObject = this.title_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.title_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasBackgroundArgb()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasCanonicalUrl()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      public final boolean hasDescription()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasFont()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasMatchedText()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasText()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasTextArgb()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasTitle()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.n().a(ExtendedTextMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private Object d = "";
        private Object e = "";
        private Object h = "";
        private int i;
        private int j;
        private E2E.Message.ExtendedTextMessage.b k = E2E.Message.ExtendedTextMessage.b.a;
        private e l = e.b;
        private E2E.ContextInfo m = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> n;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.ExtendedTextMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.n == null)
          {
            this.n = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.m = null;
          }
          return this.n;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.m();
        }
        
        public final E2E.Message.ExtendedTextMessage build()
        {
          E2E.Message.ExtendedTextMessage localExtendedTextMessage = buildPartial();
          if (!localExtendedTextMessage.isInitialized()) {
            throw newUninitializedMessageException(localExtendedTextMessage);
          }
          return localExtendedTextMessage;
        }
        
        public final E2E.Message.ExtendedTextMessage buildPartial()
        {
          int i2 = 1;
          E2E.Message.ExtendedTextMessage localExtendedTextMessage = new E2E.Message.ExtendedTextMessage(this, null);
          int i3 = this.a;
          if ((i3 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.ExtendedTextMessage.access$7502(localExtendedTextMessage, this.b);
            int i1 = i2;
            if ((i3 & 0x2) == 2) {
              i1 = i2 | 0x2;
            }
            E2E.Message.ExtendedTextMessage.access$7602(localExtendedTextMessage, this.c);
            i2 = i1;
            if ((i3 & 0x4) == 4) {
              i2 = i1 | 0x4;
            }
            E2E.Message.ExtendedTextMessage.access$7702(localExtendedTextMessage, this.d);
            i1 = i2;
            if ((i3 & 0x8) == 8) {
              i1 = i2 | 0x8;
            }
            E2E.Message.ExtendedTextMessage.access$7802(localExtendedTextMessage, this.e);
            i2 = i1;
            if ((i3 & 0x10) == 16) {
              i2 = i1 | 0x10;
            }
            E2E.Message.ExtendedTextMessage.access$7902(localExtendedTextMessage, this.h);
            i1 = i2;
            if ((i3 & 0x20) == 32) {
              i1 = i2 | 0x20;
            }
            E2E.Message.ExtendedTextMessage.access$8002(localExtendedTextMessage, this.i);
            i2 = i1;
            if ((i3 & 0x40) == 64) {
              i2 = i1 | 0x40;
            }
            E2E.Message.ExtendedTextMessage.access$8102(localExtendedTextMessage, this.j);
            i1 = i2;
            if ((i3 & 0x80) == 128) {
              i1 = i2 | 0x80;
            }
            E2E.Message.ExtendedTextMessage.access$8202(localExtendedTextMessage, this.k);
            i2 = i1;
            if ((i3 & 0x100) == 256) {
              i2 = i1 | 0x100;
            }
            E2E.Message.ExtendedTextMessage.access$8302(localExtendedTextMessage, this.l);
            if ((i3 & 0x200) == 512) {}
            for (i1 = i2 | 0x200;; i1 = i2)
            {
              if (this.n == null) {
                E2E.Message.ExtendedTextMessage.access$8402(localExtendedTextMessage, this.m);
              }
              for (;;)
              {
                E2E.Message.ExtendedTextMessage.access$8502(localExtendedTextMessage, i1);
                onBuilt();
                return localExtendedTextMessage;
                E2E.Message.ExtendedTextMessage.access$8402(localExtendedTextMessage, (E2E.ContextInfo)this.n.c());
              }
            }
            i2 = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = "";
          this.a &= 0xFFFFFFFB;
          this.e = "";
          this.a &= 0xFFFFFFF7;
          this.h = "";
          this.a &= 0xFFFFFFEF;
          this.i = 0;
          this.a &= 0xFFFFFFDF;
          this.j = 0;
          this.a &= 0xFFFFFFBF;
          this.k = E2E.Message.ExtendedTextMessage.b.a;
          this.a &= 0xFF7F;
          this.l = e.b;
          this.a &= 0xFEFF;
          if (this.n == null) {
            this.m = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFDFF;
            return this;
            this.n.f();
          }
        }
        
        public final a clearBackgroundArgb()
        {
          this.a &= 0xFFFFFFBF;
          this.j = 0;
          onChanged();
          return this;
        }
        
        public final a clearCanonicalUrl()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.ExtendedTextMessage.getDefaultInstance().getCanonicalUrl();
          onChanged();
          return this;
        }
        
        public final a clearContextInfo()
        {
          if (this.n == null)
          {
            this.m = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFDFF;
            return this;
            this.n.f();
          }
        }
        
        public final a clearDescription()
        {
          this.a &= 0xFFFFFFF7;
          this.e = E2E.Message.ExtendedTextMessage.getDefaultInstance().getDescription();
          onChanged();
          return this;
        }
        
        public final a clearFont()
        {
          this.a &= 0xFF7F;
          this.k = E2E.Message.ExtendedTextMessage.b.a;
          onChanged();
          return this;
        }
        
        public final a clearJpegThumbnail()
        {
          this.a &= 0xFEFF;
          this.l = E2E.Message.ExtendedTextMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final a clearMatchedText()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.ExtendedTextMessage.getDefaultInstance().getMatchedText();
          onChanged();
          return this;
        }
        
        public final a clearText()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.ExtendedTextMessage.getDefaultInstance().getText();
          onChanged();
          return this;
        }
        
        public final a clearTextArgb()
        {
          this.a &= 0xFFFFFFDF;
          this.i = 0;
          onChanged();
          return this;
        }
        
        public final a clearTitle()
        {
          this.a &= 0xFFFFFFEF;
          this.h = E2E.Message.ExtendedTextMessage.getDefaultInstance().getTitle();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final int getBackgroundArgb()
        {
          return this.j;
        }
        
        public final String getCanonicalUrl()
        {
          Object localObject = this.d;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.d = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getCanonicalUrlBytes()
        {
          Object localObject = this.d;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.d = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.n == null) {
            return this.m;
          }
          return (E2E.ContextInfo)this.n.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x200;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.n != null) {
            return (f.a)this.n.e();
          }
          return this.m;
        }
        
        public final E2E.Message.ExtendedTextMessage getDefaultInstanceForType()
        {
          return E2E.Message.ExtendedTextMessage.getDefaultInstance();
        }
        
        public final String getDescription()
        {
          Object localObject = this.e;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.e = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getDescriptionBytes()
        {
          Object localObject = this.e;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.e = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.m();
        }
        
        public final E2E.Message.ExtendedTextMessage.b getFont()
        {
          return this.k;
        }
        
        public final e getJpegThumbnail()
        {
          return this.l;
        }
        
        public final String getMatchedText()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getMatchedTextBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getText()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final int getTextArgb()
        {
          return this.i;
        }
        
        public final e getTextBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getTitle()
        {
          Object localObject = this.h;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.h = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getTitleBytes()
        {
          Object localObject = this.h;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.h = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasBackgroundArgb()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasCanonicalUrl()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x200) == 512;
        }
        
        public final boolean hasDescription()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasFont()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasMatchedText()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasText()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasTextArgb()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasTitle()
        {
          return (this.a & 0x10) == 16;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.n().a(E2E.Message.ExtendedTextMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.n == null) {
            if (((this.a & 0x200) == 512) && (this.m != E2E.ContextInfo.getDefaultInstance()))
            {
              this.m = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.m).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x200;
            return this;
            this.m = paramContextInfo;
            break;
            this.n.b(paramContextInfo);
          }
        }
        
        public final a setBackgroundArgb(int paramInt)
        {
          this.a |= 0x40;
          this.j = paramInt;
          onChanged();
          return this;
        }
        
        public final a setCanonicalUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = paramString;
          onChanged();
          return this;
        }
        
        public final a setCanonicalUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.n == null)
          {
            this.m = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x200;
            return this;
            this.n.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.n == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.m = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x200;
            return this;
            this.n.a(paramContextInfo);
          }
        }
        
        public final a setDescription(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = paramString;
          onChanged();
          return this;
        }
        
        public final a setDescriptionBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = parame;
          onChanged();
          return this;
        }
        
        public final a setFont(E2E.Message.ExtendedTextMessage.b paramb)
        {
          if (paramb == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = paramb;
          onChanged();
          return this;
        }
        
        public final a setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x100;
          this.l = parame;
          onChanged();
          return this;
        }
        
        public final a setMatchedText(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setMatchedTextBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setText(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setTextArgb(int paramInt)
        {
          this.a |= 0x20;
          this.i = paramInt;
          onChanged();
          return this;
        }
        
        public final a setTextBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final a setTitle(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = paramString;
          onChanged();
          return this;
        }
        
        public final a setTitleBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = parame;
          onChanged();
          return this;
        }
      }
      
      public static enum b
        implements af
      {
        private static f.a<b> c = new f.a() {};
        private static final b[] d = values();
        private final int e;
        private final int f;
        
        private b(int paramInt1, int paramInt2)
        {
          this.e = paramInt1;
          this.f = paramInt2;
        }
        
        public static final i.d getDescriptor()
        {
          return (i.d)E2E.Message.ExtendedTextMessage.getDescriptor().g().get(0);
        }
        
        public static f.a<b> internalGetValueMap$332b5b32$1ec9fbcb$5f20f411()
        {
          return c;
        }
        
        public static b valueOf(int paramInt)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 0: 
            return a;
          }
          return b;
        }
        
        public static b valueOf(i.e parame)
        {
          if (parame.c != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
          }
          return d[parame.a];
        }
        
        public final i.d getDescriptorForType()
        {
          return getDescriptor();
        }
        
        public final int getNumber()
        {
          return this.f;
        }
        
        public final i.e getValueDescriptor()
        {
          return (i.e)getDescriptor().d().get(this.e);
        }
      }
    }
    
    public static final class HighlyStructuredMessage
      extends o
      implements f.a
    {
      public static final int ELEMENT_NAME_FIELD_NUMBER = 2;
      public static final int FALLBACK_LC_FIELD_NUMBER = 5;
      public static final int FALLBACK_LG_FIELD_NUMBER = 4;
      public static final int LOCALIZABLE_PARAMS_FIELD_NUMBER = 6;
      public static final int NAMESPACE_FIELD_NUMBER = 1;
      public static final int PARAMS_FIELD_NUMBER = 3;
      public static ae<HighlyStructuredMessage> PARSER = new c()
      {
        private static E2E.Message.HighlyStructuredMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.HighlyStructuredMessage.a locala = E2E.Message.HighlyStructuredMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      private static final HighlyStructuredMessage defaultInstance;
      private int bitField0_;
      private Object elementName_;
      private Object fallbackLc_;
      private Object fallbackLg_;
      private List<HSMLocalizableParameter> localizableParams_;
      private Object namespace_;
      private u params_;
      private final an unknownFields;
      
      static
      {
        HighlyStructuredMessage localHighlyStructuredMessage = new HighlyStructuredMessage(true);
        defaultInstance = localHighlyStructuredMessage;
        localHighlyStructuredMessage.initFields();
      }
      
      private HighlyStructuredMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private HighlyStructuredMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static HighlyStructuredMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.u();
      }
      
      private void initFields()
      {
        this.namespace_ = "";
        this.elementName_ = "";
        this.params_ = t.a;
        this.fallbackLg_ = "";
        this.fallbackLc_ = "";
        this.localizableParams_ = Collections.emptyList();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(HighlyStructuredMessage paramHighlyStructuredMessage)
      {
        return (a)newBuilder().mergeFrom(paramHighlyStructuredMessage);
      }
      
      public static HighlyStructuredMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (HighlyStructuredMessage)PARSER.a(paramInputStream);
      }
      
      public static HighlyStructuredMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (HighlyStructuredMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static HighlyStructuredMessage parseFrom(e parame)
      {
        return (HighlyStructuredMessage)PARSER.a(parame);
      }
      
      public static HighlyStructuredMessage parseFrom(e parame, m paramm)
      {
        return (HighlyStructuredMessage)PARSER.a(parame, paramm);
      }
      
      public static HighlyStructuredMessage parseFrom(f paramf)
      {
        return (HighlyStructuredMessage)PARSER.a(paramf);
      }
      
      public static HighlyStructuredMessage parseFrom(f paramf, m paramm)
      {
        return (HighlyStructuredMessage)PARSER.a(paramf, paramm);
      }
      
      public static HighlyStructuredMessage parseFrom(InputStream paramInputStream)
      {
        return (HighlyStructuredMessage)PARSER.b(paramInputStream);
      }
      
      public static HighlyStructuredMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (HighlyStructuredMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static HighlyStructuredMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (HighlyStructuredMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static HighlyStructuredMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (HighlyStructuredMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final HighlyStructuredMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getElementName()
      {
        Object localObject = this.elementName_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.elementName_ = str;
        }
        return str;
      }
      
      public final e getElementNameBytes()
      {
        Object localObject = this.elementName_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.elementName_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final String getFallbackLc()
      {
        Object localObject = this.fallbackLc_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.fallbackLc_ = str;
        }
        return str;
      }
      
      public final e getFallbackLcBytes()
      {
        Object localObject = this.fallbackLc_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.fallbackLc_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final String getFallbackLg()
      {
        Object localObject = this.fallbackLg_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.fallbackLg_ = str;
        }
        return str;
      }
      
      public final e getFallbackLgBytes()
      {
        Object localObject = this.fallbackLg_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.fallbackLg_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final HSMLocalizableParameter getLocalizableParams(int paramInt)
      {
        return (HSMLocalizableParameter)this.localizableParams_.get(paramInt);
      }
      
      public final int getLocalizableParamsCount()
      {
        return this.localizableParams_.size();
      }
      
      public final List<HSMLocalizableParameter> getLocalizableParamsList()
      {
        return this.localizableParams_;
      }
      
      public final f.a getLocalizableParamsOrBuilder$74891c00$70c9c44e$244156ca(int paramInt)
      {
        return (f.a)this.localizableParams_.get(paramInt);
      }
      
      public final List<? extends f.a> getLocalizableParamsOrBuilderList()
      {
        return this.localizableParams_;
      }
      
      public final String getNamespace()
      {
        Object localObject = this.namespace_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.namespace_ = str;
        }
        return str;
      }
      
      public final e getNamespaceBytes()
      {
        Object localObject = this.namespace_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.namespace_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final String getParams(int paramInt)
      {
        return (String)this.params_.get(paramInt);
      }
      
      public final e getParamsBytes(int paramInt)
      {
        return this.params_.a(paramInt);
      }
      
      public final int getParamsCount()
      {
        return this.params_.size();
      }
      
      public final ag getParamsList()
      {
        return this.params_;
      }
      
      public final ae<HighlyStructuredMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasElementName()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasFallbackLc()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasFallbackLg()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasNamespace()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.v().a(HighlyStructuredMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class HSMLocalizableParameter
        extends o
        implements f.a
      {
        public static final int CURRENCY_FIELD_NUMBER = 2;
        public static final int DATE_TIME_FIELD_NUMBER = 3;
        public static final int DEFAULT_FIELD_NUMBER = 1;
        public static ae<HSMLocalizableParameter> PARSER = new c()
        {
          private static E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter c(f paramAnonymousf, m paramAnonymousm)
          {
            E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a locala = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.newBuilder();
            try
            {
              locala.mergeFrom(paramAnonymousf, paramAnonymousm);
              return locala.buildPartial();
            }
            catch (q paramAnonymousf)
            {
              paramAnonymousf.a = locala.buildPartial();
              throw paramAnonymousf;
            }
            catch (IOException paramAnonymousf)
            {
              paramAnonymousf = new q(paramAnonymousf.getMessage());
              paramAnonymousf.a = locala.buildPartial();
              throw paramAnonymousf;
            }
          }
        };
        private static final HSMLocalizableParameter defaultInstance;
        private int bitField0_;
        private Object default_;
        private int paramOneofCase_ = 0;
        private Object paramOneof_;
        private final an unknownFields;
        
        static
        {
          HSMLocalizableParameter localHSMLocalizableParameter = new HSMLocalizableParameter(true);
          defaultInstance = localHSMLocalizableParameter;
          localHSMLocalizableParameter.initFields();
        }
        
        private HSMLocalizableParameter(o.a<?> parama)
        {
          super();
          this.unknownFields = parama.getUnknownFields();
        }
        
        private HSMLocalizableParameter(boolean paramBoolean)
        {
          this.unknownFields = an.b();
        }
        
        public static HSMLocalizableParameter getDefaultInstance()
        {
          return defaultInstance;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.w();
        }
        
        private void initFields()
        {
          this.default_ = "";
        }
        
        public static a newBuilder()
        {
          return a.a();
        }
        
        public static a newBuilder(HSMLocalizableParameter paramHSMLocalizableParameter)
        {
          return (a)newBuilder().mergeFrom(paramHSMLocalizableParameter);
        }
        
        public static HSMLocalizableParameter parseDelimitedFrom(InputStream paramInputStream)
        {
          return (HSMLocalizableParameter)PARSER.a(paramInputStream);
        }
        
        public static HSMLocalizableParameter parseDelimitedFrom(InputStream paramInputStream, m paramm)
        {
          return (HSMLocalizableParameter)PARSER.a(paramInputStream, paramm);
        }
        
        public static HSMLocalizableParameter parseFrom(e parame)
        {
          return (HSMLocalizableParameter)PARSER.a(parame);
        }
        
        public static HSMLocalizableParameter parseFrom(e parame, m paramm)
        {
          return (HSMLocalizableParameter)PARSER.a(parame, paramm);
        }
        
        public static HSMLocalizableParameter parseFrom(f paramf)
        {
          return (HSMLocalizableParameter)PARSER.a(paramf);
        }
        
        public static HSMLocalizableParameter parseFrom(f paramf, m paramm)
        {
          return (HSMLocalizableParameter)PARSER.a(paramf, paramm);
        }
        
        public static HSMLocalizableParameter parseFrom(InputStream paramInputStream)
        {
          return (HSMLocalizableParameter)PARSER.b(paramInputStream);
        }
        
        public static HSMLocalizableParameter parseFrom(InputStream paramInputStream, m paramm)
        {
          return (HSMLocalizableParameter)PARSER.b(paramInputStream, paramm);
        }
        
        public static HSMLocalizableParameter parseFrom(byte[] paramArrayOfByte)
        {
          return (HSMLocalizableParameter)PARSER.a(paramArrayOfByte);
        }
        
        public static HSMLocalizableParameter parseFrom(byte[] paramArrayOfByte, m paramm)
        {
          return (HSMLocalizableParameter)PARSER.a(paramArrayOfByte, paramm);
        }
        
        public final HSMCurrency getCurrency()
        {
          if (this.paramOneofCase_ == 2) {
            return (HSMCurrency)this.paramOneof_;
          }
          return HSMCurrency.getDefaultInstance();
        }
        
        public final f.a getCurrencyOrBuilder$353d03b6$1ec9fbcb$5f20f411()
        {
          if (this.paramOneofCase_ == 2) {
            return (HSMCurrency)this.paramOneof_;
          }
          return HSMCurrency.getDefaultInstance();
        }
        
        public final HSMDateTime getDateTime()
        {
          if (this.paramOneofCase_ == 3) {
            return (HSMDateTime)this.paramOneof_;
          }
          return HSMDateTime.getDefaultInstance();
        }
        
        public final f.a getDateTimeOrBuilder$1dae2140$1ec9fbcb$5f20f411()
        {
          if (this.paramOneofCase_ == 3) {
            return (HSMDateTime)this.paramOneof_;
          }
          return HSMDateTime.getDefaultInstance();
        }
        
        public final String getDefault()
        {
          Object localObject = this.default_;
          if ((localObject instanceof String)) {
            return (String)localObject;
          }
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.default_ = str;
          }
          return str;
        }
        
        public final e getDefaultBytes()
        {
          Object localObject = this.default_;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.default_ = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final HSMLocalizableParameter getDefaultInstanceForType()
        {
          return defaultInstance;
        }
        
        public final b getParamOneofCase()
        {
          return b.a(this.paramOneofCase_);
        }
        
        public final ae<HSMLocalizableParameter> getParserForType()
        {
          return PARSER;
        }
        
        public final an getUnknownFields()
        {
          return this.unknownFields;
        }
        
        public final boolean hasCurrency()
        {
          return this.paramOneofCase_ == 2;
        }
        
        public final boolean hasDateTime()
        {
          return this.paramOneofCase_ == 3;
        }
        
        public final boolean hasDefault()
        {
          return (this.bitField0_ & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.x().a(HSMLocalizableParameter.class, a.class);
        }
        
        public final a newBuilderForType()
        {
          return newBuilder();
        }
        
        protected final a newBuilderForType(o.b paramb)
        {
          return new a(paramb, (byte)0);
        }
        
        public final a toBuilder()
        {
          return newBuilder(this);
        }
        
        public static final class HSMCurrency
          extends o
          implements f.a
        {
          public static final int AMOUNT_1000_FIELD_NUMBER = 2;
          public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
          public static ae<HSMCurrency> PARSER = new c()
          {
            private static E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency c(f paramAnonymousf, m paramAnonymousm)
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a locala = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.newBuilder();
              try
              {
                locala.mergeFrom(paramAnonymousf, paramAnonymousm);
                return locala.buildPartial();
              }
              catch (q paramAnonymousf)
              {
                paramAnonymousf.a = locala.buildPartial();
                throw paramAnonymousf;
              }
              catch (IOException paramAnonymousf)
              {
                paramAnonymousf = new q(paramAnonymousf.getMessage());
                paramAnonymousf.a = locala.buildPartial();
                throw paramAnonymousf;
              }
            }
          };
          private static final HSMCurrency defaultInstance;
          private long amount1000_;
          private int bitField0_;
          private Object currencyCode_;
          private final an unknownFields;
          
          static
          {
            HSMCurrency localHSMCurrency = new HSMCurrency(true);
            defaultInstance = localHSMCurrency;
            localHSMCurrency.initFields();
          }
          
          private HSMCurrency(o.a<?> parama)
          {
            super();
            this.unknownFields = parama.getUnknownFields();
          }
          
          private HSMCurrency(boolean paramBoolean)
          {
            this.unknownFields = an.b();
          }
          
          public static HSMCurrency getDefaultInstance()
          {
            return defaultInstance;
          }
          
          public static final i.a getDescriptor()
          {
            return E2E.y();
          }
          
          private void initFields()
          {
            this.currencyCode_ = "";
            this.amount1000_ = 0L;
          }
          
          public static a newBuilder()
          {
            return a.a();
          }
          
          public static a newBuilder(HSMCurrency paramHSMCurrency)
          {
            return (a)newBuilder().mergeFrom(paramHSMCurrency);
          }
          
          public static HSMCurrency parseDelimitedFrom(InputStream paramInputStream)
          {
            return (HSMCurrency)PARSER.a(paramInputStream);
          }
          
          public static HSMCurrency parseDelimitedFrom(InputStream paramInputStream, m paramm)
          {
            return (HSMCurrency)PARSER.a(paramInputStream, paramm);
          }
          
          public static HSMCurrency parseFrom(e parame)
          {
            return (HSMCurrency)PARSER.a(parame);
          }
          
          public static HSMCurrency parseFrom(e parame, m paramm)
          {
            return (HSMCurrency)PARSER.a(parame, paramm);
          }
          
          public static HSMCurrency parseFrom(f paramf)
          {
            return (HSMCurrency)PARSER.a(paramf);
          }
          
          public static HSMCurrency parseFrom(f paramf, m paramm)
          {
            return (HSMCurrency)PARSER.a(paramf, paramm);
          }
          
          public static HSMCurrency parseFrom(InputStream paramInputStream)
          {
            return (HSMCurrency)PARSER.b(paramInputStream);
          }
          
          public static HSMCurrency parseFrom(InputStream paramInputStream, m paramm)
          {
            return (HSMCurrency)PARSER.b(paramInputStream, paramm);
          }
          
          public static HSMCurrency parseFrom(byte[] paramArrayOfByte)
          {
            return (HSMCurrency)PARSER.a(paramArrayOfByte);
          }
          
          public static HSMCurrency parseFrom(byte[] paramArrayOfByte, m paramm)
          {
            return (HSMCurrency)PARSER.a(paramArrayOfByte, paramm);
          }
          
          public final long getAmount1000()
          {
            return this.amount1000_;
          }
          
          public final String getCurrencyCode()
          {
            Object localObject = this.currencyCode_;
            if ((localObject instanceof String)) {
              return (String)localObject;
            }
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.currencyCode_ = str;
            }
            return str;
          }
          
          public final e getCurrencyCodeBytes()
          {
            Object localObject = this.currencyCode_;
            if ((localObject instanceof String))
            {
              localObject = e.a((String)localObject);
              this.currencyCode_ = localObject;
              return (e)localObject;
            }
            return (e)localObject;
          }
          
          public final HSMCurrency getDefaultInstanceForType()
          {
            return defaultInstance;
          }
          
          public final ae<HSMCurrency> getParserForType()
          {
            return PARSER;
          }
          
          public final an getUnknownFields()
          {
            return this.unknownFields;
          }
          
          public final boolean hasAmount1000()
          {
            return (this.bitField0_ & 0x2) == 2;
          }
          
          public final boolean hasCurrencyCode()
          {
            return (this.bitField0_ & 0x1) == 1;
          }
          
          protected final o.f internalGetFieldAccessorTable()
          {
            return E2E.z().a(HSMCurrency.class, a.class);
          }
          
          public final a newBuilderForType()
          {
            return newBuilder();
          }
          
          protected final a newBuilderForType(o.b paramb)
          {
            return new a(paramb, (byte)0);
          }
          
          public final a toBuilder()
          {
            return newBuilder(this);
          }
          
          public static final class a
            extends o.a<a>
            implements f.a
          {
            private int a;
            private Object b = "";
            private long c;
            
            private a() {}
            
            private a(o.b paramb)
            {
              super();
            }
            
            public static final i.a getDescriptor()
            {
              return E2E.y();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency build()
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency localHSMCurrency = buildPartial();
              if (!localHSMCurrency.isInitialized()) {
                throw newUninitializedMessageException(localHSMCurrency);
              }
              return localHSMCurrency;
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency buildPartial()
            {
              int i = 1;
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency localHSMCurrency = new E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency(this, null);
              int k = this.a;
              if ((k & 0x1) == 1) {}
              for (;;)
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.access$15302(localHSMCurrency, this.b);
                int j = i;
                if ((k & 0x2) == 2) {
                  j = i | 0x2;
                }
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.access$15402(localHSMCurrency, this.c);
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.access$15502(localHSMCurrency, j);
                onBuilt();
                return localHSMCurrency;
                i = 0;
              }
            }
            
            public final a clear()
            {
              super.clear();
              this.b = "";
              this.a &= 0xFFFFFFFE;
              this.c = 0L;
              this.a &= 0xFFFFFFFD;
              return this;
            }
            
            public final a clearAmount1000()
            {
              this.a &= 0xFFFFFFFD;
              this.c = 0L;
              onChanged();
              return this;
            }
            
            public final a clearCurrencyCode()
            {
              this.a &= 0xFFFFFFFE;
              this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance().getCurrencyCode();
              onChanged();
              return this;
            }
            
            public final a clone()
            {
              return (a)new a().mergeFrom(buildPartial());
            }
            
            public final long getAmount1000()
            {
              return this.c;
            }
            
            public final String getCurrencyCode()
            {
              Object localObject = this.b;
              if (!(localObject instanceof String))
              {
                localObject = (e)localObject;
                String str = ((e)localObject).e();
                if (((e)localObject).f()) {
                  this.b = str;
                }
                return str;
              }
              return (String)localObject;
            }
            
            public final e getCurrencyCodeBytes()
            {
              Object localObject = this.b;
              if ((localObject instanceof String))
              {
                localObject = e.a((String)localObject);
                this.b = localObject;
                return (e)localObject;
              }
              return (e)localObject;
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency getDefaultInstanceForType()
            {
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance();
            }
            
            public final i.a getDescriptorForType()
            {
              return E2E.y();
            }
            
            public final boolean hasAmount1000()
            {
              return (this.a & 0x2) == 2;
            }
            
            public final boolean hasCurrencyCode()
            {
              return (this.a & 0x1) == 1;
            }
            
            protected final o.f internalGetFieldAccessorTable()
            {
              return E2E.z().a(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.class, a.class);
            }
            
            public final a setAmount1000(long paramLong)
            {
              this.a |= 0x2;
              this.c = paramLong;
              onChanged();
              return this;
            }
            
            public final a setCurrencyCode(String paramString)
            {
              if (paramString == null) {
                throw new NullPointerException();
              }
              this.a |= 0x1;
              this.b = paramString;
              onChanged();
              return this;
            }
            
            public final a setCurrencyCodeBytes(e parame)
            {
              if (parame == null) {
                throw new NullPointerException();
              }
              this.a |= 0x1;
              this.b = parame;
              onChanged();
              return this;
            }
          }
        }
        
        public static final class HSMDateTime
          extends o
          implements f.a
        {
          public static final int COMPONENT_FIELD_NUMBER = 1;
          public static ae<HSMDateTime> PARSER = new c()
          {
            private static E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime c(f paramAnonymousf, m paramAnonymousm)
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a locala = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.newBuilder();
              try
              {
                locala.mergeFrom(paramAnonymousf, paramAnonymousm);
                return locala.buildPartial();
              }
              catch (q paramAnonymousf)
              {
                paramAnonymousf.a = locala.buildPartial();
                throw paramAnonymousf;
              }
              catch (IOException paramAnonymousf)
              {
                paramAnonymousf = new q(paramAnonymousf.getMessage());
                paramAnonymousf.a = locala.buildPartial();
                throw paramAnonymousf;
              }
            }
          };
          public static final int UNIX_EPOCH_FIELD_NUMBER = 2;
          private static final HSMDateTime defaultInstance;
          private int bitField0_;
          private int datetimeOneofCase_ = 0;
          private Object datetimeOneof_;
          private final an unknownFields;
          
          static
          {
            HSMDateTime localHSMDateTime = new HSMDateTime(true);
            defaultInstance = localHSMDateTime;
            localHSMDateTime.initFields();
          }
          
          private HSMDateTime(o.a<?> parama)
          {
            super();
            this.unknownFields = parama.getUnknownFields();
          }
          
          private HSMDateTime(boolean paramBoolean)
          {
            this.unknownFields = an.b();
          }
          
          public static HSMDateTime getDefaultInstance()
          {
            return defaultInstance;
          }
          
          public static final i.a getDescriptor()
          {
            return E2E.A();
          }
          
          private void initFields() {}
          
          public static a newBuilder()
          {
            return a.a();
          }
          
          public static a newBuilder(HSMDateTime paramHSMDateTime)
          {
            return (a)newBuilder().mergeFrom(paramHSMDateTime);
          }
          
          public static HSMDateTime parseDelimitedFrom(InputStream paramInputStream)
          {
            return (HSMDateTime)PARSER.a(paramInputStream);
          }
          
          public static HSMDateTime parseDelimitedFrom(InputStream paramInputStream, m paramm)
          {
            return (HSMDateTime)PARSER.a(paramInputStream, paramm);
          }
          
          public static HSMDateTime parseFrom(e parame)
          {
            return (HSMDateTime)PARSER.a(parame);
          }
          
          public static HSMDateTime parseFrom(e parame, m paramm)
          {
            return (HSMDateTime)PARSER.a(parame, paramm);
          }
          
          public static HSMDateTime parseFrom(f paramf)
          {
            return (HSMDateTime)PARSER.a(paramf);
          }
          
          public static HSMDateTime parseFrom(f paramf, m paramm)
          {
            return (HSMDateTime)PARSER.a(paramf, paramm);
          }
          
          public static HSMDateTime parseFrom(InputStream paramInputStream)
          {
            return (HSMDateTime)PARSER.b(paramInputStream);
          }
          
          public static HSMDateTime parseFrom(InputStream paramInputStream, m paramm)
          {
            return (HSMDateTime)PARSER.b(paramInputStream, paramm);
          }
          
          public static HSMDateTime parseFrom(byte[] paramArrayOfByte)
          {
            return (HSMDateTime)PARSER.a(paramArrayOfByte);
          }
          
          public static HSMDateTime parseFrom(byte[] paramArrayOfByte, m paramm)
          {
            return (HSMDateTime)PARSER.a(paramArrayOfByte, paramm);
          }
          
          public final HSMDateTimeComponent getComponent()
          {
            if (this.datetimeOneofCase_ == 1) {
              return (HSMDateTimeComponent)this.datetimeOneof_;
            }
            return HSMDateTimeComponent.getDefaultInstance();
          }
          
          public final f.a getComponentOrBuilder$9632016$1ec9fbcb$5f20f411()
          {
            if (this.datetimeOneofCase_ == 1) {
              return (HSMDateTimeComponent)this.datetimeOneof_;
            }
            return HSMDateTimeComponent.getDefaultInstance();
          }
          
          public final b getDatetimeOneofCase()
          {
            return b.a(this.datetimeOneofCase_);
          }
          
          public final HSMDateTime getDefaultInstanceForType()
          {
            return defaultInstance;
          }
          
          public final ae<HSMDateTime> getParserForType()
          {
            return PARSER;
          }
          
          public final HSMDateTimeUnixEpoch getUnixEpoch()
          {
            if (this.datetimeOneofCase_ == 2) {
              return (HSMDateTimeUnixEpoch)this.datetimeOneof_;
            }
            return HSMDateTimeUnixEpoch.getDefaultInstance();
          }
          
          public final f.a getUnixEpochOrBuilder$796d3dce$1ec9fbcb$5f20f411()
          {
            if (this.datetimeOneofCase_ == 2) {
              return (HSMDateTimeUnixEpoch)this.datetimeOneof_;
            }
            return HSMDateTimeUnixEpoch.getDefaultInstance();
          }
          
          public final an getUnknownFields()
          {
            return this.unknownFields;
          }
          
          public final boolean hasComponent()
          {
            return this.datetimeOneofCase_ == 1;
          }
          
          public final boolean hasUnixEpoch()
          {
            return this.datetimeOneofCase_ == 2;
          }
          
          protected final o.f internalGetFieldAccessorTable()
          {
            return E2E.B().a(HSMDateTime.class, a.class);
          }
          
          public final a newBuilderForType()
          {
            return newBuilder();
          }
          
          protected final a newBuilderForType(o.b paramb)
          {
            return new a(paramb, (byte)0);
          }
          
          public final a toBuilder()
          {
            return newBuilder(this);
          }
          
          public static final class HSMDateTimeComponent
            extends o
            implements f.a
          {
            public static final int CALENDAR_FIELD_NUMBER = 7;
            public static final int DAY_OF_MONTH_FIELD_NUMBER = 4;
            public static final int DAY_OF_WEEK_FIELD_NUMBER = 1;
            public static final int HOUR_FIELD_NUMBER = 5;
            public static final int MINUTE_FIELD_NUMBER = 6;
            public static final int MONTH_FIELD_NUMBER = 3;
            public static ae<HSMDateTimeComponent> PARSER = new c()
            {
              private static E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent c(f paramAnonymousf, m paramAnonymousm)
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a locala = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.newBuilder();
                try
                {
                  locala.mergeFrom(paramAnonymousf, paramAnonymousm);
                  return locala.buildPartial();
                }
                catch (q paramAnonymousf)
                {
                  paramAnonymousf.a = locala.buildPartial();
                  throw paramAnonymousf;
                }
                catch (IOException paramAnonymousf)
                {
                  paramAnonymousf = new q(paramAnonymousf.getMessage());
                  paramAnonymousf.a = locala.buildPartial();
                  throw paramAnonymousf;
                }
              }
            };
            public static final int YEAR_FIELD_NUMBER = 2;
            private static final HSMDateTimeComponent defaultInstance;
            private int bitField0_;
            private b calendar_;
            private int dayOfMonth_;
            private c dayOfWeek_;
            private int hour_;
            private int minute_;
            private int month_;
            private final an unknownFields;
            private int year_;
            
            static
            {
              HSMDateTimeComponent localHSMDateTimeComponent = new HSMDateTimeComponent(true);
              defaultInstance = localHSMDateTimeComponent;
              localHSMDateTimeComponent.initFields();
            }
            
            private HSMDateTimeComponent(o.a<?> parama)
            {
              super();
              this.unknownFields = parama.getUnknownFields();
            }
            
            private HSMDateTimeComponent(boolean paramBoolean)
            {
              this.unknownFields = an.b();
            }
            
            public static HSMDateTimeComponent getDefaultInstance()
            {
              return defaultInstance;
            }
            
            public static final i.a getDescriptor()
            {
              return E2E.C();
            }
            
            private void initFields()
            {
              this.dayOfWeek_ = c.a;
              this.year_ = 0;
              this.month_ = 0;
              this.dayOfMonth_ = 0;
              this.hour_ = 0;
              this.minute_ = 0;
              this.calendar_ = b.a;
            }
            
            public static a newBuilder()
            {
              return a.a();
            }
            
            public static a newBuilder(HSMDateTimeComponent paramHSMDateTimeComponent)
            {
              return (a)newBuilder().mergeFrom(paramHSMDateTimeComponent);
            }
            
            public static HSMDateTimeComponent parseDelimitedFrom(InputStream paramInputStream)
            {
              return (HSMDateTimeComponent)PARSER.a(paramInputStream);
            }
            
            public static HSMDateTimeComponent parseDelimitedFrom(InputStream paramInputStream, m paramm)
            {
              return (HSMDateTimeComponent)PARSER.a(paramInputStream, paramm);
            }
            
            public static HSMDateTimeComponent parseFrom(e parame)
            {
              return (HSMDateTimeComponent)PARSER.a(parame);
            }
            
            public static HSMDateTimeComponent parseFrom(e parame, m paramm)
            {
              return (HSMDateTimeComponent)PARSER.a(parame, paramm);
            }
            
            public static HSMDateTimeComponent parseFrom(f paramf)
            {
              return (HSMDateTimeComponent)PARSER.a(paramf);
            }
            
            public static HSMDateTimeComponent parseFrom(f paramf, m paramm)
            {
              return (HSMDateTimeComponent)PARSER.a(paramf, paramm);
            }
            
            public static HSMDateTimeComponent parseFrom(InputStream paramInputStream)
            {
              return (HSMDateTimeComponent)PARSER.b(paramInputStream);
            }
            
            public static HSMDateTimeComponent parseFrom(InputStream paramInputStream, m paramm)
            {
              return (HSMDateTimeComponent)PARSER.b(paramInputStream, paramm);
            }
            
            public static HSMDateTimeComponent parseFrom(byte[] paramArrayOfByte)
            {
              return (HSMDateTimeComponent)PARSER.a(paramArrayOfByte);
            }
            
            public static HSMDateTimeComponent parseFrom(byte[] paramArrayOfByte, m paramm)
            {
              return (HSMDateTimeComponent)PARSER.a(paramArrayOfByte, paramm);
            }
            
            public final b getCalendar()
            {
              return this.calendar_;
            }
            
            public final int getDayOfMonth()
            {
              return this.dayOfMonth_;
            }
            
            public final c getDayOfWeek()
            {
              return this.dayOfWeek_;
            }
            
            public final HSMDateTimeComponent getDefaultInstanceForType()
            {
              return defaultInstance;
            }
            
            public final int getHour()
            {
              return this.hour_;
            }
            
            public final int getMinute()
            {
              return this.minute_;
            }
            
            public final int getMonth()
            {
              return this.month_;
            }
            
            public final ae<HSMDateTimeComponent> getParserForType()
            {
              return PARSER;
            }
            
            public final an getUnknownFields()
            {
              return this.unknownFields;
            }
            
            public final int getYear()
            {
              return this.year_;
            }
            
            public final boolean hasCalendar()
            {
              return (this.bitField0_ & 0x40) == 64;
            }
            
            public final boolean hasDayOfMonth()
            {
              return (this.bitField0_ & 0x8) == 8;
            }
            
            public final boolean hasDayOfWeek()
            {
              return (this.bitField0_ & 0x1) == 1;
            }
            
            public final boolean hasHour()
            {
              return (this.bitField0_ & 0x10) == 16;
            }
            
            public final boolean hasMinute()
            {
              return (this.bitField0_ & 0x20) == 32;
            }
            
            public final boolean hasMonth()
            {
              return (this.bitField0_ & 0x4) == 4;
            }
            
            public final boolean hasYear()
            {
              return (this.bitField0_ & 0x2) == 2;
            }
            
            protected final o.f internalGetFieldAccessorTable()
            {
              return E2E.D().a(HSMDateTimeComponent.class, a.class);
            }
            
            public final a newBuilderForType()
            {
              return newBuilder();
            }
            
            protected final a newBuilderForType(o.b paramb)
            {
              return new a(paramb, (byte)0);
            }
            
            public final a toBuilder()
            {
              return newBuilder(this);
            }
            
            public static final class a
              extends o.a<a>
              implements f.a
            {
              private int a;
              private E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c.a;
              private int c;
              private int d;
              private int e;
              private int h;
              private int i;
              private E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b j = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b.a;
              
              private a() {}
              
              private a(o.b paramb)
              {
                super();
              }
              
              public static final i.a getDescriptor()
              {
                return E2E.C();
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent build()
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent localHSMDateTimeComponent = buildPartial();
                if (!localHSMDateTimeComponent.isInitialized()) {
                  throw newUninitializedMessageException(localHSMDateTimeComponent);
                }
                return localHSMDateTimeComponent;
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent buildPartial()
              {
                int m = 1;
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent localHSMDateTimeComponent = new E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent(this, null);
                int n = this.a;
                if ((n & 0x1) == 1) {}
                for (;;)
                {
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16402(localHSMDateTimeComponent, this.b);
                  int k = m;
                  if ((n & 0x2) == 2) {
                    k = m | 0x2;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16502(localHSMDateTimeComponent, this.c);
                  m = k;
                  if ((n & 0x4) == 4) {
                    m = k | 0x4;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16602(localHSMDateTimeComponent, this.d);
                  k = m;
                  if ((n & 0x8) == 8) {
                    k = m | 0x8;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16702(localHSMDateTimeComponent, this.e);
                  m = k;
                  if ((n & 0x10) == 16) {
                    m = k | 0x10;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16802(localHSMDateTimeComponent, this.h);
                  k = m;
                  if ((n & 0x20) == 32) {
                    k = m | 0x20;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$16902(localHSMDateTimeComponent, this.i);
                  m = k;
                  if ((n & 0x40) == 64) {
                    m = k | 0x40;
                  }
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$17002(localHSMDateTimeComponent, this.j);
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.access$17102(localHSMDateTimeComponent, m);
                  onBuilt();
                  return localHSMDateTimeComponent;
                  m = 0;
                }
              }
              
              public final a clear()
              {
                super.clear();
                this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c.a;
                this.a &= 0xFFFFFFFE;
                this.c = 0;
                this.a &= 0xFFFFFFFD;
                this.d = 0;
                this.a &= 0xFFFFFFFB;
                this.e = 0;
                this.a &= 0xFFFFFFF7;
                this.h = 0;
                this.a &= 0xFFFFFFEF;
                this.i = 0;
                this.a &= 0xFFFFFFDF;
                this.j = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b.a;
                this.a &= 0xFFFFFFBF;
                return this;
              }
              
              public final a clearCalendar()
              {
                this.a &= 0xFFFFFFBF;
                this.j = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b.a;
                onChanged();
                return this;
              }
              
              public final a clearDayOfMonth()
              {
                this.a &= 0xFFFFFFF7;
                this.e = 0;
                onChanged();
                return this;
              }
              
              public final a clearDayOfWeek()
              {
                this.a &= 0xFFFFFFFE;
                this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c.a;
                onChanged();
                return this;
              }
              
              public final a clearHour()
              {
                this.a &= 0xFFFFFFEF;
                this.h = 0;
                onChanged();
                return this;
              }
              
              public final a clearMinute()
              {
                this.a &= 0xFFFFFFDF;
                this.i = 0;
                onChanged();
                return this;
              }
              
              public final a clearMonth()
              {
                this.a &= 0xFFFFFFFB;
                this.d = 0;
                onChanged();
                return this;
              }
              
              public final a clearYear()
              {
                this.a &= 0xFFFFFFFD;
                this.c = 0;
                onChanged();
                return this;
              }
              
              public final a clone()
              {
                return (a)new a().mergeFrom(buildPartial());
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b getCalendar()
              {
                return this.j;
              }
              
              public final int getDayOfMonth()
              {
                return this.e;
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c getDayOfWeek()
              {
                return this.b;
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent getDefaultInstanceForType()
              {
                return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance();
              }
              
              public final i.a getDescriptorForType()
              {
                return E2E.C();
              }
              
              public final int getHour()
              {
                return this.h;
              }
              
              public final int getMinute()
              {
                return this.i;
              }
              
              public final int getMonth()
              {
                return this.d;
              }
              
              public final int getYear()
              {
                return this.c;
              }
              
              public final boolean hasCalendar()
              {
                return (this.a & 0x40) == 64;
              }
              
              public final boolean hasDayOfMonth()
              {
                return (this.a & 0x8) == 8;
              }
              
              public final boolean hasDayOfWeek()
              {
                return (this.a & 0x1) == 1;
              }
              
              public final boolean hasHour()
              {
                return (this.a & 0x10) == 16;
              }
              
              public final boolean hasMinute()
              {
                return (this.a & 0x20) == 32;
              }
              
              public final boolean hasMonth()
              {
                return (this.a & 0x4) == 4;
              }
              
              public final boolean hasYear()
              {
                return (this.a & 0x2) == 2;
              }
              
              protected final o.f internalGetFieldAccessorTable()
              {
                return E2E.D().a(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.class, a.class);
              }
              
              public final a setCalendar(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b paramb)
              {
                if (paramb == null) {
                  throw new NullPointerException();
                }
                this.a |= 0x40;
                this.j = paramb;
                onChanged();
                return this;
              }
              
              public final a setDayOfMonth(int paramInt)
              {
                this.a |= 0x8;
                this.e = paramInt;
                onChanged();
                return this;
              }
              
              public final a setDayOfWeek(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.c paramc)
              {
                if (paramc == null) {
                  throw new NullPointerException();
                }
                this.a |= 0x1;
                this.b = paramc;
                onChanged();
                return this;
              }
              
              public final a setHour(int paramInt)
              {
                this.a |= 0x10;
                this.h = paramInt;
                onChanged();
                return this;
              }
              
              public final a setMinute(int paramInt)
              {
                this.a |= 0x20;
                this.i = paramInt;
                onChanged();
                return this;
              }
              
              public final a setMonth(int paramInt)
              {
                this.a |= 0x4;
                this.d = paramInt;
                onChanged();
                return this;
              }
              
              public final a setYear(int paramInt)
              {
                this.a |= 0x2;
                this.c = paramInt;
                onChanged();
                return this;
              }
            }
            
            public static enum b
              implements af
            {
              private static f.a<b> c = new f.a() {};
              private static final b[] d = values();
              private final int e;
              private final int f;
              
              private b(int paramInt1, int paramInt2)
              {
                this.e = paramInt1;
                this.f = paramInt2;
              }
              
              public static final i.d getDescriptor()
              {
                return (i.d)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDescriptor().g().get(1);
              }
              
              public static f.a<b> internalGetValueMap$332b5b32$1ec9fbcb$5f20f411()
              {
                return c;
              }
              
              public static b valueOf(int paramInt)
              {
                switch (paramInt)
                {
                default: 
                  return null;
                case 1: 
                  return a;
                }
                return b;
              }
              
              public static b valueOf(i.e parame)
              {
                if (parame.c != getDescriptor()) {
                  throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return d[parame.a];
              }
              
              public final i.d getDescriptorForType()
              {
                return getDescriptor();
              }
              
              public final int getNumber()
              {
                return this.f;
              }
              
              public final i.e getValueDescriptor()
              {
                return (i.e)getDescriptor().d().get(this.e);
              }
            }
            
            public static enum c
              implements af
            {
              private static f.a<c> h = new f.a() {};
              private static final c[] i = values();
              private final int j;
              private final int k;
              
              private c(int paramInt1, int paramInt2)
              {
                this.j = paramInt1;
                this.k = paramInt2;
              }
              
              public static final i.d getDescriptor()
              {
                return (i.d)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDescriptor().g().get(0);
              }
              
              public static f.a<c> internalGetValueMap$332b5b32$1ec9fbcb$5f20f411()
              {
                return h;
              }
              
              public static c valueOf(int paramInt)
              {
                switch (paramInt)
                {
                default: 
                  return null;
                case 1: 
                  return a;
                case 2: 
                  return b;
                case 3: 
                  return c;
                case 4: 
                  return d;
                case 5: 
                  return e;
                case 6: 
                  return f;
                }
                return g;
              }
              
              public static c valueOf(i.e parame)
              {
                if (parame.c != getDescriptor()) {
                  throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return i[parame.a];
              }
              
              public final i.d getDescriptorForType()
              {
                return getDescriptor();
              }
              
              public final int getNumber()
              {
                return this.k;
              }
              
              public final i.e getValueDescriptor()
              {
                return (i.e)getDescriptor().d().get(this.j);
              }
            }
          }
          
          public static final class HSMDateTimeUnixEpoch
            extends o
            implements f.a
          {
            public static ae<HSMDateTimeUnixEpoch> PARSER = new c()
            {
              private static E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch c(f paramAnonymousf, m paramAnonymousm)
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a locala = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.newBuilder();
                try
                {
                  locala.mergeFrom(paramAnonymousf, paramAnonymousm);
                  return locala.buildPartial();
                }
                catch (q paramAnonymousf)
                {
                  paramAnonymousf.a = locala.buildPartial();
                  throw paramAnonymousf;
                }
                catch (IOException paramAnonymousf)
                {
                  paramAnonymousf = new q(paramAnonymousf.getMessage());
                  paramAnonymousf.a = locala.buildPartial();
                  throw paramAnonymousf;
                }
              }
            };
            public static final int TIMESTAMP_FIELD_NUMBER = 1;
            private static final HSMDateTimeUnixEpoch defaultInstance;
            private int bitField0_;
            private long timestamp_;
            private final an unknownFields;
            
            static
            {
              HSMDateTimeUnixEpoch localHSMDateTimeUnixEpoch = new HSMDateTimeUnixEpoch(true);
              defaultInstance = localHSMDateTimeUnixEpoch;
              localHSMDateTimeUnixEpoch.initFields();
            }
            
            private HSMDateTimeUnixEpoch(o.a<?> parama)
            {
              super();
              this.unknownFields = parama.getUnknownFields();
            }
            
            private HSMDateTimeUnixEpoch(boolean paramBoolean)
            {
              this.unknownFields = an.b();
            }
            
            public static HSMDateTimeUnixEpoch getDefaultInstance()
            {
              return defaultInstance;
            }
            
            public static final i.a getDescriptor()
            {
              return E2E.E();
            }
            
            private void initFields()
            {
              this.timestamp_ = 0L;
            }
            
            public static a newBuilder()
            {
              return a.a();
            }
            
            public static a newBuilder(HSMDateTimeUnixEpoch paramHSMDateTimeUnixEpoch)
            {
              return (a)newBuilder().mergeFrom(paramHSMDateTimeUnixEpoch);
            }
            
            public static HSMDateTimeUnixEpoch parseDelimitedFrom(InputStream paramInputStream)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramInputStream);
            }
            
            public static HSMDateTimeUnixEpoch parseDelimitedFrom(InputStream paramInputStream, m paramm)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramInputStream, paramm);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(e parame)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(parame);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(e parame, m paramm)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(parame, paramm);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(f paramf)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramf);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(f paramf, m paramm)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramf, paramm);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(InputStream paramInputStream)
            {
              return (HSMDateTimeUnixEpoch)PARSER.b(paramInputStream);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(InputStream paramInputStream, m paramm)
            {
              return (HSMDateTimeUnixEpoch)PARSER.b(paramInputStream, paramm);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(byte[] paramArrayOfByte)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramArrayOfByte);
            }
            
            public static HSMDateTimeUnixEpoch parseFrom(byte[] paramArrayOfByte, m paramm)
            {
              return (HSMDateTimeUnixEpoch)PARSER.a(paramArrayOfByte, paramm);
            }
            
            public final HSMDateTimeUnixEpoch getDefaultInstanceForType()
            {
              return defaultInstance;
            }
            
            public final ae<HSMDateTimeUnixEpoch> getParserForType()
            {
              return PARSER;
            }
            
            public final long getTimestamp()
            {
              return this.timestamp_;
            }
            
            public final an getUnknownFields()
            {
              return this.unknownFields;
            }
            
            public final boolean hasTimestamp()
            {
              return (this.bitField0_ & 0x1) == 1;
            }
            
            protected final o.f internalGetFieldAccessorTable()
            {
              return E2E.F().a(HSMDateTimeUnixEpoch.class, a.class);
            }
            
            public final a newBuilderForType()
            {
              return newBuilder();
            }
            
            protected final a newBuilderForType(o.b paramb)
            {
              return new a(paramb, (byte)0);
            }
            
            public final a toBuilder()
            {
              return newBuilder(this);
            }
            
            public static final class a
              extends o.a<a>
              implements f.a
            {
              private int a;
              private long b;
              
              private a() {}
              
              private a(o.b paramb)
              {
                super();
              }
              
              public static final i.a getDescriptor()
              {
                return E2E.E();
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch build()
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch localHSMDateTimeUnixEpoch = buildPartial();
                if (!localHSMDateTimeUnixEpoch.isInitialized()) {
                  throw newUninitializedMessageException(localHSMDateTimeUnixEpoch);
                }
                return localHSMDateTimeUnixEpoch;
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch buildPartial()
              {
                int i = 1;
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch localHSMDateTimeUnixEpoch = new E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch(this, null);
                if ((this.a & 0x1) == 1) {}
                for (;;)
                {
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.access$17802(localHSMDateTimeUnixEpoch, this.b);
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.access$17902(localHSMDateTimeUnixEpoch, i);
                  onBuilt();
                  return localHSMDateTimeUnixEpoch;
                  i = 0;
                }
              }
              
              public final a clear()
              {
                super.clear();
                this.b = 0L;
                this.a &= 0xFFFFFFFE;
                return this;
              }
              
              public final a clearTimestamp()
              {
                this.a &= 0xFFFFFFFE;
                this.b = 0L;
                onChanged();
                return this;
              }
              
              public final a clone()
              {
                return (a)new a().mergeFrom(buildPartial());
              }
              
              public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch getDefaultInstanceForType()
              {
                return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance();
              }
              
              public final i.a getDescriptorForType()
              {
                return E2E.E();
              }
              
              public final long getTimestamp()
              {
                return this.b;
              }
              
              public final boolean hasTimestamp()
              {
                return (this.a & 0x1) == 1;
              }
              
              protected final o.f internalGetFieldAccessorTable()
              {
                return E2E.F().a(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.class, a.class);
              }
              
              public final a setTimestamp(long paramLong)
              {
                this.a |= 0x1;
                this.b = paramLong;
                onChanged();
                return this;
              }
            }
          }
          
          public static final class a
            extends o.a<a>
            implements f.a
          {
            private int a = 0;
            private Object b;
            private aj<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a, f.a> c;
            private aj<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a, f.a> d;
            
            private a() {}
            
            private a(o.b paramb)
            {
              super();
            }
            
            public static final i.a getDescriptor()
            {
              return E2E.A();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime build()
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime localHSMDateTime = buildPartial();
              if (!localHSMDateTime.isInitialized()) {
                throw newUninitializedMessageException(localHSMDateTime);
              }
              return localHSMDateTime;
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime buildPartial()
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime localHSMDateTime = new E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime(this, null);
              if (this.a == 1)
              {
                if (this.c == null) {
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18402(localHSMDateTime, this.b);
                }
              }
              else if (this.a == 2)
              {
                if (this.d != null) {
                  break label94;
                }
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18402(localHSMDateTime, this.b);
              }
              for (;;)
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18502(localHSMDateTime, 0);
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18602(localHSMDateTime, this.a);
                onBuilt();
                return localHSMDateTime;
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18402(localHSMDateTime, this.c.c());
                break;
                label94:
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.access$18402(localHSMDateTime, this.d.c());
              }
            }
            
            public final a clear()
            {
              super.clear();
              this.a = 0;
              this.b = null;
              return this;
            }
            
            public final a clearComponent()
            {
              if (this.c == null)
              {
                if (this.a == 1)
                {
                  this.a = 0;
                  this.b = null;
                  onChanged();
                }
                return this;
              }
              if (this.a == 1)
              {
                this.a = 0;
                this.b = null;
              }
              this.c.f();
              return this;
            }
            
            public final a clearDatetimeOneof()
            {
              this.a = 0;
              this.b = null;
              onChanged();
              return this;
            }
            
            public final a clearUnixEpoch()
            {
              if (this.d == null)
              {
                if (this.a == 2)
                {
                  this.a = 0;
                  this.b = null;
                  onChanged();
                }
                return this;
              }
              if (this.a == 2)
              {
                this.a = 0;
                this.b = null;
              }
              this.d.f();
              return this;
            }
            
            public final a clone()
            {
              return (a)new a().mergeFrom(buildPartial());
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent getComponent()
            {
              if (this.c == null)
              {
                if (this.a == 1) {
                  return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)this.b;
                }
                return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance();
              }
              if (this.a == 1) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)this.c.b();
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a getComponentBuilder()
            {
              if (this.c == null)
              {
                if (this.a != 1) {
                  this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance();
                }
                this.c = new aj((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)this.b, getParentForChildren(), this.g);
                this.b = null;
              }
              this.a = 1;
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a)this.c.d();
            }
            
            public final f.a getComponentOrBuilder$9632016$1ec9fbcb$5f20f411()
            {
              if ((this.a == 1) && (this.c != null)) {
                return (f.a)this.c.e();
              }
              if (this.a == 1) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)this.b;
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.b getDatetimeOneofCase()
            {
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.b.a(this.a);
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime getDefaultInstanceForType()
            {
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance();
            }
            
            public final i.a getDescriptorForType()
            {
              return E2E.A();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch getUnixEpoch()
            {
              if (this.d == null)
              {
                if (this.a == 2) {
                  return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)this.b;
                }
                return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance();
              }
              if (this.a == 2) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)this.d.b();
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance();
            }
            
            public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a getUnixEpochBuilder()
            {
              if (this.d == null)
              {
                if (this.a != 2) {
                  this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance();
                }
                this.d = new aj((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)this.b, getParentForChildren(), this.g);
                this.b = null;
              }
              this.a = 2;
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a)this.d.d();
            }
            
            public final f.a getUnixEpochOrBuilder$796d3dce$1ec9fbcb$5f20f411()
            {
              if ((this.a == 2) && (this.d != null)) {
                return (f.a)this.d.e();
              }
              if (this.a == 2) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)this.b;
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance();
            }
            
            public final boolean hasComponent()
            {
              return this.a == 1;
            }
            
            public final boolean hasUnixEpoch()
            {
              return this.a == 2;
            }
            
            protected final o.f internalGetFieldAccessorTable()
            {
              return E2E.B().a(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.class, a.class);
            }
            
            public final a mergeComponent(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent paramHSMDateTimeComponent)
            {
              if (this.c == null) {
                if ((this.a == 1) && (this.b != E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.getDefaultInstance()))
                {
                  this.b = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.newBuilder((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)this.b).mergeFrom(paramHSMDateTimeComponent)).buildPartial();
                  onChanged();
                }
              }
              for (;;)
              {
                this.a = 1;
                return this;
                this.b = paramHSMDateTimeComponent;
                break;
                if (this.a == 1) {
                  this.c.b(paramHSMDateTimeComponent);
                }
                this.c.a(paramHSMDateTimeComponent);
              }
            }
            
            public final a mergeUnixEpoch(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch paramHSMDateTimeUnixEpoch)
            {
              if (this.d == null) {
                if ((this.a == 2) && (this.b != E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.getDefaultInstance()))
                {
                  this.b = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.newBuilder((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)this.b).mergeFrom(paramHSMDateTimeUnixEpoch)).buildPartial();
                  onChanged();
                }
              }
              for (;;)
              {
                this.a = 2;
                return this;
                this.b = paramHSMDateTimeUnixEpoch;
                break;
                if (this.a == 2) {
                  this.d.b(paramHSMDateTimeUnixEpoch);
                }
                this.d.a(paramHSMDateTimeUnixEpoch);
              }
            }
            
            public final a setComponent(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.a parama)
            {
              if (this.c == null)
              {
                this.b = parama.build();
                onChanged();
              }
              for (;;)
              {
                this.a = 1;
                return this;
                this.c.a(parama.build());
              }
            }
            
            public final a setComponent(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent paramHSMDateTimeComponent)
            {
              if (this.c == null)
              {
                if (paramHSMDateTimeComponent == null) {
                  throw new NullPointerException();
                }
                this.b = paramHSMDateTimeComponent;
                onChanged();
              }
              for (;;)
              {
                this.a = 1;
                return this;
                this.c.a(paramHSMDateTimeComponent);
              }
            }
            
            public final a setUnixEpoch(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch.a parama)
            {
              if (this.d == null)
              {
                this.b = parama.build();
                onChanged();
              }
              for (;;)
              {
                this.a = 2;
                return this;
                this.d.a(parama.build());
              }
            }
            
            public final a setUnixEpoch(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch paramHSMDateTimeUnixEpoch)
            {
              if (this.d == null)
              {
                if (paramHSMDateTimeUnixEpoch == null) {
                  throw new NullPointerException();
                }
                this.b = paramHSMDateTimeUnixEpoch;
                onChanged();
              }
              for (;;)
              {
                this.a = 2;
                return this;
                this.d.a(paramHSMDateTimeUnixEpoch);
              }
            }
          }
          
          public static enum b
            implements p.a
          {
            private int d = 0;
            
            private b(int paramInt)
            {
              this.d = paramInt;
            }
            
            public static b a(int paramInt)
            {
              switch (paramInt)
              {
              default: 
                throw new IllegalArgumentException("Value is undefined for this oneof enum.");
              case 1: 
                return a;
              case 2: 
                return b;
              }
              return c;
            }
            
            public final int getNumber()
            {
              return this.d;
            }
          }
        }
        
        public static final class a
          extends o.a<a>
          implements f.a
        {
          private int a = 0;
          private Object b;
          private int c;
          private Object d = "";
          private aj<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a, f.a> e;
          private aj<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a, f.a> h;
          
          private a() {}
          
          private a(o.b paramb)
          {
            super();
          }
          
          public static final i.a getDescriptor()
          {
            return E2E.w();
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter build()
          {
            E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter localHSMLocalizableParameter = buildPartial();
            if (!localHSMLocalizableParameter.isInitialized()) {
              throw newUninitializedMessageException(localHSMLocalizableParameter);
            }
            return localHSMLocalizableParameter;
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter buildPartial()
          {
            int i = 1;
            E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter localHSMLocalizableParameter = new E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter(this, null);
            if ((this.c & 0x1) == 1) {}
            for (;;)
            {
              E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19102(localHSMLocalizableParameter, this.d);
              if (this.a == 2)
              {
                if (this.e == null) {
                  E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19202(localHSMLocalizableParameter, this.b);
                }
              }
              else if (this.a == 3)
              {
                if (this.h != null) {
                  break label115;
                }
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19202(localHSMLocalizableParameter, this.b);
              }
              for (;;)
              {
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19302(localHSMLocalizableParameter, i);
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19402(localHSMLocalizableParameter, this.a);
                onBuilt();
                return localHSMLocalizableParameter;
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19202(localHSMLocalizableParameter, this.e.c());
                break;
                label115:
                E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.access$19202(localHSMLocalizableParameter, this.h.c());
              }
              i = 0;
            }
          }
          
          public final a clear()
          {
            super.clear();
            this.d = "";
            this.c &= 0xFFFFFFFE;
            this.a = 0;
            this.b = null;
            return this;
          }
          
          public final a clearCurrency()
          {
            if (this.e == null)
            {
              if (this.a == 2)
              {
                this.a = 0;
                this.b = null;
                onChanged();
              }
              return this;
            }
            if (this.a == 2)
            {
              this.a = 0;
              this.b = null;
            }
            this.e.f();
            return this;
          }
          
          public final a clearDateTime()
          {
            if (this.h == null)
            {
              if (this.a == 3)
              {
                this.a = 0;
                this.b = null;
                onChanged();
              }
              return this;
            }
            if (this.a == 3)
            {
              this.a = 0;
              this.b = null;
            }
            this.h.f();
            return this;
          }
          
          public final a clearDefault()
          {
            this.c &= 0xFFFFFFFE;
            this.d = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.getDefaultInstance().getDefault();
            onChanged();
            return this;
          }
          
          public final a clearParamOneof()
          {
            this.a = 0;
            this.b = null;
            onChanged();
            return this;
          }
          
          public final a clone()
          {
            return (a)new a().mergeFrom(buildPartial());
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency getCurrency()
          {
            if (this.e == null)
            {
              if (this.a == 2) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)this.b;
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance();
            }
            if (this.a == 2) {
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)this.e.b();
            }
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance();
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a getCurrencyBuilder()
          {
            if (this.e == null)
            {
              if (this.a != 2) {
                this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance();
              }
              this.e = new aj((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)this.b, getParentForChildren(), this.g);
              this.b = null;
            }
            this.a = 2;
            return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a)this.e.d();
          }
          
          public final f.a getCurrencyOrBuilder$353d03b6$1ec9fbcb$5f20f411()
          {
            if ((this.a == 2) && (this.e != null)) {
              return (f.a)this.e.e();
            }
            if (this.a == 2) {
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)this.b;
            }
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance();
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime getDateTime()
          {
            if (this.h == null)
            {
              if (this.a == 3) {
                return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime)this.b;
              }
              return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance();
            }
            if (this.a == 3) {
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime)this.h.b();
            }
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance();
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a getDateTimeBuilder()
          {
            if (this.h == null)
            {
              if (this.a != 3) {
                this.b = E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance();
              }
              this.h = new aj((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime)this.b, getParentForChildren(), this.g);
              this.b = null;
            }
            this.a = 3;
            return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a)this.h.d();
          }
          
          public final f.a getDateTimeOrBuilder$1dae2140$1ec9fbcb$5f20f411()
          {
            if ((this.a == 3) && (this.h != null)) {
              return (f.a)this.h.e();
            }
            if (this.a == 3) {
              return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime)this.b;
            }
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance();
          }
          
          public final String getDefault()
          {
            Object localObject = this.d;
            if (!(localObject instanceof String))
            {
              localObject = (e)localObject;
              String str = ((e)localObject).e();
              if (((e)localObject).f()) {
                this.d = str;
              }
              return str;
            }
            return (String)localObject;
          }
          
          public final e getDefaultBytes()
          {
            Object localObject = this.d;
            if ((localObject instanceof String))
            {
              localObject = e.a((String)localObject);
              this.d = localObject;
              return (e)localObject;
            }
            return (e)localObject;
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter getDefaultInstanceForType()
          {
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.getDefaultInstance();
          }
          
          public final i.a getDescriptorForType()
          {
            return E2E.w();
          }
          
          public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.b getParamOneofCase()
          {
            return E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.b.a(this.a);
          }
          
          public final boolean hasCurrency()
          {
            return this.a == 2;
          }
          
          public final boolean hasDateTime()
          {
            return this.a == 3;
          }
          
          public final boolean hasDefault()
          {
            return (this.c & 0x1) == 1;
          }
          
          protected final o.f internalGetFieldAccessorTable()
          {
            return E2E.x().a(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.class, a.class);
          }
          
          public final a mergeCurrency(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency paramHSMCurrency)
          {
            if (this.e == null) {
              if ((this.a == 2) && (this.b != E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.getDefaultInstance()))
              {
                this.b = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.newBuilder((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)this.b).mergeFrom(paramHSMCurrency)).buildPartial();
                onChanged();
              }
            }
            for (;;)
            {
              this.a = 2;
              return this;
              this.b = paramHSMCurrency;
              break;
              if (this.a == 2) {
                this.e.b(paramHSMCurrency);
              }
              this.e.a(paramHSMCurrency);
            }
          }
          
          public final a mergeDateTime(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime paramHSMDateTime)
          {
            if (this.h == null) {
              if ((this.a == 3) && (this.b != E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.getDefaultInstance()))
              {
                this.b = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a)E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.newBuilder((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime)this.b).mergeFrom(paramHSMDateTime)).buildPartial();
                onChanged();
              }
            }
            for (;;)
            {
              this.a = 3;
              return this;
              this.b = paramHSMDateTime;
              break;
              if (this.a == 3) {
                this.h.b(paramHSMDateTime);
              }
              this.h.a(paramHSMDateTime);
            }
          }
          
          public final a setCurrency(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency.a parama)
          {
            if (this.e == null)
            {
              this.b = parama.build();
              onChanged();
            }
            for (;;)
            {
              this.a = 2;
              return this;
              this.e.a(parama.build());
            }
          }
          
          public final a setCurrency(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency paramHSMCurrency)
          {
            if (this.e == null)
            {
              if (paramHSMCurrency == null) {
                throw new NullPointerException();
              }
              this.b = paramHSMCurrency;
              onChanged();
            }
            for (;;)
            {
              this.a = 2;
              return this;
              this.e.a(paramHSMCurrency);
            }
          }
          
          public final a setDateTime(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.a parama)
          {
            if (this.h == null)
            {
              this.b = parama.build();
              onChanged();
            }
            for (;;)
            {
              this.a = 3;
              return this;
              this.h.a(parama.build());
            }
          }
          
          public final a setDateTime(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime paramHSMDateTime)
          {
            if (this.h == null)
            {
              if (paramHSMDateTime == null) {
                throw new NullPointerException();
              }
              this.b = paramHSMDateTime;
              onChanged();
            }
            for (;;)
            {
              this.a = 3;
              return this;
              this.h.a(paramHSMDateTime);
            }
          }
          
          public final a setDefault(String paramString)
          {
            if (paramString == null) {
              throw new NullPointerException();
            }
            this.c |= 0x1;
            this.d = paramString;
            onChanged();
            return this;
          }
          
          public final a setDefaultBytes(e parame)
          {
            if (parame == null) {
              throw new NullPointerException();
            }
            this.c |= 0x1;
            this.d = parame;
            onChanged();
            return this;
          }
        }
        
        public static enum b
          implements p.a
        {
          private int d = 0;
          
          private b(int paramInt)
          {
            this.d = paramInt;
          }
          
          public static b a(int paramInt)
          {
            switch (paramInt)
            {
            case 1: 
            default: 
              throw new IllegalArgumentException("Value is undefined for this oneof enum.");
            case 2: 
              return a;
            case 3: 
              return b;
            }
            return c;
          }
          
          public final int getNumber()
          {
            return this.d;
          }
        }
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private u d = t.a;
        private Object e = "";
        private Object h = "";
        private List<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter> i = Collections.emptyList();
        private ah<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a, f.a> j;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.HighlyStructuredMessage.alwaysUseFieldBuilders) {
            f();
          }
        }
        
        private void c()
        {
          if ((this.a & 0x4) != 4)
          {
            this.d = new t(this.d);
            this.a |= 0x4;
          }
        }
        
        private void d()
        {
          if ((this.a & 0x20) != 32)
          {
            this.i = new ArrayList(this.i);
            this.a |= 0x20;
          }
        }
        
        private ah<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a, f.a> f()
        {
          List localList;
          if (this.j == null)
          {
            localList = this.i;
            if ((this.a & 0x20) != 32) {
              break label57;
            }
          }
          label57:
          for (boolean bool = true;; bool = false)
          {
            this.j = new ah(localList, bool, getParentForChildren(), this.g);
            this.i = null;
            return this.j;
          }
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.u();
        }
        
        public final a addAllLocalizableParams(Iterable<? extends E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter> paramIterable)
        {
          if (this.j == null)
          {
            d();
            b.a.addAll(paramIterable, this.i);
            onChanged();
            return this;
          }
          this.j.a(paramIterable);
          return this;
        }
        
        public final a addAllParams(Iterable<String> paramIterable)
        {
          c();
          b.a.addAll(paramIterable, this.d);
          onChanged();
          return this;
        }
        
        public final a addLocalizableParams(int paramInt, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a parama)
        {
          if (this.j == null)
          {
            d();
            this.i.add(paramInt, parama.build());
            onChanged();
            return this;
          }
          this.j.b(paramInt, parama.build());
          return this;
        }
        
        public final a addLocalizableParams(int paramInt, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter paramHSMLocalizableParameter)
        {
          if (this.j == null)
          {
            if (paramHSMLocalizableParameter == null) {
              throw new NullPointerException();
            }
            d();
            this.i.add(paramInt, paramHSMLocalizableParameter);
            onChanged();
            return this;
          }
          this.j.b(paramInt, paramHSMLocalizableParameter);
          return this;
        }
        
        public final a addLocalizableParams(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a parama)
        {
          if (this.j == null)
          {
            d();
            this.i.add(parama.build());
            onChanged();
            return this;
          }
          this.j.a(parama.build());
          return this;
        }
        
        public final a addLocalizableParams(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter paramHSMLocalizableParameter)
        {
          if (this.j == null)
          {
            if (paramHSMLocalizableParameter == null) {
              throw new NullPointerException();
            }
            d();
            this.i.add(paramHSMLocalizableParameter);
            onChanged();
            return this;
          }
          this.j.a(paramHSMLocalizableParameter);
          return this;
        }
        
        public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a addLocalizableParamsBuilder()
        {
          return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a)f().b(E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.getDefaultInstance());
        }
        
        public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a addLocalizableParamsBuilder(int paramInt)
        {
          return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a)f().c(paramInt, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.getDefaultInstance());
        }
        
        public final a addParams(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          c();
          this.d.add(paramString);
          onChanged();
          return this;
        }
        
        public final a addParamsBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          c();
          this.d.a(parame);
          onChanged();
          return this;
        }
        
        public final E2E.Message.HighlyStructuredMessage build()
        {
          E2E.Message.HighlyStructuredMessage localHighlyStructuredMessage = buildPartial();
          if (!localHighlyStructuredMessage.isInitialized()) {
            throw newUninitializedMessageException(localHighlyStructuredMessage);
          }
          return localHighlyStructuredMessage;
        }
        
        public final E2E.Message.HighlyStructuredMessage buildPartial()
        {
          int m = 1;
          E2E.Message.HighlyStructuredMessage localHighlyStructuredMessage = new E2E.Message.HighlyStructuredMessage(this, null);
          int n = this.a;
          if ((n & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.HighlyStructuredMessage.access$19902(localHighlyStructuredMessage, this.b);
            int k = m;
            if ((n & 0x2) == 2) {
              k = m | 0x2;
            }
            E2E.Message.HighlyStructuredMessage.access$20002(localHighlyStructuredMessage, this.c);
            if ((this.a & 0x4) == 4)
            {
              this.d = this.d.b();
              this.a &= 0xFFFFFFFB;
            }
            E2E.Message.HighlyStructuredMessage.access$20102(localHighlyStructuredMessage, this.d);
            m = k;
            if ((n & 0x8) == 8) {
              m = k | 0x4;
            }
            E2E.Message.HighlyStructuredMessage.access$20202(localHighlyStructuredMessage, this.e);
            k = m;
            if ((n & 0x10) == 16) {
              k = m | 0x8;
            }
            E2E.Message.HighlyStructuredMessage.access$20302(localHighlyStructuredMessage, this.h);
            if (this.j == null)
            {
              if ((this.a & 0x20) == 32)
              {
                this.i = Collections.unmodifiableList(this.i);
                this.a &= 0xFFFFFFDF;
              }
              E2E.Message.HighlyStructuredMessage.access$20402(localHighlyStructuredMessage, this.i);
            }
            for (;;)
            {
              E2E.Message.HighlyStructuredMessage.access$20502(localHighlyStructuredMessage, k);
              onBuilt();
              return localHighlyStructuredMessage;
              E2E.Message.HighlyStructuredMessage.access$20402(localHighlyStructuredMessage, this.j.e());
            }
            m = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = t.a;
          this.a &= 0xFFFFFFFB;
          this.e = "";
          this.a &= 0xFFFFFFF7;
          this.h = "";
          this.a &= 0xFFFFFFEF;
          if (this.j == null)
          {
            this.i = Collections.emptyList();
            this.a &= 0xFFFFFFDF;
            return this;
          }
          this.j.d();
          return this;
        }
        
        public final a clearElementName()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.HighlyStructuredMessage.getDefaultInstance().getElementName();
          onChanged();
          return this;
        }
        
        public final a clearFallbackLc()
        {
          this.a &= 0xFFFFFFEF;
          this.h = E2E.Message.HighlyStructuredMessage.getDefaultInstance().getFallbackLc();
          onChanged();
          return this;
        }
        
        public final a clearFallbackLg()
        {
          this.a &= 0xFFFFFFF7;
          this.e = E2E.Message.HighlyStructuredMessage.getDefaultInstance().getFallbackLg();
          onChanged();
          return this;
        }
        
        public final a clearLocalizableParams()
        {
          if (this.j == null)
          {
            this.i = Collections.emptyList();
            this.a &= 0xFFFFFFDF;
            onChanged();
            return this;
          }
          this.j.d();
          return this;
        }
        
        public final a clearNamespace()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.HighlyStructuredMessage.getDefaultInstance().getNamespace();
          onChanged();
          return this;
        }
        
        public final a clearParams()
        {
          this.d = t.a;
          this.a &= 0xFFFFFFFB;
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.Message.HighlyStructuredMessage getDefaultInstanceForType()
        {
          return E2E.Message.HighlyStructuredMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.u();
        }
        
        public final String getElementName()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getElementNameBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getFallbackLc()
        {
          Object localObject = this.h;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.h = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getFallbackLcBytes()
        {
          Object localObject = this.h;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.h = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getFallbackLg()
        {
          Object localObject = this.e;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.e = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getFallbackLgBytes()
        {
          Object localObject = this.e;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.e = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter getLocalizableParams(int paramInt)
        {
          if (this.j == null) {
            return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter)this.i.get(paramInt);
          }
          return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter)this.j.a(paramInt, false);
        }
        
        public final E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a getLocalizableParamsBuilder(int paramInt)
        {
          return (E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a)f().a(paramInt);
        }
        
        public final List<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a> getLocalizableParamsBuilderList()
        {
          return f().g();
        }
        
        public final int getLocalizableParamsCount()
        {
          if (this.j == null) {
            return this.i.size();
          }
          return this.j.b();
        }
        
        public final List<E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter> getLocalizableParamsList()
        {
          if (this.j == null) {
            return Collections.unmodifiableList(this.i);
          }
          return this.j.f();
        }
        
        public final f.a getLocalizableParamsOrBuilder$74891c00$70c9c44e$244156ca(int paramInt)
        {
          if (this.j == null) {
            return (f.a)this.i.get(paramInt);
          }
          return (f.a)this.j.b(paramInt);
        }
        
        public final List<? extends f.a> getLocalizableParamsOrBuilderList()
        {
          if (this.j != null) {
            return this.j.h();
          }
          return Collections.unmodifiableList(this.i);
        }
        
        public final String getNamespace()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getNamespaceBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getParams(int paramInt)
        {
          return (String)this.d.get(paramInt);
        }
        
        public final e getParamsBytes(int paramInt)
        {
          return this.d.a(paramInt);
        }
        
        public final int getParamsCount()
        {
          return this.d.size();
        }
        
        public final ag getParamsList()
        {
          return this.d.b();
        }
        
        public final boolean hasElementName()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasFallbackLc()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasFallbackLg()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasNamespace()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.v().a(E2E.Message.HighlyStructuredMessage.class, a.class);
        }
        
        public final a removeLocalizableParams(int paramInt)
        {
          if (this.j == null)
          {
            d();
            this.i.remove(paramInt);
            onChanged();
            return this;
          }
          this.j.c(paramInt);
          return this;
        }
        
        public final a setElementName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setElementNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setFallbackLc(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = paramString;
          onChanged();
          return this;
        }
        
        public final a setFallbackLcBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = parame;
          onChanged();
          return this;
        }
        
        public final a setFallbackLg(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = paramString;
          onChanged();
          return this;
        }
        
        public final a setFallbackLgBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = parame;
          onChanged();
          return this;
        }
        
        public final a setLocalizableParams(int paramInt, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.a parama)
        {
          if (this.j == null)
          {
            d();
            this.i.set(paramInt, parama.build());
            onChanged();
            return this;
          }
          this.j.a(paramInt, parama.build());
          return this;
        }
        
        public final a setLocalizableParams(int paramInt, E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter paramHSMLocalizableParameter)
        {
          if (this.j == null)
          {
            if (paramHSMLocalizableParameter == null) {
              throw new NullPointerException();
            }
            d();
            this.i.set(paramInt, paramHSMLocalizableParameter);
            onChanged();
            return this;
          }
          this.j.a(paramInt, paramHSMLocalizableParameter);
          return this;
        }
        
        public final a setNamespace(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setNamespaceBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final a setParams(int paramInt, String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          c();
          this.d.set(paramInt, paramString);
          onChanged();
          return this;
        }
      }
    }
    
    public static final class ImageMessage
      extends o
      implements f.a
    {
      public static final int CAPTION_FIELD_NUMBER = 3;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int FILE_ENC_SHA256_FIELD_NUMBER = 9;
      public static final int FILE_LENGTH_FIELD_NUMBER = 5;
      public static final int FILE_SHA256_FIELD_NUMBER = 4;
      public static final int HEIGHT_FIELD_NUMBER = 6;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static final int MEDIA_KEY_FIELD_NUMBER = 8;
      public static final int MIMETYPE_FIELD_NUMBER = 2;
      public static ae<ImageMessage> PARSER = new c()
      {
        private static E2E.Message.ImageMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.ImageMessage.a locala = E2E.Message.ImageMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int URL_FIELD_NUMBER = 1;
      public static final int WIDTH_FIELD_NUMBER = 7;
      private static final ImageMessage defaultInstance;
      private int bitField0_;
      private Object caption_;
      private E2E.ContextInfo contextInfo_;
      private e fileEncSha256_;
      private long fileLength_;
      private e fileSha256_;
      private int height_;
      private e jpegThumbnail_;
      private e mediaKey_;
      private Object mimetype_;
      private final an unknownFields;
      private Object url_;
      private int width_;
      
      static
      {
        ImageMessage localImageMessage = new ImageMessage(true);
        defaultInstance = localImageMessage;
        localImageMessage.initFields();
      }
      
      private ImageMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private ImageMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static ImageMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.e();
      }
      
      private void initFields()
      {
        this.url_ = "";
        this.mimetype_ = "";
        this.caption_ = "";
        this.fileSha256_ = e.b;
        this.fileLength_ = 0L;
        this.height_ = 0;
        this.width_ = 0;
        this.mediaKey_ = e.b;
        this.fileEncSha256_ = e.b;
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(ImageMessage paramImageMessage)
      {
        return (a)newBuilder().mergeFrom(paramImageMessage);
      }
      
      public static ImageMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (ImageMessage)PARSER.a(paramInputStream);
      }
      
      public static ImageMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (ImageMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static ImageMessage parseFrom(e parame)
      {
        return (ImageMessage)PARSER.a(parame);
      }
      
      public static ImageMessage parseFrom(e parame, m paramm)
      {
        return (ImageMessage)PARSER.a(parame, paramm);
      }
      
      public static ImageMessage parseFrom(f paramf)
      {
        return (ImageMessage)PARSER.a(paramf);
      }
      
      public static ImageMessage parseFrom(f paramf, m paramm)
      {
        return (ImageMessage)PARSER.a(paramf, paramm);
      }
      
      public static ImageMessage parseFrom(InputStream paramInputStream)
      {
        return (ImageMessage)PARSER.b(paramInputStream);
      }
      
      public static ImageMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (ImageMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static ImageMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (ImageMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static ImageMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (ImageMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final String getCaption()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.caption_ = str;
        }
        return str;
      }
      
      public final e getCaptionBytes()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.caption_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final ImageMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final e getFileEncSha256()
      {
        return this.fileEncSha256_;
      }
      
      public final long getFileLength()
      {
        return this.fileLength_;
      }
      
      public final e getFileSha256()
      {
        return this.fileSha256_;
      }
      
      public final int getHeight()
      {
        return this.height_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final e getMediaKey()
      {
        return this.mediaKey_;
      }
      
      public final String getMimetype()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.mimetype_ = str;
        }
        return str;
      }
      
      public final e getMimetypeBytes()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.mimetype_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<ImageMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getUrl()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.url_ = str;
        }
        return str;
      }
      
      public final e getUrlBytes()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.url_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final int getWidth()
      {
        return this.width_;
      }
      
      public final boolean hasCaption()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x400) == 1024;
      }
      
      public final boolean hasFileEncSha256()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasFileLength()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final boolean hasFileSha256()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasHeight()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      public final boolean hasMediaKey()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasMimetype()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasUrl()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasWidth()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.f().a(ImageMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private Object d = "";
        private e e = e.b;
        private long h;
        private int i;
        private int j;
        private e k = e.b;
        private e l = e.b;
        private e m = e.b;
        private E2E.ContextInfo n = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> o;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.ImageMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.o == null)
          {
            this.o = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.n = null;
          }
          return this.o;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.e();
        }
        
        public final E2E.Message.ImageMessage build()
        {
          E2E.Message.ImageMessage localImageMessage = buildPartial();
          if (!localImageMessage.isInitialized()) {
            throw newUninitializedMessageException(localImageMessage);
          }
          return localImageMessage;
        }
        
        public final E2E.Message.ImageMessage buildPartial()
        {
          int i2 = 1;
          E2E.Message.ImageMessage localImageMessage = new E2E.Message.ImageMessage(this, null);
          int i3 = this.a;
          if ((i3 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.ImageMessage.access$1702(localImageMessage, this.b);
            int i1 = i2;
            if ((i3 & 0x2) == 2) {
              i1 = i2 | 0x2;
            }
            E2E.Message.ImageMessage.access$1802(localImageMessage, this.c);
            i2 = i1;
            if ((i3 & 0x4) == 4) {
              i2 = i1 | 0x4;
            }
            E2E.Message.ImageMessage.access$1902(localImageMessage, this.d);
            i1 = i2;
            if ((i3 & 0x8) == 8) {
              i1 = i2 | 0x8;
            }
            E2E.Message.ImageMessage.access$2002(localImageMessage, this.e);
            i2 = i1;
            if ((i3 & 0x10) == 16) {
              i2 = i1 | 0x10;
            }
            E2E.Message.ImageMessage.access$2102(localImageMessage, this.h);
            i1 = i2;
            if ((i3 & 0x20) == 32) {
              i1 = i2 | 0x20;
            }
            E2E.Message.ImageMessage.access$2202(localImageMessage, this.i);
            i2 = i1;
            if ((i3 & 0x40) == 64) {
              i2 = i1 | 0x40;
            }
            E2E.Message.ImageMessage.access$2302(localImageMessage, this.j);
            i1 = i2;
            if ((i3 & 0x80) == 128) {
              i1 = i2 | 0x80;
            }
            E2E.Message.ImageMessage.access$2402(localImageMessage, this.k);
            i2 = i1;
            if ((i3 & 0x100) == 256) {
              i2 = i1 | 0x100;
            }
            E2E.Message.ImageMessage.access$2502(localImageMessage, this.l);
            i1 = i2;
            if ((i3 & 0x200) == 512) {
              i1 = i2 | 0x200;
            }
            E2E.Message.ImageMessage.access$2602(localImageMessage, this.m);
            if ((i3 & 0x400) == 1024) {
              i1 |= 0x400;
            }
            for (;;)
            {
              if (this.o == null) {
                E2E.Message.ImageMessage.access$2702(localImageMessage, this.n);
              }
              for (;;)
              {
                E2E.Message.ImageMessage.access$2802(localImageMessage, i1);
                onBuilt();
                return localImageMessage;
                E2E.Message.ImageMessage.access$2702(localImageMessage, (E2E.ContextInfo)this.o.c());
              }
            }
            i2 = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = "";
          this.a &= 0xFFFFFFFB;
          this.e = e.b;
          this.a &= 0xFFFFFFF7;
          this.h = 0L;
          this.a &= 0xFFFFFFEF;
          this.i = 0;
          this.a &= 0xFFFFFFDF;
          this.j = 0;
          this.a &= 0xFFFFFFBF;
          this.k = e.b;
          this.a &= 0xFF7F;
          this.l = e.b;
          this.a &= 0xFEFF;
          this.m = e.b;
          this.a &= 0xFDFF;
          if (this.o == null) {
            this.n = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFBFF;
            return this;
            this.o.f();
          }
        }
        
        public final a clearCaption()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.ImageMessage.getDefaultInstance().getCaption();
          onChanged();
          return this;
        }
        
        public final a clearContextInfo()
        {
          if (this.o == null)
          {
            this.n = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFBFF;
            return this;
            this.o.f();
          }
        }
        
        public final a clearFileEncSha256()
        {
          this.a &= 0xFEFF;
          this.l = E2E.Message.ImageMessage.getDefaultInstance().getFileEncSha256();
          onChanged();
          return this;
        }
        
        public final a clearFileLength()
        {
          this.a &= 0xFFFFFFEF;
          this.h = 0L;
          onChanged();
          return this;
        }
        
        public final a clearFileSha256()
        {
          this.a &= 0xFFFFFFF7;
          this.e = E2E.Message.ImageMessage.getDefaultInstance().getFileSha256();
          onChanged();
          return this;
        }
        
        public final a clearHeight()
        {
          this.a &= 0xFFFFFFDF;
          this.i = 0;
          onChanged();
          return this;
        }
        
        public final a clearJpegThumbnail()
        {
          this.a &= 0xFDFF;
          this.m = E2E.Message.ImageMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final a clearMediaKey()
        {
          this.a &= 0xFF7F;
          this.k = E2E.Message.ImageMessage.getDefaultInstance().getMediaKey();
          onChanged();
          return this;
        }
        
        public final a clearMimetype()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.ImageMessage.getDefaultInstance().getMimetype();
          onChanged();
          return this;
        }
        
        public final a clearUrl()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.ImageMessage.getDefaultInstance().getUrl();
          onChanged();
          return this;
        }
        
        public final a clearWidth()
        {
          this.a &= 0xFFFFFFBF;
          this.j = 0;
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final String getCaption()
        {
          Object localObject = this.d;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.d = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getCaptionBytes()
        {
          Object localObject = this.d;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.d = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.o == null) {
            return this.n;
          }
          return (E2E.ContextInfo)this.o.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x400;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.o != null) {
            return (f.a)this.o.e();
          }
          return this.n;
        }
        
        public final E2E.Message.ImageMessage getDefaultInstanceForType()
        {
          return E2E.Message.ImageMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.e();
        }
        
        public final e getFileEncSha256()
        {
          return this.l;
        }
        
        public final long getFileLength()
        {
          return this.h;
        }
        
        public final e getFileSha256()
        {
          return this.e;
        }
        
        public final int getHeight()
        {
          return this.i;
        }
        
        public final e getJpegThumbnail()
        {
          return this.m;
        }
        
        public final e getMediaKey()
        {
          return this.k;
        }
        
        public final String getMimetype()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getMimetypeBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getUrl()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getUrlBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final int getWidth()
        {
          return this.j;
        }
        
        public final boolean hasCaption()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x400) == 1024;
        }
        
        public final boolean hasFileEncSha256()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasFileLength()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasFileSha256()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasHeight()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x200) == 512;
        }
        
        public final boolean hasMediaKey()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasMimetype()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasUrl()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasWidth()
        {
          return (this.a & 0x40) == 64;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.f().a(E2E.Message.ImageMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.o == null) {
            if (((this.a & 0x400) == 1024) && (this.n != E2E.ContextInfo.getDefaultInstance()))
            {
              this.n = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.n).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.n = paramContextInfo;
            break;
            this.o.b(paramContextInfo);
          }
        }
        
        public final a setCaption(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = paramString;
          onChanged();
          return this;
        }
        
        public final a setCaptionBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.o == null)
          {
            this.n = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.o.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.o == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.n = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x400;
            return this;
            this.o.a(paramContextInfo);
          }
        }
        
        public final a setFileEncSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x100;
          this.l = parame;
          onChanged();
          return this;
        }
        
        public final a setFileLength(long paramLong)
        {
          this.a |= 0x10;
          this.h = paramLong;
          onChanged();
          return this;
        }
        
        public final a setFileSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = parame;
          onChanged();
          return this;
        }
        
        public final a setHeight(int paramInt)
        {
          this.a |= 0x20;
          this.i = paramInt;
          onChanged();
          return this;
        }
        
        public final a setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x200;
          this.m = parame;
          onChanged();
          return this;
        }
        
        public final a setMediaKey(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = parame;
          onChanged();
          return this;
        }
        
        public final a setMimetype(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final a setMimetypeBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final a setWidth(int paramInt)
        {
          this.a |= 0x40;
          this.j = paramInt;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class LiveLocationMessage
      extends o
      implements f.a
    {
      public static final int ACCURACY_IN_METERS_FIELD_NUMBER = 3;
      public static final int CAPTION_FIELD_NUMBER = 6;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int DEGREES_CLOCKWISE_FROM_MAGNETIC_NORTH_FIELD_NUMBER = 5;
      public static final int DEGREES_LATITUDE_FIELD_NUMBER = 1;
      public static final int DEGREES_LONGITUDE_FIELD_NUMBER = 2;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static ae<LiveLocationMessage> PARSER = new c()
      {
        private static E2E.Message.LiveLocationMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.LiveLocationMessage.a locala = E2E.Message.LiveLocationMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int SEQUENCE_NUMBER_FIELD_NUMBER = 7;
      public static final int SPEED_IN_MPS_FIELD_NUMBER = 4;
      private static final LiveLocationMessage defaultInstance;
      private int accuracyInMeters_;
      private int bitField0_;
      private Object caption_;
      private E2E.ContextInfo contextInfo_;
      private int degreesClockwiseFromMagneticNorth_;
      private double degreesLatitude_;
      private double degreesLongitude_;
      private e jpegThumbnail_;
      private long sequenceNumber_;
      private float speedInMps_;
      private final an unknownFields;
      
      static
      {
        LiveLocationMessage localLiveLocationMessage = new LiveLocationMessage(true);
        defaultInstance = localLiveLocationMessage;
        localLiveLocationMessage.initFields();
      }
      
      private LiveLocationMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private LiveLocationMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static LiveLocationMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.k();
      }
      
      private void initFields()
      {
        this.degreesLatitude_ = 0.0D;
        this.degreesLongitude_ = 0.0D;
        this.accuracyInMeters_ = 0;
        this.speedInMps_ = 0.0F;
        this.degreesClockwiseFromMagneticNorth_ = 0;
        this.caption_ = "";
        this.sequenceNumber_ = 0L;
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(LiveLocationMessage paramLiveLocationMessage)
      {
        return (a)newBuilder().mergeFrom(paramLiveLocationMessage);
      }
      
      public static LiveLocationMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (LiveLocationMessage)PARSER.a(paramInputStream);
      }
      
      public static LiveLocationMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (LiveLocationMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static LiveLocationMessage parseFrom(e parame)
      {
        return (LiveLocationMessage)PARSER.a(parame);
      }
      
      public static LiveLocationMessage parseFrom(e parame, m paramm)
      {
        return (LiveLocationMessage)PARSER.a(parame, paramm);
      }
      
      public static LiveLocationMessage parseFrom(f paramf)
      {
        return (LiveLocationMessage)PARSER.a(paramf);
      }
      
      public static LiveLocationMessage parseFrom(f paramf, m paramm)
      {
        return (LiveLocationMessage)PARSER.a(paramf, paramm);
      }
      
      public static LiveLocationMessage parseFrom(InputStream paramInputStream)
      {
        return (LiveLocationMessage)PARSER.b(paramInputStream);
      }
      
      public static LiveLocationMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (LiveLocationMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static LiveLocationMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (LiveLocationMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static LiveLocationMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (LiveLocationMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final int getAccuracyInMeters()
      {
        return this.accuracyInMeters_;
      }
      
      public final String getCaption()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.caption_ = str;
        }
        return str;
      }
      
      public final e getCaptionBytes()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.caption_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final LiveLocationMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final int getDegreesClockwiseFromMagneticNorth()
      {
        return this.degreesClockwiseFromMagneticNorth_;
      }
      
      public final double getDegreesLatitude()
      {
        return this.degreesLatitude_;
      }
      
      public final double getDegreesLongitude()
      {
        return this.degreesLongitude_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final ae<LiveLocationMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final long getSequenceNumber()
      {
        return this.sequenceNumber_;
      }
      
      public final float getSpeedInMps()
      {
        return this.speedInMps_;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasAccuracyInMeters()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasCaption()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasDegreesClockwiseFromMagneticNorth()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final boolean hasDegreesLatitude()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasDegreesLongitude()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasSequenceNumber()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasSpeedInMps()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.l().a(LiveLocationMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private double b;
        private double c;
        private int d;
        private float e;
        private int h;
        private Object i = "";
        private long j;
        private e k = e.b;
        private E2E.ContextInfo l = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> m;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.LiveLocationMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.m == null)
          {
            this.m = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.l = null;
          }
          return this.m;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.k();
        }
        
        public final E2E.Message.LiveLocationMessage build()
        {
          E2E.Message.LiveLocationMessage localLiveLocationMessage = buildPartial();
          if (!localLiveLocationMessage.isInitialized()) {
            throw newUninitializedMessageException(localLiveLocationMessage);
          }
          return localLiveLocationMessage;
        }
        
        public final E2E.Message.LiveLocationMessage buildPartial()
        {
          int i1 = 1;
          E2E.Message.LiveLocationMessage localLiveLocationMessage = new E2E.Message.LiveLocationMessage(this, null);
          int i2 = this.a;
          if ((i2 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.LiveLocationMessage.access$5902(localLiveLocationMessage, this.b);
            int n = i1;
            if ((i2 & 0x2) == 2) {
              n = i1 | 0x2;
            }
            E2E.Message.LiveLocationMessage.access$6002(localLiveLocationMessage, this.c);
            i1 = n;
            if ((i2 & 0x4) == 4) {
              i1 = n | 0x4;
            }
            E2E.Message.LiveLocationMessage.access$6102(localLiveLocationMessage, this.d);
            n = i1;
            if ((i2 & 0x8) == 8) {
              n = i1 | 0x8;
            }
            E2E.Message.LiveLocationMessage.access$6202(localLiveLocationMessage, this.e);
            i1 = n;
            if ((i2 & 0x10) == 16) {
              i1 = n | 0x10;
            }
            E2E.Message.LiveLocationMessage.access$6302(localLiveLocationMessage, this.h);
            n = i1;
            if ((i2 & 0x20) == 32) {
              n = i1 | 0x20;
            }
            E2E.Message.LiveLocationMessage.access$6402(localLiveLocationMessage, this.i);
            i1 = n;
            if ((i2 & 0x40) == 64) {
              i1 = n | 0x40;
            }
            E2E.Message.LiveLocationMessage.access$6502(localLiveLocationMessage, this.j);
            n = i1;
            if ((i2 & 0x80) == 128) {
              n = i1 | 0x80;
            }
            E2E.Message.LiveLocationMessage.access$6602(localLiveLocationMessage, this.k);
            if ((i2 & 0x100) == 256) {
              n |= 0x100;
            }
            for (;;)
            {
              if (this.m == null) {
                E2E.Message.LiveLocationMessage.access$6702(localLiveLocationMessage, this.l);
              }
              for (;;)
              {
                E2E.Message.LiveLocationMessage.access$6802(localLiveLocationMessage, n);
                onBuilt();
                return localLiveLocationMessage;
                E2E.Message.LiveLocationMessage.access$6702(localLiveLocationMessage, (E2E.ContextInfo)this.m.c());
              }
            }
            i1 = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = 0.0D;
          this.a &= 0xFFFFFFFE;
          this.c = 0.0D;
          this.a &= 0xFFFFFFFD;
          this.d = 0;
          this.a &= 0xFFFFFFFB;
          this.e = 0.0F;
          this.a &= 0xFFFFFFF7;
          this.h = 0;
          this.a &= 0xFFFFFFEF;
          this.i = "";
          this.a &= 0xFFFFFFDF;
          this.j = 0L;
          this.a &= 0xFFFFFFBF;
          this.k = e.b;
          this.a &= 0xFF7F;
          if (this.m == null) {
            this.l = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFEFF;
            return this;
            this.m.f();
          }
        }
        
        public final a clearAccuracyInMeters()
        {
          this.a &= 0xFFFFFFFB;
          this.d = 0;
          onChanged();
          return this;
        }
        
        public final a clearCaption()
        {
          this.a &= 0xFFFFFFDF;
          this.i = E2E.Message.LiveLocationMessage.getDefaultInstance().getCaption();
          onChanged();
          return this;
        }
        
        public final a clearContextInfo()
        {
          if (this.m == null)
          {
            this.l = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFEFF;
            return this;
            this.m.f();
          }
        }
        
        public final a clearDegreesClockwiseFromMagneticNorth()
        {
          this.a &= 0xFFFFFFEF;
          this.h = 0;
          onChanged();
          return this;
        }
        
        public final a clearDegreesLatitude()
        {
          this.a &= 0xFFFFFFFE;
          this.b = 0.0D;
          onChanged();
          return this;
        }
        
        public final a clearDegreesLongitude()
        {
          this.a &= 0xFFFFFFFD;
          this.c = 0.0D;
          onChanged();
          return this;
        }
        
        public final a clearJpegThumbnail()
        {
          this.a &= 0xFF7F;
          this.k = E2E.Message.LiveLocationMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final a clearSequenceNumber()
        {
          this.a &= 0xFFFFFFBF;
          this.j = 0L;
          onChanged();
          return this;
        }
        
        public final a clearSpeedInMps()
        {
          this.a &= 0xFFFFFFF7;
          this.e = 0.0F;
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final int getAccuracyInMeters()
        {
          return this.d;
        }
        
        public final String getCaption()
        {
          Object localObject = this.i;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.i = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getCaptionBytes()
        {
          Object localObject = this.i;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.i = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.m == null) {
            return this.l;
          }
          return (E2E.ContextInfo)this.m.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x100;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.m != null) {
            return (f.a)this.m.e();
          }
          return this.l;
        }
        
        public final E2E.Message.LiveLocationMessage getDefaultInstanceForType()
        {
          return E2E.Message.LiveLocationMessage.getDefaultInstance();
        }
        
        public final int getDegreesClockwiseFromMagneticNorth()
        {
          return this.h;
        }
        
        public final double getDegreesLatitude()
        {
          return this.b;
        }
        
        public final double getDegreesLongitude()
        {
          return this.c;
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.k();
        }
        
        public final e getJpegThumbnail()
        {
          return this.k;
        }
        
        public final long getSequenceNumber()
        {
          return this.j;
        }
        
        public final float getSpeedInMps()
        {
          return this.e;
        }
        
        public final boolean hasAccuracyInMeters()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasCaption()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasDegreesClockwiseFromMagneticNorth()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasDegreesLatitude()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasDegreesLongitude()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasSequenceNumber()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasSpeedInMps()
        {
          return (this.a & 0x8) == 8;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.l().a(E2E.Message.LiveLocationMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.m == null) {
            if (((this.a & 0x100) == 256) && (this.l != E2E.ContextInfo.getDefaultInstance()))
            {
              this.l = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.l).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.l = paramContextInfo;
            break;
            this.m.b(paramContextInfo);
          }
        }
        
        public final a setAccuracyInMeters(int paramInt)
        {
          this.a |= 0x4;
          this.d = paramInt;
          onChanged();
          return this;
        }
        
        public final a setCaption(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x20;
          this.i = paramString;
          onChanged();
          return this;
        }
        
        public final a setCaptionBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x20;
          this.i = parame;
          onChanged();
          return this;
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.m == null)
          {
            this.l = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.m.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.m == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.l = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x100;
            return this;
            this.m.a(paramContextInfo);
          }
        }
        
        public final a setDegreesClockwiseFromMagneticNorth(int paramInt)
        {
          this.a |= 0x10;
          this.h = paramInt;
          onChanged();
          return this;
        }
        
        public final a setDegreesLatitude(double paramDouble)
        {
          this.a |= 0x1;
          this.b = paramDouble;
          onChanged();
          return this;
        }
        
        public final a setDegreesLongitude(double paramDouble)
        {
          this.a |= 0x2;
          this.c = paramDouble;
          onChanged();
          return this;
        }
        
        public final a setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x80;
          this.k = parame;
          onChanged();
          return this;
        }
        
        public final a setSequenceNumber(long paramLong)
        {
          this.a |= 0x40;
          this.j = paramLong;
          onChanged();
          return this;
        }
        
        public final a setSpeedInMps(float paramFloat)
        {
          this.a |= 0x8;
          this.e = paramFloat;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class LocationMessage
      extends o
      implements f.a
    {
      public static final int ADDRESS_FIELD_NUMBER = 4;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int DEGREES_LATITUDE_FIELD_NUMBER = 1;
      public static final int DEGREES_LONGITUDE_FIELD_NUMBER = 2;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static final int NAME_FIELD_NUMBER = 3;
      public static ae<LocationMessage> PARSER = new c()
      {
        private static E2E.Message.LocationMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.LocationMessage.a locala = E2E.Message.LocationMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int URL_FIELD_NUMBER = 5;
      private static final LocationMessage defaultInstance;
      private Object address_;
      private int bitField0_;
      private E2E.ContextInfo contextInfo_;
      private double degreesLatitude_;
      private double degreesLongitude_;
      private e jpegThumbnail_;
      private Object name_;
      private final an unknownFields;
      private Object url_;
      
      static
      {
        LocationMessage localLocationMessage = new LocationMessage(true);
        defaultInstance = localLocationMessage;
        localLocationMessage.initFields();
      }
      
      private LocationMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private LocationMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static LocationMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.i();
      }
      
      private void initFields()
      {
        this.degreesLatitude_ = 0.0D;
        this.degreesLongitude_ = 0.0D;
        this.name_ = "";
        this.address_ = "";
        this.url_ = "";
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(LocationMessage paramLocationMessage)
      {
        return (a)newBuilder().mergeFrom(paramLocationMessage);
      }
      
      public static LocationMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (LocationMessage)PARSER.a(paramInputStream);
      }
      
      public static LocationMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (LocationMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static LocationMessage parseFrom(e parame)
      {
        return (LocationMessage)PARSER.a(parame);
      }
      
      public static LocationMessage parseFrom(e parame, m paramm)
      {
        return (LocationMessage)PARSER.a(parame, paramm);
      }
      
      public static LocationMessage parseFrom(f paramf)
      {
        return (LocationMessage)PARSER.a(paramf);
      }
      
      public static LocationMessage parseFrom(f paramf, m paramm)
      {
        return (LocationMessage)PARSER.a(paramf, paramm);
      }
      
      public static LocationMessage parseFrom(InputStream paramInputStream)
      {
        return (LocationMessage)PARSER.b(paramInputStream);
      }
      
      public static LocationMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (LocationMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static LocationMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (LocationMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static LocationMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (LocationMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final String getAddress()
      {
        Object localObject = this.address_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.address_ = str;
        }
        return str;
      }
      
      public final e getAddressBytes()
      {
        Object localObject = this.address_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.address_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final LocationMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final double getDegreesLatitude()
      {
        return this.degreesLatitude_;
      }
      
      public final double getDegreesLongitude()
      {
        return this.degreesLongitude_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final String getName()
      {
        Object localObject = this.name_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.name_ = str;
        }
        return str;
      }
      
      public final e getNameBytes()
      {
        Object localObject = this.name_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.name_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<LocationMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getUrl()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.url_ = str;
        }
        return str;
      }
      
      public final e getUrlBytes()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.url_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final boolean hasAddress()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasDegreesLatitude()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasDegreesLongitude()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasName()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasUrl()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.j().a(LocationMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private double b;
        private double c;
        private Object d = "";
        private Object e = "";
        private Object h = "";
        private e i = e.b;
        private E2E.ContextInfo j = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> k;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.LocationMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.k == null)
          {
            this.k = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.j = null;
          }
          return this.k;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.i();
        }
        
        public final E2E.Message.LocationMessage build()
        {
          E2E.Message.LocationMessage localLocationMessage = buildPartial();
          if (!localLocationMessage.isInitialized()) {
            throw newUninitializedMessageException(localLocationMessage);
          }
          return localLocationMessage;
        }
        
        public final E2E.Message.LocationMessage buildPartial()
        {
          int n = 1;
          E2E.Message.LocationMessage localLocationMessage = new E2E.Message.LocationMessage(this, null);
          int i1 = this.a;
          if ((i1 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.LocationMessage.access$4502(localLocationMessage, this.b);
            int m = n;
            if ((i1 & 0x2) == 2) {
              m = n | 0x2;
            }
            E2E.Message.LocationMessage.access$4602(localLocationMessage, this.c);
            n = m;
            if ((i1 & 0x4) == 4) {
              n = m | 0x4;
            }
            E2E.Message.LocationMessage.access$4702(localLocationMessage, this.d);
            m = n;
            if ((i1 & 0x8) == 8) {
              m = n | 0x8;
            }
            E2E.Message.LocationMessage.access$4802(localLocationMessage, this.e);
            n = m;
            if ((i1 & 0x10) == 16) {
              n = m | 0x10;
            }
            E2E.Message.LocationMessage.access$4902(localLocationMessage, this.h);
            m = n;
            if ((i1 & 0x20) == 32) {
              m = n | 0x20;
            }
            E2E.Message.LocationMessage.access$5002(localLocationMessage, this.i);
            if ((i1 & 0x40) == 64) {
              m |= 0x40;
            }
            for (;;)
            {
              if (this.k == null) {
                E2E.Message.LocationMessage.access$5102(localLocationMessage, this.j);
              }
              for (;;)
              {
                E2E.Message.LocationMessage.access$5202(localLocationMessage, m);
                onBuilt();
                return localLocationMessage;
                E2E.Message.LocationMessage.access$5102(localLocationMessage, (E2E.ContextInfo)this.k.c());
              }
            }
            n = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = 0.0D;
          this.a &= 0xFFFFFFFE;
          this.c = 0.0D;
          this.a &= 0xFFFFFFFD;
          this.d = "";
          this.a &= 0xFFFFFFFB;
          this.e = "";
          this.a &= 0xFFFFFFF7;
          this.h = "";
          this.a &= 0xFFFFFFEF;
          this.i = e.b;
          this.a &= 0xFFFFFFDF;
          if (this.k == null) {
            this.j = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFBF;
            return this;
            this.k.f();
          }
        }
        
        public final a clearAddress()
        {
          this.a &= 0xFFFFFFF7;
          this.e = E2E.Message.LocationMessage.getDefaultInstance().getAddress();
          onChanged();
          return this;
        }
        
        public final a clearContextInfo()
        {
          if (this.k == null)
          {
            this.j = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFBF;
            return this;
            this.k.f();
          }
        }
        
        public final a clearDegreesLatitude()
        {
          this.a &= 0xFFFFFFFE;
          this.b = 0.0D;
          onChanged();
          return this;
        }
        
        public final a clearDegreesLongitude()
        {
          this.a &= 0xFFFFFFFD;
          this.c = 0.0D;
          onChanged();
          return this;
        }
        
        public final a clearJpegThumbnail()
        {
          this.a &= 0xFFFFFFDF;
          this.i = E2E.Message.LocationMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final a clearName()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.LocationMessage.getDefaultInstance().getName();
          onChanged();
          return this;
        }
        
        public final a clearUrl()
        {
          this.a &= 0xFFFFFFEF;
          this.h = E2E.Message.LocationMessage.getDefaultInstance().getUrl();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final String getAddress()
        {
          Object localObject = this.e;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.e = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getAddressBytes()
        {
          Object localObject = this.e;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.e = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.k == null) {
            return this.j;
          }
          return (E2E.ContextInfo)this.k.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x40;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.k != null) {
            return (f.a)this.k.e();
          }
          return this.j;
        }
        
        public final E2E.Message.LocationMessage getDefaultInstanceForType()
        {
          return E2E.Message.LocationMessage.getDefaultInstance();
        }
        
        public final double getDegreesLatitude()
        {
          return this.b;
        }
        
        public final double getDegreesLongitude()
        {
          return this.c;
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.i();
        }
        
        public final e getJpegThumbnail()
        {
          return this.i;
        }
        
        public final String getName()
        {
          Object localObject = this.d;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.d = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getNameBytes()
        {
          Object localObject = this.d;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.d = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final String getUrl()
        {
          Object localObject = this.h;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.h = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getUrlBytes()
        {
          Object localObject = this.h;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.h = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasAddress()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasDegreesLatitude()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasDegreesLongitude()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasName()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasUrl()
        {
          return (this.a & 0x10) == 16;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.j().a(E2E.Message.LocationMessage.class, a.class);
        }
        
        public final a mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.k == null) {
            if (((this.a & 0x40) == 64) && (this.j != E2E.ContextInfo.getDefaultInstance()))
            {
              this.j = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.j).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x40;
            return this;
            this.j = paramContextInfo;
            break;
            this.k.b(paramContextInfo);
          }
        }
        
        public final a setAddress(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = paramString;
          onChanged();
          return this;
        }
        
        public final a setAddressBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x8;
          this.e = parame;
          onChanged();
          return this;
        }
        
        public final a setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.k == null)
          {
            this.j = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x40;
            return this;
            this.k.a(parama.build());
          }
        }
        
        public final a setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.k == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.j = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x40;
            return this;
            this.k.a(paramContextInfo);
          }
        }
        
        public final a setDegreesLatitude(double paramDouble)
        {
          this.a |= 0x1;
          this.b = paramDouble;
          onChanged();
          return this;
        }
        
        public final a setDegreesLongitude(double paramDouble)
        {
          this.a |= 0x2;
          this.c = paramDouble;
          onChanged();
          return this;
        }
        
        public final a setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x20;
          this.i = parame;
          onChanged();
          return this;
        }
        
        public final a setName(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = paramString;
          onChanged();
          return this;
        }
        
        public final a setNameBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final a setUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = paramString;
          onChanged();
          return this;
        }
        
        public final a setUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x10;
          this.h = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class ProtocolMessage
      extends o
      implements f.a
    {
      public static final int KEY_FIELD_NUMBER = 1;
      public static ae<ProtocolMessage> PARSER = new c()
      {
        private static E2E.Message.ProtocolMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.ProtocolMessage.a locala = E2E.Message.ProtocolMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int TYPE_FIELD_NUMBER = 2;
      private static final ProtocolMessage defaultInstance;
      private int bitField0_;
      private Protocol.MessageKey key_;
      private b type_;
      private final an unknownFields;
      
      static
      {
        ProtocolMessage localProtocolMessage = new ProtocolMessage(true);
        defaultInstance = localProtocolMessage;
        localProtocolMessage.initFields();
      }
      
      private ProtocolMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private ProtocolMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static ProtocolMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.K();
      }
      
      private void initFields()
      {
        this.key_ = Protocol.MessageKey.getDefaultInstance();
        this.type_ = b.a;
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(ProtocolMessage paramProtocolMessage)
      {
        return (a)newBuilder().mergeFrom(paramProtocolMessage);
      }
      
      public static ProtocolMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (ProtocolMessage)PARSER.a(paramInputStream);
      }
      
      public static ProtocolMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (ProtocolMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static ProtocolMessage parseFrom(e parame)
      {
        return (ProtocolMessage)PARSER.a(parame);
      }
      
      public static ProtocolMessage parseFrom(e parame, m paramm)
      {
        return (ProtocolMessage)PARSER.a(parame, paramm);
      }
      
      public static ProtocolMessage parseFrom(f paramf)
      {
        return (ProtocolMessage)PARSER.a(paramf);
      }
      
      public static ProtocolMessage parseFrom(f paramf, m paramm)
      {
        return (ProtocolMessage)PARSER.a(paramf, paramm);
      }
      
      public static ProtocolMessage parseFrom(InputStream paramInputStream)
      {
        return (ProtocolMessage)PARSER.b(paramInputStream);
      }
      
      public static ProtocolMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (ProtocolMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static ProtocolMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (ProtocolMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static ProtocolMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (ProtocolMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final ProtocolMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final Protocol.MessageKey getKey()
      {
        return this.key_;
      }
      
      public final f.a getKeyOrBuilder$4ba223dc$1ec9fbcb$5f20f411()
      {
        return this.key_;
      }
      
      public final ae<ProtocolMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final b getType()
      {
        return this.type_;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasKey()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasType()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.L().a(ProtocolMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Protocol.MessageKey b = Protocol.MessageKey.getDefaultInstance();
        private aj<Protocol.MessageKey, Protocol.MessageKey.a, f.a> c;
        private E2E.Message.ProtocolMessage.b d = E2E.Message.ProtocolMessage.b.a;
        
        private a()
        {
          b();
        }
        
        private a(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.ProtocolMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<Protocol.MessageKey, Protocol.MessageKey.a, f.a> c()
        {
          if (this.c == null)
          {
            this.c = new aj(getKey(), getParentForChildren(), this.g);
            this.b = null;
          }
          return this.c;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.K();
        }
        
        public final E2E.Message.ProtocolMessage build()
        {
          E2E.Message.ProtocolMessage localProtocolMessage = buildPartial();
          if (!localProtocolMessage.isInitialized()) {
            throw newUninitializedMessageException(localProtocolMessage);
          }
          return localProtocolMessage;
        }
        
        public final E2E.Message.ProtocolMessage buildPartial()
        {
          E2E.Message.ProtocolMessage localProtocolMessage = new E2E.Message.ProtocolMessage(this, null);
          int k = this.a;
          int i = 0;
          if ((k & 0x1) == 1) {
            i = 1;
          }
          if (this.c == null) {
            E2E.Message.ProtocolMessage.access$22902(localProtocolMessage, this.b);
          }
          for (;;)
          {
            int j = i;
            if ((k & 0x2) == 2) {
              j = i | 0x2;
            }
            E2E.Message.ProtocolMessage.access$23002(localProtocolMessage, this.d);
            E2E.Message.ProtocolMessage.access$23102(localProtocolMessage, j);
            onBuilt();
            return localProtocolMessage;
            E2E.Message.ProtocolMessage.access$22902(localProtocolMessage, (Protocol.MessageKey)this.c.c());
          }
        }
        
        public final a clear()
        {
          super.clear();
          if (this.c == null) {
            this.b = Protocol.MessageKey.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFE;
            this.d = E2E.Message.ProtocolMessage.b.a;
            this.a &= 0xFFFFFFFD;
            return this;
            this.c.f();
          }
        }
        
        public final a clearKey()
        {
          if (this.c == null)
          {
            this.b = Protocol.MessageKey.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xFFFFFFFE;
            return this;
            this.c.f();
          }
        }
        
        public final a clearType()
        {
          this.a &= 0xFFFFFFFD;
          this.d = E2E.Message.ProtocolMessage.b.a;
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final E2E.Message.ProtocolMessage getDefaultInstanceForType()
        {
          return E2E.Message.ProtocolMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.K();
        }
        
        public final Protocol.MessageKey getKey()
        {
          if (this.c == null) {
            return this.b;
          }
          return (Protocol.MessageKey)this.c.b();
        }
        
        public final Protocol.MessageKey.a getKeyBuilder()
        {
          this.a |= 0x1;
          onChanged();
          return (Protocol.MessageKey.a)c().d();
        }
        
        public final f.a getKeyOrBuilder$4ba223dc$1ec9fbcb$5f20f411()
        {
          if (this.c != null) {
            return (f.a)this.c.e();
          }
          return this.b;
        }
        
        public final E2E.Message.ProtocolMessage.b getType()
        {
          return this.d;
        }
        
        public final boolean hasKey()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasType()
        {
          return (this.a & 0x2) == 2;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.L().a(E2E.Message.ProtocolMessage.class, a.class);
        }
        
        public final a mergeKey(Protocol.MessageKey paramMessageKey)
        {
          if (this.c == null) {
            if (((this.a & 0x1) == 1) && (this.b != Protocol.MessageKey.getDefaultInstance()))
            {
              this.b = ((Protocol.MessageKey.a)Protocol.MessageKey.newBuilder(this.b).mergeFrom(paramMessageKey)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x1;
            return this;
            this.b = paramMessageKey;
            break;
            this.c.b(paramMessageKey);
          }
        }
        
        public final a setKey(Protocol.MessageKey.a parama)
        {
          if (this.c == null)
          {
            this.b = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x1;
            return this;
            this.c.a(parama.build());
          }
        }
        
        public final a setKey(Protocol.MessageKey paramMessageKey)
        {
          if (this.c == null)
          {
            if (paramMessageKey == null) {
              throw new NullPointerException();
            }
            this.b = paramMessageKey;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x1;
            return this;
            this.c.a(paramMessageKey);
          }
        }
        
        public final a setType(E2E.Message.ProtocolMessage.b paramb)
        {
          if (paramb == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.d = paramb;
          onChanged();
          return this;
        }
      }
      
      public static enum b
        implements af
      {
        private static f.a<b> b = new f.a() {};
        private static final b[] c = values();
        private final int d = 0;
        private final int e = 0;
        
        private b(int paramInt) {}
        
        public static final i.d getDescriptor()
        {
          return (i.d)E2E.Message.ProtocolMessage.getDescriptor().g().get(0);
        }
        
        public static f.a<b> internalGetValueMap$332b5b32$1ec9fbcb$5f20f411()
        {
          return b;
        }
        
        public static b valueOf(int paramInt)
        {
          switch (paramInt)
          {
          default: 
            return null;
          }
          return a;
        }
        
        public static b valueOf(i.e parame)
        {
          if (parame.c != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
          }
          return c[parame.a];
        }
        
        public final i.d getDescriptorForType()
        {
          return getDescriptor();
        }
        
        public final int getNumber()
        {
          return this.e;
        }
        
        public final i.e getValueDescriptor()
        {
          return (i.e)getDescriptor().d().get(this.d);
        }
      }
    }
    
    public static final class SenderKeyDistributionMessage
      extends o
      implements f.a
    {
      public static final int AXOLOTL_SENDER_KEY_DISTRIBUTION_MESSAGE_FIELD_NUMBER = 2;
      public static final int GROUP_ID_FIELD_NUMBER = 1;
      public static ae<SenderKeyDistributionMessage> PARSER = new c()
      {
        private static E2E.Message.SenderKeyDistributionMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.SenderKeyDistributionMessage.a locala = E2E.Message.SenderKeyDistributionMessage.newBuilder();
          try
          {
            locala.mergeFrom(paramAnonymousf, paramAnonymousm);
            return locala.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = locala.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      private static final SenderKeyDistributionMessage defaultInstance;
      private e axolotlSenderKeyDistributionMessage_;
      private int bitField0_;
      private Object groupId_;
      private final an unknownFields;
      
      static
      {
        SenderKeyDistributionMessage localSenderKeyDistributionMessage = new SenderKeyDistributionMessage(true);
        defaultInstance = localSenderKeyDistributionMessage;
        localSenderKeyDistributionMessage.initFields();
      }
      
      private SenderKeyDistributionMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private SenderKeyDistributionMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static SenderKeyDistributionMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.c();
      }
      
      private void initFields()
      {
        this.groupId_ = "";
        this.axolotlSenderKeyDistributionMessage_ = e.b;
      }
      
      public static a newBuilder()
      {
        return a.a();
      }
      
      public static a newBuilder(SenderKeyDistributionMessage paramSenderKeyDistributionMessage)
      {
        return (a)newBuilder().mergeFrom(paramSenderKeyDistributionMessage);
      }
      
      public static SenderKeyDistributionMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramInputStream);
      }
      
      public static SenderKeyDistributionMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static SenderKeyDistributionMessage parseFrom(e parame)
      {
        return (SenderKeyDistributionMessage)PARSER.a(parame);
      }
      
      public static SenderKeyDistributionMessage parseFrom(e parame, m paramm)
      {
        return (SenderKeyDistributionMessage)PARSER.a(parame, paramm);
      }
      
      public static SenderKeyDistributionMessage parseFrom(f paramf)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramf);
      }
      
      public static SenderKeyDistributionMessage parseFrom(f paramf, m paramm)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramf, paramm);
      }
      
      public static SenderKeyDistributionMessage parseFrom(InputStream paramInputStream)
      {
        return (SenderKeyDistributionMessage)PARSER.b(paramInputStream);
      }
      
      public static SenderKeyDistributionMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (SenderKeyDistributionMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static SenderKeyDistributionMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static SenderKeyDistributionMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (SenderKeyDistributionMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final e getAxolotlSenderKeyDistributionMessage()
      {
        return this.axolotlSenderKeyDistributionMessage_;
      }
      
      public final SenderKeyDistributionMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final String getGroupId()
      {
        Object localObject = this.groupId_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.groupId_ = str;
        }
        return str;
      }
      
      public final e getGroupIdBytes()
      {
        Object localObject = this.groupId_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.groupId_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<SenderKeyDistributionMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final boolean hasAxolotlSenderKeyDistributionMessage()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasGroupId()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.d().a(SenderKeyDistributionMessage.class, a.class);
      }
      
      public final a newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final a newBuilderForType(o.b paramb)
      {
        return new a(paramb, (byte)0);
      }
      
      public final a toBuilder()
      {
        return newBuilder(this);
      }
      
      public static final class a
        extends o.a<a>
        implements f.a
      {
        private int a;
        private Object b = "";
        private e c = e.b;
        
        private a() {}
        
        private a(o.b paramb)
        {
          super();
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.c();
        }
        
        public final E2E.Message.SenderKeyDistributionMessage build()
        {
          E2E.Message.SenderKeyDistributionMessage localSenderKeyDistributionMessage = buildPartial();
          if (!localSenderKeyDistributionMessage.isInitialized()) {
            throw newUninitializedMessageException(localSenderKeyDistributionMessage);
          }
          return localSenderKeyDistributionMessage;
        }
        
        public final E2E.Message.SenderKeyDistributionMessage buildPartial()
        {
          int i = 1;
          E2E.Message.SenderKeyDistributionMessage localSenderKeyDistributionMessage = new E2E.Message.SenderKeyDistributionMessage(this, null);
          int k = this.a;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.SenderKeyDistributionMessage.access$802(localSenderKeyDistributionMessage, this.b);
            int j = i;
            if ((k & 0x2) == 2) {
              j = i | 0x2;
            }
            E2E.Message.SenderKeyDistributionMessage.access$902(localSenderKeyDistributionMessage, this.c);
            E2E.Message.SenderKeyDistributionMessage.access$1002(localSenderKeyDistributionMessage, j);
            onBuilt();
            return localSenderKeyDistributionMessage;
            i = 0;
          }
        }
        
        public final a clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = e.b;
          this.a &= 0xFFFFFFFD;
          return this;
        }
        
        public final a clearAxolotlSenderKeyDistributionMessage()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance().getAxolotlSenderKeyDistributionMessage();
          onChanged();
          return this;
        }
        
        public final a clearGroupId()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance().getGroupId();
          onChanged();
          return this;
        }
        
        public final a clone()
        {
          return (a)new a().mergeFrom(buildPartial());
        }
        
        public final e getAxolotlSenderKeyDistributionMessage()
        {
          return this.c;
        }
        
        public final E2E.Message.SenderKeyDistributionMessage getDefaultInstanceForType()
        {
          return E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.c();
        }
        
        public final String getGroupId()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getGroupIdBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final boolean hasAxolotlSenderKeyDistributionMessage()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasGroupId()
        {
          return (this.a & 0x1) == 1;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.d().a(E2E.Message.SenderKeyDistributionMessage.class, a.class);
        }
        
        public final a setAxolotlSenderKeyDistributionMessage(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final a setGroupId(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final a setGroupIdBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class VideoMessage
      extends o
      implements f.a
    {
      public static final int CAPTION_FIELD_NUMBER = 7;
      public static final int CONTEXT_INFO_FIELD_NUMBER = 17;
      public static final int FILE_ENC_SHA256_FIELD_NUMBER = 11;
      public static final int FILE_LENGTH_FIELD_NUMBER = 4;
      public static final int FILE_SHA256_FIELD_NUMBER = 3;
      public static final int GIF_ATTRIBUTION_FIELD_NUMBER = 19;
      public static final int GIF_PLAYBACK_FIELD_NUMBER = 8;
      public static final int HEIGHT_FIELD_NUMBER = 9;
      public static final int JPEG_THUMBNAIL_FIELD_NUMBER = 16;
      public static final int MEDIA_KEY_FIELD_NUMBER = 6;
      public static final int MIMETYPE_FIELD_NUMBER = 2;
      public static ae<VideoMessage> PARSER = new c()
      {
        private static E2E.Message.VideoMessage c(f paramAnonymousf, m paramAnonymousm)
        {
          E2E.Message.VideoMessage.b localb = E2E.Message.VideoMessage.newBuilder();
          try
          {
            localb.mergeFrom(paramAnonymousf, paramAnonymousm);
            return localb.buildPartial();
          }
          catch (q paramAnonymousf)
          {
            paramAnonymousf.a = localb.buildPartial();
            throw paramAnonymousf;
          }
          catch (IOException paramAnonymousf)
          {
            paramAnonymousf = new q(paramAnonymousf.getMessage());
            paramAnonymousf.a = localb.buildPartial();
            throw paramAnonymousf;
          }
        }
      };
      public static final int SECONDS_FIELD_NUMBER = 5;
      public static final int STREAMING_SIDECAR_FIELD_NUMBER = 18;
      public static final int URL_FIELD_NUMBER = 1;
      public static final int WIDTH_FIELD_NUMBER = 10;
      private static final VideoMessage defaultInstance;
      private int bitField0_;
      private Object caption_;
      private E2E.ContextInfo contextInfo_;
      private e fileEncSha256_;
      private long fileLength_;
      private e fileSha256_;
      private a gifAttribution_;
      private boolean gifPlayback_;
      private int height_;
      private e jpegThumbnail_;
      private e mediaKey_;
      private Object mimetype_;
      private int seconds_;
      private e streamingSidecar_;
      private final an unknownFields;
      private Object url_;
      private int width_;
      
      static
      {
        VideoMessage localVideoMessage = new VideoMessage(true);
        defaultInstance = localVideoMessage;
        localVideoMessage.initFields();
      }
      
      private VideoMessage(o.a<?> parama)
      {
        super();
        this.unknownFields = parama.getUnknownFields();
      }
      
      private VideoMessage(boolean paramBoolean)
      {
        this.unknownFields = an.b();
      }
      
      public static VideoMessage getDefaultInstance()
      {
        return defaultInstance;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.s();
      }
      
      private void initFields()
      {
        this.url_ = "";
        this.mimetype_ = "";
        this.fileSha256_ = e.b;
        this.fileLength_ = 0L;
        this.seconds_ = 0;
        this.mediaKey_ = e.b;
        this.caption_ = "";
        this.gifPlayback_ = false;
        this.height_ = 0;
        this.width_ = 0;
        this.fileEncSha256_ = e.b;
        this.jpegThumbnail_ = e.b;
        this.contextInfo_ = E2E.ContextInfo.getDefaultInstance();
        this.streamingSidecar_ = e.b;
        this.gifAttribution_ = a.a;
      }
      
      public static b newBuilder()
      {
        return b.a();
      }
      
      public static b newBuilder(VideoMessage paramVideoMessage)
      {
        return (b)newBuilder().mergeFrom(paramVideoMessage);
      }
      
      public static VideoMessage parseDelimitedFrom(InputStream paramInputStream)
      {
        return (VideoMessage)PARSER.a(paramInputStream);
      }
      
      public static VideoMessage parseDelimitedFrom(InputStream paramInputStream, m paramm)
      {
        return (VideoMessage)PARSER.a(paramInputStream, paramm);
      }
      
      public static VideoMessage parseFrom(e parame)
      {
        return (VideoMessage)PARSER.a(parame);
      }
      
      public static VideoMessage parseFrom(e parame, m paramm)
      {
        return (VideoMessage)PARSER.a(parame, paramm);
      }
      
      public static VideoMessage parseFrom(f paramf)
      {
        return (VideoMessage)PARSER.a(paramf);
      }
      
      public static VideoMessage parseFrom(f paramf, m paramm)
      {
        return (VideoMessage)PARSER.a(paramf, paramm);
      }
      
      public static VideoMessage parseFrom(InputStream paramInputStream)
      {
        return (VideoMessage)PARSER.b(paramInputStream);
      }
      
      public static VideoMessage parseFrom(InputStream paramInputStream, m paramm)
      {
        return (VideoMessage)PARSER.b(paramInputStream, paramm);
      }
      
      public static VideoMessage parseFrom(byte[] paramArrayOfByte)
      {
        return (VideoMessage)PARSER.a(paramArrayOfByte);
      }
      
      public static VideoMessage parseFrom(byte[] paramArrayOfByte, m paramm)
      {
        return (VideoMessage)PARSER.a(paramArrayOfByte, paramm);
      }
      
      public final String getCaption()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.caption_ = str;
        }
        return str;
      }
      
      public final e getCaptionBytes()
      {
        Object localObject = this.caption_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.caption_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.ContextInfo getContextInfo()
      {
        return this.contextInfo_;
      }
      
      public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
      {
        return this.contextInfo_;
      }
      
      public final VideoMessage getDefaultInstanceForType()
      {
        return defaultInstance;
      }
      
      public final e getFileEncSha256()
      {
        return this.fileEncSha256_;
      }
      
      public final long getFileLength()
      {
        return this.fileLength_;
      }
      
      public final e getFileSha256()
      {
        return this.fileSha256_;
      }
      
      public final a getGifAttribution()
      {
        return this.gifAttribution_;
      }
      
      public final boolean getGifPlayback()
      {
        return this.gifPlayback_;
      }
      
      public final int getHeight()
      {
        return this.height_;
      }
      
      public final e getJpegThumbnail()
      {
        return this.jpegThumbnail_;
      }
      
      public final e getMediaKey()
      {
        return this.mediaKey_;
      }
      
      public final String getMimetype()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.mimetype_ = str;
        }
        return str;
      }
      
      public final e getMimetypeBytes()
      {
        Object localObject = this.mimetype_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.mimetype_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final ae<VideoMessage> getParserForType()
      {
        return PARSER;
      }
      
      public final int getSeconds()
      {
        return this.seconds_;
      }
      
      public final e getStreamingSidecar()
      {
        return this.streamingSidecar_;
      }
      
      public final an getUnknownFields()
      {
        return this.unknownFields;
      }
      
      public final String getUrl()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String)) {
          return (String)localObject;
        }
        localObject = (e)localObject;
        String str = ((e)localObject).e();
        if (((e)localObject).f()) {
          this.url_ = str;
        }
        return str;
      }
      
      public final e getUrlBytes()
      {
        Object localObject = this.url_;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.url_ = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final int getWidth()
      {
        return this.width_;
      }
      
      public final boolean hasCaption()
      {
        return (this.bitField0_ & 0x40) == 64;
      }
      
      public final boolean hasContextInfo()
      {
        return (this.bitField0_ & 0x1000) == 4096;
      }
      
      public final boolean hasFileEncSha256()
      {
        return (this.bitField0_ & 0x400) == 1024;
      }
      
      public final boolean hasFileLength()
      {
        return (this.bitField0_ & 0x8) == 8;
      }
      
      public final boolean hasFileSha256()
      {
        return (this.bitField0_ & 0x4) == 4;
      }
      
      public final boolean hasGifAttribution()
      {
        return (this.bitField0_ & 0x4000) == 16384;
      }
      
      public final boolean hasGifPlayback()
      {
        return (this.bitField0_ & 0x80) == 128;
      }
      
      public final boolean hasHeight()
      {
        return (this.bitField0_ & 0x100) == 256;
      }
      
      public final boolean hasJpegThumbnail()
      {
        return (this.bitField0_ & 0x800) == 2048;
      }
      
      public final boolean hasMediaKey()
      {
        return (this.bitField0_ & 0x20) == 32;
      }
      
      public final boolean hasMimetype()
      {
        return (this.bitField0_ & 0x2) == 2;
      }
      
      public final boolean hasSeconds()
      {
        return (this.bitField0_ & 0x10) == 16;
      }
      
      public final boolean hasStreamingSidecar()
      {
        return (this.bitField0_ & 0x2000) == 8192;
      }
      
      public final boolean hasUrl()
      {
        return (this.bitField0_ & 0x1) == 1;
      }
      
      public final boolean hasWidth()
      {
        return (this.bitField0_ & 0x200) == 512;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.t().a(VideoMessage.class, b.class);
      }
      
      public final b newBuilderForType()
      {
        return newBuilder();
      }
      
      protected final b newBuilderForType(o.b paramb)
      {
        return new b(paramb, (byte)0);
      }
      
      public final b toBuilder()
      {
        return newBuilder(this);
      }
      
      public static enum a
        implements af
      {
        private static f.a<a> d = new f.a() {};
        private static final a[] e = values();
        private final int f;
        private final int g;
        
        private a(int paramInt1, int paramInt2)
        {
          this.f = paramInt1;
          this.g = paramInt2;
        }
        
        public static final i.d getDescriptor()
        {
          return (i.d)E2E.Message.VideoMessage.getDescriptor().g().get(0);
        }
        
        public static f.a<a> internalGetValueMap$332b5b32$1ec9fbcb$5f20f411()
        {
          return d;
        }
        
        public static a valueOf(int paramInt)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 0: 
            return a;
          case 1: 
            return b;
          }
          return c;
        }
        
        public static a valueOf(i.e parame)
        {
          if (parame.c != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
          }
          return e[parame.a];
        }
        
        public final i.d getDescriptorForType()
        {
          return getDescriptor();
        }
        
        public final int getNumber()
        {
          return this.g;
        }
        
        public final i.e getValueDescriptor()
        {
          return (i.e)getDescriptor().d().get(this.f);
        }
      }
      
      public static final class b
        extends o.a<b>
        implements f.a
      {
        private int a;
        private Object b = "";
        private Object c = "";
        private e d = e.b;
        private long e;
        private int h;
        private e i = e.b;
        private Object j = "";
        private boolean k;
        private int l;
        private int m;
        private e n = e.b;
        private e o = e.b;
        private E2E.ContextInfo p = E2E.ContextInfo.getDefaultInstance();
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> q;
        private e r = e.b;
        private E2E.Message.VideoMessage.a s = E2E.Message.VideoMessage.a.a;
        
        private b()
        {
          b();
        }
        
        private b(o.b paramb)
        {
          super();
          b();
        }
        
        private void b()
        {
          if (E2E.Message.VideoMessage.alwaysUseFieldBuilders) {
            c();
          }
        }
        
        private aj<E2E.ContextInfo, E2E.ContextInfo.a, f.a> c()
        {
          if (this.q == null)
          {
            this.q = new aj(getContextInfo(), getParentForChildren(), this.g);
            this.p = null;
          }
          return this.q;
        }
        
        public static final i.a getDescriptor()
        {
          return E2E.s();
        }
        
        public final E2E.Message.VideoMessage build()
        {
          E2E.Message.VideoMessage localVideoMessage = buildPartial();
          if (!localVideoMessage.isInitialized()) {
            throw newUninitializedMessageException(localVideoMessage);
          }
          return localVideoMessage;
        }
        
        public final E2E.Message.VideoMessage buildPartial()
        {
          int i2 = 1;
          E2E.Message.VideoMessage localVideoMessage = new E2E.Message.VideoMessage(this, null);
          int i3 = this.a;
          if ((i3 & 0x1) == 1) {}
          for (;;)
          {
            E2E.Message.VideoMessage.access$12702(localVideoMessage, this.b);
            int i1 = i2;
            if ((i3 & 0x2) == 2) {
              i1 = i2 | 0x2;
            }
            E2E.Message.VideoMessage.access$12802(localVideoMessage, this.c);
            i2 = i1;
            if ((i3 & 0x4) == 4) {
              i2 = i1 | 0x4;
            }
            E2E.Message.VideoMessage.access$12902(localVideoMessage, this.d);
            i1 = i2;
            if ((i3 & 0x8) == 8) {
              i1 = i2 | 0x8;
            }
            E2E.Message.VideoMessage.access$13002(localVideoMessage, this.e);
            i2 = i1;
            if ((i3 & 0x10) == 16) {
              i2 = i1 | 0x10;
            }
            E2E.Message.VideoMessage.access$13102(localVideoMessage, this.h);
            i1 = i2;
            if ((i3 & 0x20) == 32) {
              i1 = i2 | 0x20;
            }
            E2E.Message.VideoMessage.access$13202(localVideoMessage, this.i);
            i2 = i1;
            if ((i3 & 0x40) == 64) {
              i2 = i1 | 0x40;
            }
            E2E.Message.VideoMessage.access$13302(localVideoMessage, this.j);
            i1 = i2;
            if ((i3 & 0x80) == 128) {
              i1 = i2 | 0x80;
            }
            E2E.Message.VideoMessage.access$13402(localVideoMessage, this.k);
            i2 = i1;
            if ((i3 & 0x100) == 256) {
              i2 = i1 | 0x100;
            }
            E2E.Message.VideoMessage.access$13502(localVideoMessage, this.l);
            i1 = i2;
            if ((i3 & 0x200) == 512) {
              i1 = i2 | 0x200;
            }
            E2E.Message.VideoMessage.access$13602(localVideoMessage, this.m);
            i2 = i1;
            if ((i3 & 0x400) == 1024) {
              i2 = i1 | 0x400;
            }
            E2E.Message.VideoMessage.access$13702(localVideoMessage, this.n);
            i1 = i2;
            if ((i3 & 0x800) == 2048) {
              i1 = i2 | 0x800;
            }
            E2E.Message.VideoMessage.access$13802(localVideoMessage, this.o);
            if ((i3 & 0x1000) == 4096) {}
            for (i2 = i1 | 0x1000;; i2 = i1)
            {
              if (this.q == null) {
                E2E.Message.VideoMessage.access$13902(localVideoMessage, this.p);
              }
              for (;;)
              {
                i1 = i2;
                if ((i3 & 0x2000) == 8192) {
                  i1 = i2 | 0x2000;
                }
                E2E.Message.VideoMessage.access$14002(localVideoMessage, this.r);
                i2 = i1;
                if ((i3 & 0x4000) == 16384) {
                  i2 = i1 | 0x4000;
                }
                E2E.Message.VideoMessage.access$14102(localVideoMessage, this.s);
                E2E.Message.VideoMessage.access$14202(localVideoMessage, i2);
                onBuilt();
                return localVideoMessage;
                E2E.Message.VideoMessage.access$13902(localVideoMessage, (E2E.ContextInfo)this.q.c());
              }
            }
            i2 = 0;
          }
        }
        
        public final b clear()
        {
          super.clear();
          this.b = "";
          this.a &= 0xFFFFFFFE;
          this.c = "";
          this.a &= 0xFFFFFFFD;
          this.d = e.b;
          this.a &= 0xFFFFFFFB;
          this.e = 0L;
          this.a &= 0xFFFFFFF7;
          this.h = 0;
          this.a &= 0xFFFFFFEF;
          this.i = e.b;
          this.a &= 0xFFFFFFDF;
          this.j = "";
          this.a &= 0xFFFFFFBF;
          this.k = false;
          this.a &= 0xFF7F;
          this.l = 0;
          this.a &= 0xFEFF;
          this.m = 0;
          this.a &= 0xFDFF;
          this.n = e.b;
          this.a &= 0xFBFF;
          this.o = e.b;
          this.a &= 0xF7FF;
          if (this.q == null) {
            this.p = E2E.ContextInfo.getDefaultInstance();
          }
          for (;;)
          {
            this.a &= 0xEFFF;
            this.r = e.b;
            this.a &= 0xDFFF;
            this.s = E2E.Message.VideoMessage.a.a;
            this.a &= 0xBFFF;
            return this;
            this.q.f();
          }
        }
        
        public final b clearCaption()
        {
          this.a &= 0xFFFFFFBF;
          this.j = E2E.Message.VideoMessage.getDefaultInstance().getCaption();
          onChanged();
          return this;
        }
        
        public final b clearContextInfo()
        {
          if (this.q == null)
          {
            this.p = E2E.ContextInfo.getDefaultInstance();
            onChanged();
          }
          for (;;)
          {
            this.a &= 0xEFFF;
            return this;
            this.q.f();
          }
        }
        
        public final b clearFileEncSha256()
        {
          this.a &= 0xFBFF;
          this.n = E2E.Message.VideoMessage.getDefaultInstance().getFileEncSha256();
          onChanged();
          return this;
        }
        
        public final b clearFileLength()
        {
          this.a &= 0xFFFFFFF7;
          this.e = 0L;
          onChanged();
          return this;
        }
        
        public final b clearFileSha256()
        {
          this.a &= 0xFFFFFFFB;
          this.d = E2E.Message.VideoMessage.getDefaultInstance().getFileSha256();
          onChanged();
          return this;
        }
        
        public final b clearGifAttribution()
        {
          this.a &= 0xBFFF;
          this.s = E2E.Message.VideoMessage.a.a;
          onChanged();
          return this;
        }
        
        public final b clearGifPlayback()
        {
          this.a &= 0xFF7F;
          this.k = false;
          onChanged();
          return this;
        }
        
        public final b clearHeight()
        {
          this.a &= 0xFEFF;
          this.l = 0;
          onChanged();
          return this;
        }
        
        public final b clearJpegThumbnail()
        {
          this.a &= 0xF7FF;
          this.o = E2E.Message.VideoMessage.getDefaultInstance().getJpegThumbnail();
          onChanged();
          return this;
        }
        
        public final b clearMediaKey()
        {
          this.a &= 0xFFFFFFDF;
          this.i = E2E.Message.VideoMessage.getDefaultInstance().getMediaKey();
          onChanged();
          return this;
        }
        
        public final b clearMimetype()
        {
          this.a &= 0xFFFFFFFD;
          this.c = E2E.Message.VideoMessage.getDefaultInstance().getMimetype();
          onChanged();
          return this;
        }
        
        public final b clearSeconds()
        {
          this.a &= 0xFFFFFFEF;
          this.h = 0;
          onChanged();
          return this;
        }
        
        public final b clearStreamingSidecar()
        {
          this.a &= 0xDFFF;
          this.r = E2E.Message.VideoMessage.getDefaultInstance().getStreamingSidecar();
          onChanged();
          return this;
        }
        
        public final b clearUrl()
        {
          this.a &= 0xFFFFFFFE;
          this.b = E2E.Message.VideoMessage.getDefaultInstance().getUrl();
          onChanged();
          return this;
        }
        
        public final b clearWidth()
        {
          this.a &= 0xFDFF;
          this.m = 0;
          onChanged();
          return this;
        }
        
        public final b clone()
        {
          return (b)new b().mergeFrom(buildPartial());
        }
        
        public final String getCaption()
        {
          Object localObject = this.j;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.j = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getCaptionBytes()
        {
          Object localObject = this.j;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.j = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final E2E.ContextInfo getContextInfo()
        {
          if (this.q == null) {
            return this.p;
          }
          return (E2E.ContextInfo)this.q.b();
        }
        
        public final E2E.ContextInfo.a getContextInfoBuilder()
        {
          this.a |= 0x1000;
          onChanged();
          return (E2E.ContextInfo.a)c().d();
        }
        
        public final f.a getContextInfoOrBuilder$23c11149$1ec9fbcb$5f20f411()
        {
          if (this.q != null) {
            return (f.a)this.q.e();
          }
          return this.p;
        }
        
        public final E2E.Message.VideoMessage getDefaultInstanceForType()
        {
          return E2E.Message.VideoMessage.getDefaultInstance();
        }
        
        public final i.a getDescriptorForType()
        {
          return E2E.s();
        }
        
        public final e getFileEncSha256()
        {
          return this.n;
        }
        
        public final long getFileLength()
        {
          return this.e;
        }
        
        public final e getFileSha256()
        {
          return this.d;
        }
        
        public final E2E.Message.VideoMessage.a getGifAttribution()
        {
          return this.s;
        }
        
        public final boolean getGifPlayback()
        {
          return this.k;
        }
        
        public final int getHeight()
        {
          return this.l;
        }
        
        public final e getJpegThumbnail()
        {
          return this.o;
        }
        
        public final e getMediaKey()
        {
          return this.i;
        }
        
        public final String getMimetype()
        {
          Object localObject = this.c;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.c = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getMimetypeBytes()
        {
          Object localObject = this.c;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.c = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final int getSeconds()
        {
          return this.h;
        }
        
        public final e getStreamingSidecar()
        {
          return this.r;
        }
        
        public final String getUrl()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            localObject = (e)localObject;
            String str = ((e)localObject).e();
            if (((e)localObject).f()) {
              this.b = str;
            }
            return str;
          }
          return (String)localObject;
        }
        
        public final e getUrlBytes()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            localObject = e.a((String)localObject);
            this.b = localObject;
            return (e)localObject;
          }
          return (e)localObject;
        }
        
        public final int getWidth()
        {
          return this.m;
        }
        
        public final boolean hasCaption()
        {
          return (this.a & 0x40) == 64;
        }
        
        public final boolean hasContextInfo()
        {
          return (this.a & 0x1000) == 4096;
        }
        
        public final boolean hasFileEncSha256()
        {
          return (this.a & 0x400) == 1024;
        }
        
        public final boolean hasFileLength()
        {
          return (this.a & 0x8) == 8;
        }
        
        public final boolean hasFileSha256()
        {
          return (this.a & 0x4) == 4;
        }
        
        public final boolean hasGifAttribution()
        {
          return (this.a & 0x4000) == 16384;
        }
        
        public final boolean hasGifPlayback()
        {
          return (this.a & 0x80) == 128;
        }
        
        public final boolean hasHeight()
        {
          return (this.a & 0x100) == 256;
        }
        
        public final boolean hasJpegThumbnail()
        {
          return (this.a & 0x800) == 2048;
        }
        
        public final boolean hasMediaKey()
        {
          return (this.a & 0x20) == 32;
        }
        
        public final boolean hasMimetype()
        {
          return (this.a & 0x2) == 2;
        }
        
        public final boolean hasSeconds()
        {
          return (this.a & 0x10) == 16;
        }
        
        public final boolean hasStreamingSidecar()
        {
          return (this.a & 0x2000) == 8192;
        }
        
        public final boolean hasUrl()
        {
          return (this.a & 0x1) == 1;
        }
        
        public final boolean hasWidth()
        {
          return (this.a & 0x200) == 512;
        }
        
        protected final o.f internalGetFieldAccessorTable()
        {
          return E2E.t().a(E2E.Message.VideoMessage.class, b.class);
        }
        
        public final b mergeContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.q == null) {
            if (((this.a & 0x1000) == 4096) && (this.p != E2E.ContextInfo.getDefaultInstance()))
            {
              this.p = ((E2E.ContextInfo.a)E2E.ContextInfo.newBuilder(this.p).mergeFrom(paramContextInfo)).buildPartial();
              onChanged();
            }
          }
          for (;;)
          {
            this.a |= 0x1000;
            return this;
            this.p = paramContextInfo;
            break;
            this.q.b(paramContextInfo);
          }
        }
        
        public final b setCaption(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x40;
          this.j = paramString;
          onChanged();
          return this;
        }
        
        public final b setCaptionBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x40;
          this.j = parame;
          onChanged();
          return this;
        }
        
        public final b setContextInfo(E2E.ContextInfo.a parama)
        {
          if (this.q == null)
          {
            this.p = parama.build();
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x1000;
            return this;
            this.q.a(parama.build());
          }
        }
        
        public final b setContextInfo(E2E.ContextInfo paramContextInfo)
        {
          if (this.q == null)
          {
            if (paramContextInfo == null) {
              throw new NullPointerException();
            }
            this.p = paramContextInfo;
            onChanged();
          }
          for (;;)
          {
            this.a |= 0x1000;
            return this;
            this.q.a(paramContextInfo);
          }
        }
        
        public final b setFileEncSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x400;
          this.n = parame;
          onChanged();
          return this;
        }
        
        public final b setFileLength(long paramLong)
        {
          this.a |= 0x8;
          this.e = paramLong;
          onChanged();
          return this;
        }
        
        public final b setFileSha256(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4;
          this.d = parame;
          onChanged();
          return this;
        }
        
        public final b setGifAttribution(E2E.Message.VideoMessage.a parama)
        {
          if (parama == null) {
            throw new NullPointerException();
          }
          this.a |= 0x4000;
          this.s = parama;
          onChanged();
          return this;
        }
        
        public final b setGifPlayback(boolean paramBoolean)
        {
          this.a |= 0x80;
          this.k = paramBoolean;
          onChanged();
          return this;
        }
        
        public final b setHeight(int paramInt)
        {
          this.a |= 0x100;
          this.l = paramInt;
          onChanged();
          return this;
        }
        
        public final b setJpegThumbnail(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x800;
          this.o = parame;
          onChanged();
          return this;
        }
        
        public final b setMediaKey(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x20;
          this.i = parame;
          onChanged();
          return this;
        }
        
        public final b setMimetype(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = paramString;
          onChanged();
          return this;
        }
        
        public final b setMimetypeBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2;
          this.c = parame;
          onChanged();
          return this;
        }
        
        public final b setSeconds(int paramInt)
        {
          this.a |= 0x10;
          this.h = paramInt;
          onChanged();
          return this;
        }
        
        public final b setStreamingSidecar(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x2000;
          this.r = parame;
          onChanged();
          return this;
        }
        
        public final b setUrl(String paramString)
        {
          if (paramString == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = paramString;
          onChanged();
          return this;
        }
        
        public final b setUrlBytes(e parame)
        {
          if (parame == null) {
            throw new NullPointerException();
          }
          this.a |= 0x1;
          this.b = parame;
          onChanged();
          return this;
        }
        
        public final b setWidth(int paramInt)
        {
          this.a |= 0x200;
          this.m = paramInt;
          onChanged();
          return this;
        }
      }
    }
    
    public static final class a
      extends o.a<a>
      implements f.a
    {
      private E2E.Message.ContactsArrayMessage A = E2E.Message.ContactsArrayMessage.getDefaultInstance();
      private aj<E2E.Message.ContactsArrayMessage, E2E.Message.ContactsArrayMessage.a, f.a> B;
      private E2E.Message.HighlyStructuredMessage C = E2E.Message.HighlyStructuredMessage.getDefaultInstance();
      private aj<E2E.Message.HighlyStructuredMessage, E2E.Message.HighlyStructuredMessage.a, f.a> D;
      private E2E.Message.SenderKeyDistributionMessage E = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
      private aj<E2E.Message.SenderKeyDistributionMessage, E2E.Message.SenderKeyDistributionMessage.a, f.a> F;
      private E2E.Message.LiveLocationMessage G = E2E.Message.LiveLocationMessage.getDefaultInstance();
      private aj<E2E.Message.LiveLocationMessage, E2E.Message.LiveLocationMessage.a, f.a> H;
      private int a;
      private Object b = "";
      private E2E.Message.SenderKeyDistributionMessage c = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
      private aj<E2E.Message.SenderKeyDistributionMessage, E2E.Message.SenderKeyDistributionMessage.a, f.a> d;
      private E2E.Message.ImageMessage e = E2E.Message.ImageMessage.getDefaultInstance();
      private aj<E2E.Message.ImageMessage, E2E.Message.ImageMessage.a, f.a> h;
      private E2E.Message.ContactMessage i = E2E.Message.ContactMessage.getDefaultInstance();
      private aj<E2E.Message.ContactMessage, E2E.Message.ContactMessage.a, f.a> j;
      private E2E.Message.LocationMessage k = E2E.Message.LocationMessage.getDefaultInstance();
      private aj<E2E.Message.LocationMessage, E2E.Message.LocationMessage.a, f.a> l;
      private E2E.Message.ExtendedTextMessage m = E2E.Message.ExtendedTextMessage.getDefaultInstance();
      private aj<E2E.Message.ExtendedTextMessage, E2E.Message.ExtendedTextMessage.a, f.a> n;
      private E2E.Message.DocumentMessage o = E2E.Message.DocumentMessage.getDefaultInstance();
      private aj<E2E.Message.DocumentMessage, E2E.Message.DocumentMessage.a, f.a> p;
      private E2E.Message.AudioMessage q = E2E.Message.AudioMessage.getDefaultInstance();
      private aj<E2E.Message.AudioMessage, E2E.Message.AudioMessage.a, f.a> r;
      private E2E.Message.VideoMessage s = E2E.Message.VideoMessage.getDefaultInstance();
      private aj<E2E.Message.VideoMessage, E2E.Message.VideoMessage.b, f.a> t;
      private E2E.Message.Call u = E2E.Message.Call.getDefaultInstance();
      private aj<E2E.Message.Call, E2E.Message.Call.a, f.a> v;
      private E2E.Message.Chat w = E2E.Message.Chat.getDefaultInstance();
      private aj<E2E.Message.Chat, E2E.Message.Chat.a, f.a> x;
      private E2E.Message.ProtocolMessage y = E2E.Message.ProtocolMessage.getDefaultInstance();
      private aj<E2E.Message.ProtocolMessage, E2E.Message.ProtocolMessage.a, f.a> z;
      
      private a()
      {
        b();
      }
      
      private a(o.b paramb)
      {
        super();
        b();
      }
      
      private void b()
      {
        if (E2E.Message.alwaysUseFieldBuilders)
        {
          c();
          d();
          f();
          g();
          h();
          i();
          j();
          k();
          l();
          m();
          n();
          o();
          p();
          q();
          r();
        }
      }
      
      private aj<E2E.Message.SenderKeyDistributionMessage, E2E.Message.SenderKeyDistributionMessage.a, f.a> c()
      {
        if (this.d == null)
        {
          this.d = new aj(getSenderKeyDistributionMessage(), getParentForChildren(), this.g);
          this.c = null;
        }
        return this.d;
      }
      
      private aj<E2E.Message.ImageMessage, E2E.Message.ImageMessage.a, f.a> d()
      {
        if (this.h == null)
        {
          this.h = new aj(getImageMessage(), getParentForChildren(), this.g);
          this.e = null;
        }
        return this.h;
      }
      
      private aj<E2E.Message.ContactMessage, E2E.Message.ContactMessage.a, f.a> f()
      {
        if (this.j == null)
        {
          this.j = new aj(getContactMessage(), getParentForChildren(), this.g);
          this.i = null;
        }
        return this.j;
      }
      
      private aj<E2E.Message.LocationMessage, E2E.Message.LocationMessage.a, f.a> g()
      {
        if (this.l == null)
        {
          this.l = new aj(getLocationMessage(), getParentForChildren(), this.g);
          this.k = null;
        }
        return this.l;
      }
      
      public static final i.a getDescriptor()
      {
        return E2E.a();
      }
      
      private aj<E2E.Message.ExtendedTextMessage, E2E.Message.ExtendedTextMessage.a, f.a> h()
      {
        if (this.n == null)
        {
          this.n = new aj(getExtendedTextMessage(), getParentForChildren(), this.g);
          this.m = null;
        }
        return this.n;
      }
      
      private aj<E2E.Message.DocumentMessage, E2E.Message.DocumentMessage.a, f.a> i()
      {
        if (this.p == null)
        {
          this.p = new aj(getDocumentMessage(), getParentForChildren(), this.g);
          this.o = null;
        }
        return this.p;
      }
      
      private aj<E2E.Message.AudioMessage, E2E.Message.AudioMessage.a, f.a> j()
      {
        if (this.r == null)
        {
          this.r = new aj(getAudioMessage(), getParentForChildren(), this.g);
          this.q = null;
        }
        return this.r;
      }
      
      private aj<E2E.Message.VideoMessage, E2E.Message.VideoMessage.b, f.a> k()
      {
        if (this.t == null)
        {
          this.t = new aj(getVideoMessage(), getParentForChildren(), this.g);
          this.s = null;
        }
        return this.t;
      }
      
      private aj<E2E.Message.Call, E2E.Message.Call.a, f.a> l()
      {
        if (this.v == null)
        {
          this.v = new aj(getCall(), getParentForChildren(), this.g);
          this.u = null;
        }
        return this.v;
      }
      
      private aj<E2E.Message.Chat, E2E.Message.Chat.a, f.a> m()
      {
        if (this.x == null)
        {
          this.x = new aj(getChat(), getParentForChildren(), this.g);
          this.w = null;
        }
        return this.x;
      }
      
      private aj<E2E.Message.ProtocolMessage, E2E.Message.ProtocolMessage.a, f.a> n()
      {
        if (this.z == null)
        {
          this.z = new aj(getProtocolMessage(), getParentForChildren(), this.g);
          this.y = null;
        }
        return this.z;
      }
      
      private aj<E2E.Message.ContactsArrayMessage, E2E.Message.ContactsArrayMessage.a, f.a> o()
      {
        if (this.B == null)
        {
          this.B = new aj(getContactsArrayMessage(), getParentForChildren(), this.g);
          this.A = null;
        }
        return this.B;
      }
      
      private aj<E2E.Message.HighlyStructuredMessage, E2E.Message.HighlyStructuredMessage.a, f.a> p()
      {
        if (this.D == null)
        {
          this.D = new aj(getHighlyStructuredMessage(), getParentForChildren(), this.g);
          this.C = null;
        }
        return this.D;
      }
      
      private aj<E2E.Message.SenderKeyDistributionMessage, E2E.Message.SenderKeyDistributionMessage.a, f.a> q()
      {
        if (this.F == null)
        {
          this.F = new aj(getFastRatchetKeySenderKeyDistributionMessage(), getParentForChildren(), this.g);
          this.E = null;
        }
        return this.F;
      }
      
      private aj<E2E.Message.LiveLocationMessage, E2E.Message.LiveLocationMessage.a, f.a> r()
      {
        if (this.H == null)
        {
          this.H = new aj(getLiveLocationMessage(), getParentForChildren(), this.g);
          this.G = null;
        }
        return this.H;
      }
      
      public final E2E.Message build()
      {
        E2E.Message localMessage = buildPartial();
        if (!localMessage.isInitialized()) {
          throw newUninitializedMessageException(localMessage);
        }
        return localMessage;
      }
      
      public final E2E.Message buildPartial()
      {
        int i1 = 1;
        E2E.Message localMessage = new E2E.Message(this, null);
        int i3 = this.a;
        if ((i3 & 0x1) == 1) {}
        for (;;)
        {
          E2E.Message.access$24602(localMessage, this.b);
          if ((i3 & 0x2) == 2) {}
          for (int i2 = i1 | 0x2;; i2 = i1)
          {
            if (this.d == null)
            {
              E2E.Message.access$24702(localMessage, this.c);
              i1 = i2;
              if ((i3 & 0x4) == 4) {
                i1 = i2 | 0x4;
              }
              if (this.h != null) {
                break label582;
              }
              E2E.Message.access$24802(localMessage, this.e);
              label93:
              i2 = i1;
              if ((i3 & 0x8) == 8) {
                i2 = i1 | 0x8;
              }
              if (this.j != null) {
                break label601;
              }
              E2E.Message.access$24902(localMessage, this.i);
              label126:
              i1 = i2;
              if ((i3 & 0x10) == 16) {
                i1 = i2 | 0x10;
              }
              if (this.l != null) {
                break label620;
              }
              E2E.Message.access$25002(localMessage, this.k);
              label159:
              i2 = i1;
              if ((i3 & 0x20) == 32) {
                i2 = i1 | 0x20;
              }
              if (this.n != null) {
                break label639;
              }
              E2E.Message.access$25102(localMessage, this.m);
              label192:
              i1 = i2;
              if ((i3 & 0x40) == 64) {
                i1 = i2 | 0x40;
              }
              if (this.p != null) {
                break label658;
              }
              E2E.Message.access$25202(localMessage, this.o);
              label225:
              i2 = i1;
              if ((i3 & 0x80) == 128) {
                i2 = i1 | 0x80;
              }
              if (this.r != null) {
                break label677;
              }
              E2E.Message.access$25302(localMessage, this.q);
              label261:
              i1 = i2;
              if ((i3 & 0x100) == 256) {
                i1 = i2 | 0x100;
              }
              if (this.t != null) {
                break label696;
              }
              E2E.Message.access$25402(localMessage, this.s);
              label297:
              i2 = i1;
              if ((i3 & 0x200) == 512) {
                i2 = i1 | 0x200;
              }
              if (this.v != null) {
                break label715;
              }
              E2E.Message.access$25502(localMessage, this.u);
              label333:
              i1 = i2;
              if ((i3 & 0x400) == 1024) {
                i1 = i2 | 0x400;
              }
              if (this.x != null) {
                break label734;
              }
              E2E.Message.access$25602(localMessage, this.w);
              label369:
              i2 = i1;
              if ((i3 & 0x800) == 2048) {
                i2 = i1 | 0x800;
              }
              if (this.z != null) {
                break label753;
              }
              E2E.Message.access$25702(localMessage, this.y);
              label405:
              i1 = i2;
              if ((i3 & 0x1000) == 4096) {
                i1 = i2 | 0x1000;
              }
              if (this.B != null) {
                break label772;
              }
              E2E.Message.access$25802(localMessage, this.A);
              label441:
              i2 = i1;
              if ((i3 & 0x2000) == 8192) {
                i2 = i1 | 0x2000;
              }
              if (this.D != null) {
                break label791;
              }
              E2E.Message.access$25902(localMessage, this.C);
              label477:
              i1 = i2;
              if ((i3 & 0x4000) == 16384) {
                i1 = i2 | 0x4000;
              }
              if (this.F != null) {
                break label810;
              }
              E2E.Message.access$26002(localMessage, this.E);
              label513:
              i2 = i1;
              if ((i3 & 0x8000) == 32768) {
                i2 = i1 | 0x8000;
              }
              if (this.H != null) {
                break label829;
              }
              E2E.Message.access$26102(localMessage, this.G);
            }
            for (;;)
            {
              E2E.Message.access$26202(localMessage, i2);
              onBuilt();
              return localMessage;
              E2E.Message.access$24702(localMessage, (E2E.Message.SenderKeyDistributionMessage)this.d.c());
              break;
              label582:
              E2E.Message.access$24802(localMessage, (E2E.Message.ImageMessage)this.h.c());
              break label93;
              label601:
              E2E.Message.access$24902(localMessage, (E2E.Message.ContactMessage)this.j.c());
              break label126;
              label620:
              E2E.Message.access$25002(localMessage, (E2E.Message.LocationMessage)this.l.c());
              break label159;
              label639:
              E2E.Message.access$25102(localMessage, (E2E.Message.ExtendedTextMessage)this.n.c());
              break label192;
              label658:
              E2E.Message.access$25202(localMessage, (E2E.Message.DocumentMessage)this.p.c());
              break label225;
              label677:
              E2E.Message.access$25302(localMessage, (E2E.Message.AudioMessage)this.r.c());
              break label261;
              label696:
              E2E.Message.access$25402(localMessage, (E2E.Message.VideoMessage)this.t.c());
              break label297;
              label715:
              E2E.Message.access$25502(localMessage, (E2E.Message.Call)this.v.c());
              break label333;
              label734:
              E2E.Message.access$25602(localMessage, (E2E.Message.Chat)this.x.c());
              break label369;
              label753:
              E2E.Message.access$25702(localMessage, (E2E.Message.ProtocolMessage)this.z.c());
              break label405;
              label772:
              E2E.Message.access$25802(localMessage, (E2E.Message.ContactsArrayMessage)this.B.c());
              break label441;
              label791:
              E2E.Message.access$25902(localMessage, (E2E.Message.HighlyStructuredMessage)this.D.c());
              break label477;
              label810:
              E2E.Message.access$26002(localMessage, (E2E.Message.SenderKeyDistributionMessage)this.F.c());
              break label513;
              label829:
              E2E.Message.access$26102(localMessage, (E2E.Message.LiveLocationMessage)this.H.c());
            }
          }
          i1 = 0;
        }
      }
      
      public final a clear()
      {
        super.clear();
        this.b = "";
        this.a &= 0xFFFFFFFE;
        if (this.d == null)
        {
          this.c = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
          this.a &= 0xFFFFFFFD;
          if (this.h != null) {
            break label419;
          }
          this.e = E2E.Message.ImageMessage.getDefaultInstance();
          label61:
          this.a &= 0xFFFFFFFB;
          if (this.j != null) {
            break label430;
          }
          this.i = E2E.Message.ContactMessage.getDefaultInstance();
          label86:
          this.a &= 0xFFFFFFF7;
          if (this.l != null) {
            break label441;
          }
          this.k = E2E.Message.LocationMessage.getDefaultInstance();
          label111:
          this.a &= 0xFFFFFFEF;
          if (this.n != null) {
            break label452;
          }
          this.m = E2E.Message.ExtendedTextMessage.getDefaultInstance();
          label136:
          this.a &= 0xFFFFFFDF;
          if (this.p != null) {
            break label463;
          }
          this.o = E2E.Message.DocumentMessage.getDefaultInstance();
          label161:
          this.a &= 0xFFFFFFBF;
          if (this.r != null) {
            break label474;
          }
          this.q = E2E.Message.AudioMessage.getDefaultInstance();
          label186:
          this.a &= 0xFF7F;
          if (this.t != null) {
            break label485;
          }
          this.s = E2E.Message.VideoMessage.getDefaultInstance();
          label212:
          this.a &= 0xFEFF;
          if (this.v != null) {
            break label496;
          }
          this.u = E2E.Message.Call.getDefaultInstance();
          label238:
          this.a &= 0xFDFF;
          if (this.x != null) {
            break label507;
          }
          this.w = E2E.Message.Chat.getDefaultInstance();
          label264:
          this.a &= 0xFBFF;
          if (this.z != null) {
            break label518;
          }
          this.y = E2E.Message.ProtocolMessage.getDefaultInstance();
          label290:
          this.a &= 0xF7FF;
          if (this.B != null) {
            break label529;
          }
          this.A = E2E.Message.ContactsArrayMessage.getDefaultInstance();
          label316:
          this.a &= 0xEFFF;
          if (this.D != null) {
            break label540;
          }
          this.C = E2E.Message.HighlyStructuredMessage.getDefaultInstance();
          label342:
          this.a &= 0xDFFF;
          if (this.F != null) {
            break label551;
          }
          this.E = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
          label368:
          this.a &= 0xBFFF;
          if (this.H != null) {
            break label562;
          }
          this.G = E2E.Message.LiveLocationMessage.getDefaultInstance();
        }
        for (;;)
        {
          this.a &= 0xFFFF7FFF;
          return this;
          this.d.f();
          break;
          label419:
          this.h.f();
          break label61;
          label430:
          this.j.f();
          break label86;
          label441:
          this.l.f();
          break label111;
          label452:
          this.n.f();
          break label136;
          label463:
          this.p.f();
          break label161;
          label474:
          this.r.f();
          break label186;
          label485:
          this.t.f();
          break label212;
          label496:
          this.v.f();
          break label238;
          label507:
          this.x.f();
          break label264;
          label518:
          this.z.f();
          break label290;
          label529:
          this.B.f();
          break label316;
          label540:
          this.D.f();
          break label342;
          label551:
          this.F.f();
          break label368;
          label562:
          this.H.f();
        }
      }
      
      public final a clearAudioMessage()
      {
        if (this.r == null)
        {
          this.q = E2E.Message.AudioMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFF7F;
          return this;
          this.r.f();
        }
      }
      
      public final a clearCall()
      {
        if (this.v == null)
        {
          this.u = E2E.Message.Call.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFDFF;
          return this;
          this.v.f();
        }
      }
      
      public final a clearChat()
      {
        if (this.x == null)
        {
          this.w = E2E.Message.Chat.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFBFF;
          return this;
          this.x.f();
        }
      }
      
      public final a clearContactMessage()
      {
        if (this.j == null)
        {
          this.i = E2E.Message.ContactMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFF7;
          return this;
          this.j.f();
        }
      }
      
      public final a clearContactsArrayMessage()
      {
        if (this.B == null)
        {
          this.A = E2E.Message.ContactsArrayMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xEFFF;
          return this;
          this.B.f();
        }
      }
      
      public final a clearConversation()
      {
        this.a &= 0xFFFFFFFE;
        this.b = E2E.Message.getDefaultInstance().getConversation();
        onChanged();
        return this;
      }
      
      public final a clearDocumentMessage()
      {
        if (this.p == null)
        {
          this.o = E2E.Message.DocumentMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFBF;
          return this;
          this.p.f();
        }
      }
      
      public final a clearExtendedTextMessage()
      {
        if (this.n == null)
        {
          this.m = E2E.Message.ExtendedTextMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFDF;
          return this;
          this.n.f();
        }
      }
      
      public final a clearFastRatchetKeySenderKeyDistributionMessage()
      {
        if (this.F == null)
        {
          this.E = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xBFFF;
          return this;
          this.F.f();
        }
      }
      
      public final a clearHighlyStructuredMessage()
      {
        if (this.D == null)
        {
          this.C = E2E.Message.HighlyStructuredMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xDFFF;
          return this;
          this.D.f();
        }
      }
      
      public final a clearImageMessage()
      {
        if (this.h == null)
        {
          this.e = E2E.Message.ImageMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFFB;
          return this;
          this.h.f();
        }
      }
      
      public final a clearLiveLocationMessage()
      {
        if (this.H == null)
        {
          this.G = E2E.Message.LiveLocationMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFF7FFF;
          return this;
          this.H.f();
        }
      }
      
      public final a clearLocationMessage()
      {
        if (this.l == null)
        {
          this.k = E2E.Message.LocationMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFEF;
          return this;
          this.l.f();
        }
      }
      
      public final a clearProtocolMessage()
      {
        if (this.z == null)
        {
          this.y = E2E.Message.ProtocolMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xF7FF;
          return this;
          this.z.f();
        }
      }
      
      public final a clearSenderKeyDistributionMessage()
      {
        if (this.d == null)
        {
          this.c = E2E.Message.SenderKeyDistributionMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFFFFFFFD;
          return this;
          this.d.f();
        }
      }
      
      public final a clearVideoMessage()
      {
        if (this.t == null)
        {
          this.s = E2E.Message.VideoMessage.getDefaultInstance();
          onChanged();
        }
        for (;;)
        {
          this.a &= 0xFEFF;
          return this;
          this.t.f();
        }
      }
      
      public final a clone()
      {
        return (a)new a().mergeFrom(buildPartial());
      }
      
      public final E2E.Message.AudioMessage getAudioMessage()
      {
        if (this.r == null) {
          return this.q;
        }
        return (E2E.Message.AudioMessage)this.r.b();
      }
      
      public final E2E.Message.AudioMessage.a getAudioMessageBuilder()
      {
        this.a |= 0x80;
        onChanged();
        return (E2E.Message.AudioMessage.a)j().d();
      }
      
      public final f.a getAudioMessageOrBuilder$12b3f6b8$1ec9fbcb$5f20f411()
      {
        if (this.r != null) {
          return (f.a)this.r.e();
        }
        return this.q;
      }
      
      public final E2E.Message.Call getCall()
      {
        if (this.v == null) {
          return this.u;
        }
        return (E2E.Message.Call)this.v.b();
      }
      
      public final E2E.Message.Call.a getCallBuilder()
      {
        this.a |= 0x200;
        onChanged();
        return (E2E.Message.Call.a)l().d();
      }
      
      public final f.a getCallOrBuilder$78a3f3eb$1ec9fbcb$5f20f411()
      {
        if (this.v != null) {
          return (f.a)this.v.e();
        }
        return this.u;
      }
      
      public final E2E.Message.Chat getChat()
      {
        if (this.x == null) {
          return this.w;
        }
        return (E2E.Message.Chat)this.x.b();
      }
      
      public final E2E.Message.Chat.a getChatBuilder()
      {
        this.a |= 0x400;
        onChanged();
        return (E2E.Message.Chat.a)m().d();
      }
      
      public final f.a getChatOrBuilder$5f74b48f$1ec9fbcb$5f20f411()
      {
        if (this.x != null) {
          return (f.a)this.x.e();
        }
        return this.w;
      }
      
      public final E2E.Message.ContactMessage getContactMessage()
      {
        if (this.j == null) {
          return this.i;
        }
        return (E2E.Message.ContactMessage)this.j.b();
      }
      
      public final E2E.Message.ContactMessage.a getContactMessageBuilder()
      {
        this.a |= 0x8;
        onChanged();
        return (E2E.Message.ContactMessage.a)f().d();
      }
      
      public final f.a getContactMessageOrBuilder$1ba8293e$1ec9fbcb$5f20f411()
      {
        if (this.j != null) {
          return (f.a)this.j.e();
        }
        return this.i;
      }
      
      public final E2E.Message.ContactsArrayMessage getContactsArrayMessage()
      {
        if (this.B == null) {
          return this.A;
        }
        return (E2E.Message.ContactsArrayMessage)this.B.b();
      }
      
      public final E2E.Message.ContactsArrayMessage.a getContactsArrayMessageBuilder()
      {
        this.a |= 0x1000;
        onChanged();
        return (E2E.Message.ContactsArrayMessage.a)o().d();
      }
      
      public final f.a getContactsArrayMessageOrBuilder$3fc5eea8$1ec9fbcb$5f20f411()
      {
        if (this.B != null) {
          return (f.a)this.B.e();
        }
        return this.A;
      }
      
      public final String getConversation()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          localObject = (e)localObject;
          String str = ((e)localObject).e();
          if (((e)localObject).f()) {
            this.b = str;
          }
          return str;
        }
        return (String)localObject;
      }
      
      public final e getConversationBytes()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.b = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      public final E2E.Message getDefaultInstanceForType()
      {
        return E2E.Message.getDefaultInstance();
      }
      
      public final i.a getDescriptorForType()
      {
        return E2E.a();
      }
      
      public final E2E.Message.DocumentMessage getDocumentMessage()
      {
        if (this.p == null) {
          return this.o;
        }
        return (E2E.Message.DocumentMessage)this.p.b();
      }
      
      public final E2E.Message.DocumentMessage.a getDocumentMessageBuilder()
      {
        this.a |= 0x40;
        onChanged();
        return (E2E.Message.DocumentMessage.a)i().d();
      }
      
      public final f.a getDocumentMessageOrBuilder$255045fb$1ec9fbcb$5f20f411()
      {
        if (this.p != null) {
          return (f.a)this.p.e();
        }
        return this.o;
      }
      
      public final E2E.Message.ExtendedTextMessage getExtendedTextMessage()
      {
        if (this.n == null) {
          return this.m;
        }
        return (E2E.Message.ExtendedTextMessage)this.n.b();
      }
      
      public final E2E.Message.ExtendedTextMessage.a getExtendedTextMessageBuilder()
      {
        this.a |= 0x20;
        onChanged();
        return (E2E.Message.ExtendedTextMessage.a)h().d();
      }
      
      public final f.a getExtendedTextMessageOrBuilder$7d4dcd90$1ec9fbcb$5f20f411()
      {
        if (this.n != null) {
          return (f.a)this.n.e();
        }
        return this.m;
      }
      
      public final E2E.Message.SenderKeyDistributionMessage getFastRatchetKeySenderKeyDistributionMessage()
      {
        if (this.F == null) {
          return this.E;
        }
        return (E2E.Message.SenderKeyDistributionMessage)this.F.b();
      }
      
      public final E2E.Message.SenderKeyDistributionMessage.a getFastRatchetKeySenderKeyDistributionMessageBuilder()
      {
        this.a |= 0x4000;
        onChanged();
        return (E2E.Message.SenderKeyDistributionMessage.a)q().d();
      }
      
      public final f.a getFastRatchetKeySenderKeyDistributionMessageOrBuilder$be31370$1ec9fbcb$5f20f411()
      {
        if (this.F != null) {
          return (f.a)this.F.e();
        }
        return this.E;
      }
      
      public final E2E.Message.HighlyStructuredMessage getHighlyStructuredMessage()
      {
        if (this.D == null) {
          return this.C;
        }
        return (E2E.Message.HighlyStructuredMessage)this.D.b();
      }
      
      public final E2E.Message.HighlyStructuredMessage.a getHighlyStructuredMessageBuilder()
      {
        this.a |= 0x2000;
        onChanged();
        return (E2E.Message.HighlyStructuredMessage.a)p().d();
      }
      
      public final f.a getHighlyStructuredMessageOrBuilder$694fc456$1ec9fbcb$5f20f411()
      {
        if (this.D != null) {
          return (f.a)this.D.e();
        }
        return this.C;
      }
      
      public final E2E.Message.ImageMessage getImageMessage()
      {
        if (this.h == null) {
          return this.e;
        }
        return (E2E.Message.ImageMessage)this.h.b();
      }
      
      public final E2E.Message.ImageMessage.a getImageMessageBuilder()
      {
        this.a |= 0x4;
        onChanged();
        return (E2E.Message.ImageMessage.a)d().d();
      }
      
      public final f.a getImageMessageOrBuilder$433ae99d$1ec9fbcb$5f20f411()
      {
        if (this.h != null) {
          return (f.a)this.h.e();
        }
        return this.e;
      }
      
      public final E2E.Message.LiveLocationMessage getLiveLocationMessage()
      {
        if (this.H == null) {
          return this.G;
        }
        return (E2E.Message.LiveLocationMessage)this.H.b();
      }
      
      public final E2E.Message.LiveLocationMessage.a getLiveLocationMessageBuilder()
      {
        this.a |= 0x8000;
        onChanged();
        return (E2E.Message.LiveLocationMessage.a)r().d();
      }
      
      public final f.a getLiveLocationMessageOrBuilder$7333f915$1ec9fbcb$5f20f411()
      {
        if (this.H != null) {
          return (f.a)this.H.e();
        }
        return this.G;
      }
      
      public final E2E.Message.LocationMessage getLocationMessage()
      {
        if (this.l == null) {
          return this.k;
        }
        return (E2E.Message.LocationMessage)this.l.b();
      }
      
      public final E2E.Message.LocationMessage.a getLocationMessageBuilder()
      {
        this.a |= 0x10;
        onChanged();
        return (E2E.Message.LocationMessage.a)g().d();
      }
      
      public final f.a getLocationMessageOrBuilder$12aac15f$1ec9fbcb$5f20f411()
      {
        if (this.l != null) {
          return (f.a)this.l.e();
        }
        return this.k;
      }
      
      public final E2E.Message.ProtocolMessage getProtocolMessage()
      {
        if (this.z == null) {
          return this.y;
        }
        return (E2E.Message.ProtocolMessage)this.z.b();
      }
      
      public final E2E.Message.ProtocolMessage.a getProtocolMessageBuilder()
      {
        this.a |= 0x800;
        onChanged();
        return (E2E.Message.ProtocolMessage.a)n().d();
      }
      
      public final f.a getProtocolMessageOrBuilder$326f921e$1ec9fbcb$5f20f411()
      {
        if (this.z != null) {
          return (f.a)this.z.e();
        }
        return this.y;
      }
      
      public final E2E.Message.SenderKeyDistributionMessage getSenderKeyDistributionMessage()
      {
        if (this.d == null) {
          return this.c;
        }
        return (E2E.Message.SenderKeyDistributionMessage)this.d.b();
      }
      
      public final E2E.Message.SenderKeyDistributionMessage.a getSenderKeyDistributionMessageBuilder()
      {
        this.a |= 0x2;
        onChanged();
        return (E2E.Message.SenderKeyDistributionMessage.a)c().d();
      }
      
      public final f.a getSenderKeyDistributionMessageOrBuilder$be31370$1ec9fbcb$5f20f411()
      {
        if (this.d != null) {
          return (f.a)this.d.e();
        }
        return this.c;
      }
      
      public final E2E.Message.VideoMessage getVideoMessage()
      {
        if (this.t == null) {
          return this.s;
        }
        return (E2E.Message.VideoMessage)this.t.b();
      }
      
      public final E2E.Message.VideoMessage.b getVideoMessageBuilder()
      {
        this.a |= 0x100;
        onChanged();
        return (E2E.Message.VideoMessage.b)k().d();
      }
      
      public final f.a getVideoMessageOrBuilder$286f4f43$1ec9fbcb$5f20f411()
      {
        if (this.t != null) {
          return (f.a)this.t.e();
        }
        return this.s;
      }
      
      public final boolean hasAudioMessage()
      {
        return (this.a & 0x80) == 128;
      }
      
      public final boolean hasCall()
      {
        return (this.a & 0x200) == 512;
      }
      
      public final boolean hasChat()
      {
        return (this.a & 0x400) == 1024;
      }
      
      public final boolean hasContactMessage()
      {
        return (this.a & 0x8) == 8;
      }
      
      public final boolean hasContactsArrayMessage()
      {
        return (this.a & 0x1000) == 4096;
      }
      
      public final boolean hasConversation()
      {
        return (this.a & 0x1) == 1;
      }
      
      public final boolean hasDocumentMessage()
      {
        return (this.a & 0x40) == 64;
      }
      
      public final boolean hasExtendedTextMessage()
      {
        return (this.a & 0x20) == 32;
      }
      
      public final boolean hasFastRatchetKeySenderKeyDistributionMessage()
      {
        return (this.a & 0x4000) == 16384;
      }
      
      public final boolean hasHighlyStructuredMessage()
      {
        return (this.a & 0x2000) == 8192;
      }
      
      public final boolean hasImageMessage()
      {
        return (this.a & 0x4) == 4;
      }
      
      public final boolean hasLiveLocationMessage()
      {
        return (this.a & 0x8000) == 32768;
      }
      
      public final boolean hasLocationMessage()
      {
        return (this.a & 0x10) == 16;
      }
      
      public final boolean hasProtocolMessage()
      {
        return (this.a & 0x800) == 2048;
      }
      
      public final boolean hasSenderKeyDistributionMessage()
      {
        return (this.a & 0x2) == 2;
      }
      
      public final boolean hasVideoMessage()
      {
        return (this.a & 0x100) == 256;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return E2E.b().a(E2E.Message.class, a.class);
      }
      
      public final a mergeAudioMessage(E2E.Message.AudioMessage paramAudioMessage)
      {
        if (this.r == null) {
          if (((this.a & 0x80) == 128) && (this.q != E2E.Message.AudioMessage.getDefaultInstance()))
          {
            this.q = ((E2E.Message.AudioMessage.a)E2E.Message.AudioMessage.newBuilder(this.q).mergeFrom(paramAudioMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x80;
          return this;
          this.q = paramAudioMessage;
          break;
          this.r.b(paramAudioMessage);
        }
      }
      
      public final a mergeCall(E2E.Message.Call paramCall)
      {
        if (this.v == null) {
          if (((this.a & 0x200) == 512) && (this.u != E2E.Message.Call.getDefaultInstance()))
          {
            this.u = ((E2E.Message.Call.a)E2E.Message.Call.newBuilder(this.u).mergeFrom(paramCall)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x200;
          return this;
          this.u = paramCall;
          break;
          this.v.b(paramCall);
        }
      }
      
      public final a mergeChat(E2E.Message.Chat paramChat)
      {
        if (this.x == null) {
          if (((this.a & 0x400) == 1024) && (this.w != E2E.Message.Chat.getDefaultInstance()))
          {
            this.w = ((E2E.Message.Chat.a)E2E.Message.Chat.newBuilder(this.w).mergeFrom(paramChat)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x400;
          return this;
          this.w = paramChat;
          break;
          this.x.b(paramChat);
        }
      }
      
      public final a mergeContactMessage(E2E.Message.ContactMessage paramContactMessage)
      {
        if (this.j == null) {
          if (((this.a & 0x8) == 8) && (this.i != E2E.Message.ContactMessage.getDefaultInstance()))
          {
            this.i = ((E2E.Message.ContactMessage.a)E2E.Message.ContactMessage.newBuilder(this.i).mergeFrom(paramContactMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x8;
          return this;
          this.i = paramContactMessage;
          break;
          this.j.b(paramContactMessage);
        }
      }
      
      public final a mergeContactsArrayMessage(E2E.Message.ContactsArrayMessage paramContactsArrayMessage)
      {
        if (this.B == null) {
          if (((this.a & 0x1000) == 4096) && (this.A != E2E.Message.ContactsArrayMessage.getDefaultInstance()))
          {
            this.A = ((E2E.Message.ContactsArrayMessage.a)E2E.Message.ContactsArrayMessage.newBuilder(this.A).mergeFrom(paramContactsArrayMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x1000;
          return this;
          this.A = paramContactsArrayMessage;
          break;
          this.B.b(paramContactsArrayMessage);
        }
      }
      
      public final a mergeDocumentMessage(E2E.Message.DocumentMessage paramDocumentMessage)
      {
        if (this.p == null) {
          if (((this.a & 0x40) == 64) && (this.o != E2E.Message.DocumentMessage.getDefaultInstance()))
          {
            this.o = ((E2E.Message.DocumentMessage.a)E2E.Message.DocumentMessage.newBuilder(this.o).mergeFrom(paramDocumentMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x40;
          return this;
          this.o = paramDocumentMessage;
          break;
          this.p.b(paramDocumentMessage);
        }
      }
      
      public final a mergeExtendedTextMessage(E2E.Message.ExtendedTextMessage paramExtendedTextMessage)
      {
        if (this.n == null) {
          if (((this.a & 0x20) == 32) && (this.m != E2E.Message.ExtendedTextMessage.getDefaultInstance()))
          {
            this.m = ((E2E.Message.ExtendedTextMessage.a)E2E.Message.ExtendedTextMessage.newBuilder(this.m).mergeFrom(paramExtendedTextMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x20;
          return this;
          this.m = paramExtendedTextMessage;
          break;
          this.n.b(paramExtendedTextMessage);
        }
      }
      
      public final a mergeFastRatchetKeySenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage paramSenderKeyDistributionMessage)
      {
        if (this.F == null) {
          if (((this.a & 0x4000) == 16384) && (this.E != E2E.Message.SenderKeyDistributionMessage.getDefaultInstance()))
          {
            this.E = ((E2E.Message.SenderKeyDistributionMessage.a)E2E.Message.SenderKeyDistributionMessage.newBuilder(this.E).mergeFrom(paramSenderKeyDistributionMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x4000;
          return this;
          this.E = paramSenderKeyDistributionMessage;
          break;
          this.F.b(paramSenderKeyDistributionMessage);
        }
      }
      
      public final a mergeHighlyStructuredMessage(E2E.Message.HighlyStructuredMessage paramHighlyStructuredMessage)
      {
        if (this.D == null) {
          if (((this.a & 0x2000) == 8192) && (this.C != E2E.Message.HighlyStructuredMessage.getDefaultInstance()))
          {
            this.C = ((E2E.Message.HighlyStructuredMessage.a)E2E.Message.HighlyStructuredMessage.newBuilder(this.C).mergeFrom(paramHighlyStructuredMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x2000;
          return this;
          this.C = paramHighlyStructuredMessage;
          break;
          this.D.b(paramHighlyStructuredMessage);
        }
      }
      
      public final a mergeImageMessage(E2E.Message.ImageMessage paramImageMessage)
      {
        if (this.h == null) {
          if (((this.a & 0x4) == 4) && (this.e != E2E.Message.ImageMessage.getDefaultInstance()))
          {
            this.e = ((E2E.Message.ImageMessage.a)E2E.Message.ImageMessage.newBuilder(this.e).mergeFrom(paramImageMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.e = paramImageMessage;
          break;
          this.h.b(paramImageMessage);
        }
      }
      
      public final a mergeLiveLocationMessage(E2E.Message.LiveLocationMessage paramLiveLocationMessage)
      {
        if (this.H == null) {
          if (((this.a & 0x8000) == 32768) && (this.G != E2E.Message.LiveLocationMessage.getDefaultInstance()))
          {
            this.G = ((E2E.Message.LiveLocationMessage.a)E2E.Message.LiveLocationMessage.newBuilder(this.G).mergeFrom(paramLiveLocationMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x8000;
          return this;
          this.G = paramLiveLocationMessage;
          break;
          this.H.b(paramLiveLocationMessage);
        }
      }
      
      public final a mergeLocationMessage(E2E.Message.LocationMessage paramLocationMessage)
      {
        if (this.l == null) {
          if (((this.a & 0x10) == 16) && (this.k != E2E.Message.LocationMessage.getDefaultInstance()))
          {
            this.k = ((E2E.Message.LocationMessage.a)E2E.Message.LocationMessage.newBuilder(this.k).mergeFrom(paramLocationMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x10;
          return this;
          this.k = paramLocationMessage;
          break;
          this.l.b(paramLocationMessage);
        }
      }
      
      public final a mergeProtocolMessage(E2E.Message.ProtocolMessage paramProtocolMessage)
      {
        if (this.z == null) {
          if (((this.a & 0x800) == 2048) && (this.y != E2E.Message.ProtocolMessage.getDefaultInstance()))
          {
            this.y = ((E2E.Message.ProtocolMessage.a)E2E.Message.ProtocolMessage.newBuilder(this.y).mergeFrom(paramProtocolMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x800;
          return this;
          this.y = paramProtocolMessage;
          break;
          this.z.b(paramProtocolMessage);
        }
      }
      
      public final a mergeSenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage paramSenderKeyDistributionMessage)
      {
        if (this.d == null) {
          if (((this.a & 0x2) == 2) && (this.c != E2E.Message.SenderKeyDistributionMessage.getDefaultInstance()))
          {
            this.c = ((E2E.Message.SenderKeyDistributionMessage.a)E2E.Message.SenderKeyDistributionMessage.newBuilder(this.c).mergeFrom(paramSenderKeyDistributionMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x2;
          return this;
          this.c = paramSenderKeyDistributionMessage;
          break;
          this.d.b(paramSenderKeyDistributionMessage);
        }
      }
      
      public final a mergeVideoMessage(E2E.Message.VideoMessage paramVideoMessage)
      {
        if (this.t == null) {
          if (((this.a & 0x100) == 256) && (this.s != E2E.Message.VideoMessage.getDefaultInstance()))
          {
            this.s = ((E2E.Message.VideoMessage.b)E2E.Message.VideoMessage.newBuilder(this.s).mergeFrom(paramVideoMessage)).buildPartial();
            onChanged();
          }
        }
        for (;;)
        {
          this.a |= 0x100;
          return this;
          this.s = paramVideoMessage;
          break;
          this.t.b(paramVideoMessage);
        }
      }
      
      public final a setAudioMessage(E2E.Message.AudioMessage.a parama)
      {
        if (this.r == null)
        {
          this.q = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x80;
          return this;
          this.r.a(parama.build());
        }
      }
      
      public final a setAudioMessage(E2E.Message.AudioMessage paramAudioMessage)
      {
        if (this.r == null)
        {
          if (paramAudioMessage == null) {
            throw new NullPointerException();
          }
          this.q = paramAudioMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x80;
          return this;
          this.r.a(paramAudioMessage);
        }
      }
      
      public final a setCall(E2E.Message.Call.a parama)
      {
        if (this.v == null)
        {
          this.u = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x200;
          return this;
          this.v.a(parama.build());
        }
      }
      
      public final a setCall(E2E.Message.Call paramCall)
      {
        if (this.v == null)
        {
          if (paramCall == null) {
            throw new NullPointerException();
          }
          this.u = paramCall;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x200;
          return this;
          this.v.a(paramCall);
        }
      }
      
      public final a setChat(E2E.Message.Chat.a parama)
      {
        if (this.x == null)
        {
          this.w = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x400;
          return this;
          this.x.a(parama.build());
        }
      }
      
      public final a setChat(E2E.Message.Chat paramChat)
      {
        if (this.x == null)
        {
          if (paramChat == null) {
            throw new NullPointerException();
          }
          this.w = paramChat;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x400;
          return this;
          this.x.a(paramChat);
        }
      }
      
      public final a setContactMessage(E2E.Message.ContactMessage.a parama)
      {
        if (this.j == null)
        {
          this.i = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x8;
          return this;
          this.j.a(parama.build());
        }
      }
      
      public final a setContactMessage(E2E.Message.ContactMessage paramContactMessage)
      {
        if (this.j == null)
        {
          if (paramContactMessage == null) {
            throw new NullPointerException();
          }
          this.i = paramContactMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x8;
          return this;
          this.j.a(paramContactMessage);
        }
      }
      
      public final a setContactsArrayMessage(E2E.Message.ContactsArrayMessage.a parama)
      {
        if (this.B == null)
        {
          this.A = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x1000;
          return this;
          this.B.a(parama.build());
        }
      }
      
      public final a setContactsArrayMessage(E2E.Message.ContactsArrayMessage paramContactsArrayMessage)
      {
        if (this.B == null)
        {
          if (paramContactsArrayMessage == null) {
            throw new NullPointerException();
          }
          this.A = paramContactsArrayMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x1000;
          return this;
          this.B.a(paramContactsArrayMessage);
        }
      }
      
      public final a setConversation(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = paramString;
        onChanged();
        return this;
      }
      
      public final a setConversationBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = parame;
        onChanged();
        return this;
      }
      
      public final a setDocumentMessage(E2E.Message.DocumentMessage.a parama)
      {
        if (this.p == null)
        {
          this.o = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x40;
          return this;
          this.p.a(parama.build());
        }
      }
      
      public final a setDocumentMessage(E2E.Message.DocumentMessage paramDocumentMessage)
      {
        if (this.p == null)
        {
          if (paramDocumentMessage == null) {
            throw new NullPointerException();
          }
          this.o = paramDocumentMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x40;
          return this;
          this.p.a(paramDocumentMessage);
        }
      }
      
      public final a setExtendedTextMessage(E2E.Message.ExtendedTextMessage.a parama)
      {
        if (this.n == null)
        {
          this.m = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x20;
          return this;
          this.n.a(parama.build());
        }
      }
      
      public final a setExtendedTextMessage(E2E.Message.ExtendedTextMessage paramExtendedTextMessage)
      {
        if (this.n == null)
        {
          if (paramExtendedTextMessage == null) {
            throw new NullPointerException();
          }
          this.m = paramExtendedTextMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x20;
          return this;
          this.n.a(paramExtendedTextMessage);
        }
      }
      
      public final a setFastRatchetKeySenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage.a parama)
      {
        if (this.F == null)
        {
          this.E = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4000;
          return this;
          this.F.a(parama.build());
        }
      }
      
      public final a setFastRatchetKeySenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage paramSenderKeyDistributionMessage)
      {
        if (this.F == null)
        {
          if (paramSenderKeyDistributionMessage == null) {
            throw new NullPointerException();
          }
          this.E = paramSenderKeyDistributionMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4000;
          return this;
          this.F.a(paramSenderKeyDistributionMessage);
        }
      }
      
      public final a setHighlyStructuredMessage(E2E.Message.HighlyStructuredMessage.a parama)
      {
        if (this.D == null)
        {
          this.C = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x2000;
          return this;
          this.D.a(parama.build());
        }
      }
      
      public final a setHighlyStructuredMessage(E2E.Message.HighlyStructuredMessage paramHighlyStructuredMessage)
      {
        if (this.D == null)
        {
          if (paramHighlyStructuredMessage == null) {
            throw new NullPointerException();
          }
          this.C = paramHighlyStructuredMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x2000;
          return this;
          this.D.a(paramHighlyStructuredMessage);
        }
      }
      
      public final a setImageMessage(E2E.Message.ImageMessage.a parama)
      {
        if (this.h == null)
        {
          this.e = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.h.a(parama.build());
        }
      }
      
      public final a setImageMessage(E2E.Message.ImageMessage paramImageMessage)
      {
        if (this.h == null)
        {
          if (paramImageMessage == null) {
            throw new NullPointerException();
          }
          this.e = paramImageMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x4;
          return this;
          this.h.a(paramImageMessage);
        }
      }
      
      public final a setLiveLocationMessage(E2E.Message.LiveLocationMessage.a parama)
      {
        if (this.H == null)
        {
          this.G = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x8000;
          return this;
          this.H.a(parama.build());
        }
      }
      
      public final a setLiveLocationMessage(E2E.Message.LiveLocationMessage paramLiveLocationMessage)
      {
        if (this.H == null)
        {
          if (paramLiveLocationMessage == null) {
            throw new NullPointerException();
          }
          this.G = paramLiveLocationMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x8000;
          return this;
          this.H.a(paramLiveLocationMessage);
        }
      }
      
      public final a setLocationMessage(E2E.Message.LocationMessage.a parama)
      {
        if (this.l == null)
        {
          this.k = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x10;
          return this;
          this.l.a(parama.build());
        }
      }
      
      public final a setLocationMessage(E2E.Message.LocationMessage paramLocationMessage)
      {
        if (this.l == null)
        {
          if (paramLocationMessage == null) {
            throw new NullPointerException();
          }
          this.k = paramLocationMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x10;
          return this;
          this.l.a(paramLocationMessage);
        }
      }
      
      public final a setProtocolMessage(E2E.Message.ProtocolMessage.a parama)
      {
        if (this.z == null)
        {
          this.y = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x800;
          return this;
          this.z.a(parama.build());
        }
      }
      
      public final a setProtocolMessage(E2E.Message.ProtocolMessage paramProtocolMessage)
      {
        if (this.z == null)
        {
          if (paramProtocolMessage == null) {
            throw new NullPointerException();
          }
          this.y = paramProtocolMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x800;
          return this;
          this.z.a(paramProtocolMessage);
        }
      }
      
      public final a setSenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage.a parama)
      {
        if (this.d == null)
        {
          this.c = parama.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x2;
          return this;
          this.d.a(parama.build());
        }
      }
      
      public final a setSenderKeyDistributionMessage(E2E.Message.SenderKeyDistributionMessage paramSenderKeyDistributionMessage)
      {
        if (this.d == null)
        {
          if (paramSenderKeyDistributionMessage == null) {
            throw new NullPointerException();
          }
          this.c = paramSenderKeyDistributionMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x2;
          return this;
          this.d.a(paramSenderKeyDistributionMessage);
        }
      }
      
      public final a setVideoMessage(E2E.Message.VideoMessage.b paramb)
      {
        if (this.t == null)
        {
          this.s = paramb.build();
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x100;
          return this;
          this.t.a(paramb.build());
        }
      }
      
      public final a setVideoMessage(E2E.Message.VideoMessage paramVideoMessage)
      {
        if (this.t == null)
        {
          if (paramVideoMessage == null) {
            throw new NullPointerException();
          }
          this.s = paramVideoMessage;
          onChanged();
        }
        for (;;)
        {
          this.a |= 0x100;
          return this;
          this.t.a(paramVideoMessage);
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/E2E.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */