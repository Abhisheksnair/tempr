package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.ae;
import com.google.protobuf.an;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.i.a;
import com.google.protobuf.i.g;
import com.google.protobuf.i.g.a;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.o;
import com.google.protobuf.o.a;
import com.google.protobuf.o.b;
import com.google.protobuf.o.f;
import com.google.protobuf.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class Protocol
{
  private static final i.a a = (i.a)c.e().get(0);
  private static o.f b = new o.f(a, new String[] { "RemoteJid", "FromMe", "Id", "Participant" });
  private static i.g c;
  
  static
  {
    i.g.a local1 = new i.g.a()
    {
      public final l a(i.g paramAnonymousg)
      {
        Protocol.a(paramAnonymousg);
        return null;
      }
    };
    i.g.a(new String[] { "\n\016protocol.proto\022\bwhatsapp\"R\n\nMessageKey\022\022\n\nremote_jid\030\001 \001(\t\022\017\n\007from_me\030\002 \001(\b\022\n\n\002id\030\003 \001(\t\022\023\n\013participant\030\004 \001(\tB\026\n\022com.whatsapp.protoH\002" }, new i.g[0], local1);
  }
  
  public static i.g a()
  {
    return c;
  }
  
  public static final class MessageKey
    extends o
    implements f.a
  {
    public static final int FROM_ME_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 3;
    public static ae<MessageKey> PARSER = new c()
    {
      private static Protocol.MessageKey c(f paramAnonymousf, m paramAnonymousm)
      {
        Protocol.MessageKey.a locala = Protocol.MessageKey.newBuilder();
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
    public static final int PARTICIPANT_FIELD_NUMBER = 4;
    public static final int REMOTE_JID_FIELD_NUMBER = 1;
    private static final MessageKey defaultInstance;
    private int bitField0_;
    private boolean fromMe_;
    private Object id_;
    private Object participant_;
    private Object remoteJid_;
    private final an unknownFields;
    
    static
    {
      MessageKey localMessageKey = new MessageKey(true);
      defaultInstance = localMessageKey;
      localMessageKey.initFields();
    }
    
    private MessageKey(o.a<?> parama)
    {
      super();
      this.unknownFields = parama.getUnknownFields();
    }
    
    private MessageKey(boolean paramBoolean)
    {
      this.unknownFields = an.b();
    }
    
    public static MessageKey getDefaultInstance()
    {
      return defaultInstance;
    }
    
    public static final i.a getDescriptor()
    {
      return Protocol.b();
    }
    
    private void initFields()
    {
      this.remoteJid_ = "";
      this.fromMe_ = false;
      this.id_ = "";
      this.participant_ = "";
    }
    
    public static a newBuilder()
    {
      return a.a();
    }
    
    public static a newBuilder(MessageKey paramMessageKey)
    {
      return (a)newBuilder().mergeFrom(paramMessageKey);
    }
    
    public static MessageKey parseDelimitedFrom(InputStream paramInputStream)
    {
      return (MessageKey)PARSER.a(paramInputStream);
    }
    
    public static MessageKey parseDelimitedFrom(InputStream paramInputStream, m paramm)
    {
      return (MessageKey)PARSER.a(paramInputStream, paramm);
    }
    
    public static MessageKey parseFrom(e parame)
    {
      return (MessageKey)PARSER.a(parame);
    }
    
    public static MessageKey parseFrom(e parame, m paramm)
    {
      return (MessageKey)PARSER.a(parame, paramm);
    }
    
    public static MessageKey parseFrom(f paramf)
    {
      return (MessageKey)PARSER.a(paramf);
    }
    
    public static MessageKey parseFrom(f paramf, m paramm)
    {
      return (MessageKey)PARSER.a(paramf, paramm);
    }
    
    public static MessageKey parseFrom(InputStream paramInputStream)
    {
      return (MessageKey)PARSER.b(paramInputStream);
    }
    
    public static MessageKey parseFrom(InputStream paramInputStream, m paramm)
    {
      return (MessageKey)PARSER.b(paramInputStream, paramm);
    }
    
    public static MessageKey parseFrom(byte[] paramArrayOfByte)
    {
      return (MessageKey)PARSER.a(paramArrayOfByte);
    }
    
    public static MessageKey parseFrom(byte[] paramArrayOfByte, m paramm)
    {
      return (MessageKey)PARSER.a(paramArrayOfByte, paramm);
    }
    
    public final MessageKey getDefaultInstanceForType()
    {
      return defaultInstance;
    }
    
    public final boolean getFromMe()
    {
      return this.fromMe_;
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
    
    public final ae<MessageKey> getParserForType()
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
    
    public final an getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasFromMe()
    {
      return (this.bitField0_ & 0x2) == 2;
    }
    
    public final boolean hasId()
    {
      return (this.bitField0_ & 0x4) == 4;
    }
    
    public final boolean hasParticipant()
    {
      return (this.bitField0_ & 0x8) == 8;
    }
    
    public final boolean hasRemoteJid()
    {
      return (this.bitField0_ & 0x1) == 1;
    }
    
    protected final o.f internalGetFieldAccessorTable()
    {
      return Protocol.c().a(MessageKey.class, a.class);
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
      private boolean c;
      private Object d = "";
      private Object e = "";
      
      private a() {}
      
      private a(o.b paramb)
      {
        super();
      }
      
      public static final i.a getDescriptor()
      {
        return Protocol.b();
      }
      
      public final Protocol.MessageKey build()
      {
        Protocol.MessageKey localMessageKey = buildPartial();
        if (!localMessageKey.isInitialized()) {
          throw newUninitializedMessageException(localMessageKey);
        }
        return localMessageKey;
      }
      
      public final Protocol.MessageKey buildPartial()
      {
        int j = 1;
        Protocol.MessageKey localMessageKey = new Protocol.MessageKey(this, null);
        int k = this.a;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          Protocol.MessageKey.access$602(localMessageKey, this.b);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          Protocol.MessageKey.access$702(localMessageKey, this.c);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          Protocol.MessageKey.access$802(localMessageKey, this.d);
          i = j;
          if ((k & 0x8) == 8) {
            i = j | 0x8;
          }
          Protocol.MessageKey.access$902(localMessageKey, this.e);
          Protocol.MessageKey.access$1002(localMessageKey, i);
          onBuilt();
          return localMessageKey;
          j = 0;
        }
      }
      
      public final a clear()
      {
        super.clear();
        this.b = "";
        this.a &= 0xFFFFFFFE;
        this.c = false;
        this.a &= 0xFFFFFFFD;
        this.d = "";
        this.a &= 0xFFFFFFFB;
        this.e = "";
        this.a &= 0xFFFFFFF7;
        return this;
      }
      
      public final a clearFromMe()
      {
        this.a &= 0xFFFFFFFD;
        this.c = false;
        onChanged();
        return this;
      }
      
      public final a clearId()
      {
        this.a &= 0xFFFFFFFB;
        this.d = Protocol.MessageKey.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public final a clearParticipant()
      {
        this.a &= 0xFFFFFFF7;
        this.e = Protocol.MessageKey.getDefaultInstance().getParticipant();
        onChanged();
        return this;
      }
      
      public final a clearRemoteJid()
      {
        this.a &= 0xFFFFFFFE;
        this.b = Protocol.MessageKey.getDefaultInstance().getRemoteJid();
        onChanged();
        return this;
      }
      
      public final a clone()
      {
        return (a)new a().mergeFrom(buildPartial());
      }
      
      public final Protocol.MessageKey getDefaultInstanceForType()
      {
        return Protocol.MessageKey.getDefaultInstance();
      }
      
      public final i.a getDescriptorForType()
      {
        return Protocol.b();
      }
      
      public final boolean getFromMe()
      {
        return this.c;
      }
      
      public final String getId()
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
      
      public final e getIdBytes()
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
      
      public final String getParticipant()
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
      
      public final e getParticipantBytes()
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
      
      public final String getRemoteJid()
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
      
      public final e getRemoteJidBytes()
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
      
      public final boolean hasFromMe()
      {
        return (this.a & 0x2) == 2;
      }
      
      public final boolean hasId()
      {
        return (this.a & 0x4) == 4;
      }
      
      public final boolean hasParticipant()
      {
        return (this.a & 0x8) == 8;
      }
      
      public final boolean hasRemoteJid()
      {
        return (this.a & 0x1) == 1;
      }
      
      protected final o.f internalGetFieldAccessorTable()
      {
        return Protocol.c().a(Protocol.MessageKey.class, a.class);
      }
      
      public final a setFromMe(boolean paramBoolean)
      {
        this.a |= 0x2;
        this.c = paramBoolean;
        onChanged();
        return this;
      }
      
      public final a setId(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x4;
        this.d = paramString;
        onChanged();
        return this;
      }
      
      public final a setIdBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x4;
        this.d = parame;
        onChanged();
        return this;
      }
      
      public final a setParticipant(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.e = paramString;
        onChanged();
        return this;
      }
      
      public final a setParticipantBytes(e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.a |= 0x8;
        this.e = parame;
        onChanged();
        return this;
      }
      
      public final a setRemoteJid(String paramString)
      {
        if (paramString == null) {
          throw new NullPointerException();
        }
        this.a |= 0x1;
        this.b = paramString;
        onChanged();
        return this;
      }
      
      public final a setRemoteJidBytes(e parame)
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
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */