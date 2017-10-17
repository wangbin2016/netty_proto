// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SubscribeResq.proto

package com.wb.proto.entity;

public final class SubscribeResqProto {
  private SubscribeResqProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SubscribeResqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SubscribeResq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 subReqID = 1;</code>
     */
    int getSubReqID();

    /**
     * <code>int32 respCode = 2;</code>
     */
    int getRespCode();

    /**
     * <code>string desc = 3;</code>
     */
    java.lang.String getDesc();
    /**
     * <code>string desc = 3;</code>
     */
    com.google.protobuf.ByteString
        getDescBytes();
  }
  /**
   * Protobuf type {@code SubscribeResq}
   */
  public  static final class SubscribeResq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SubscribeResq)
      SubscribeResqOrBuilder {
    // Use SubscribeResq.newBuilder() to construct.
    private SubscribeResq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SubscribeResq() {
      subReqID_ = 0;
      respCode_ = 0;
      desc_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private SubscribeResq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              subReqID_ = input.readInt32();
              break;
            }
            case 16: {

              respCode_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              desc_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.wb.proto.entity.SubscribeResqProto.internal_static_SubscribeResq_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.wb.proto.entity.SubscribeResqProto.internal_static_SubscribeResq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.wb.proto.entity.SubscribeResqProto.SubscribeResq.class, com.wb.proto.entity.SubscribeResqProto.SubscribeResq.Builder.class);
    }

    public static final int SUBREQID_FIELD_NUMBER = 1;
    private int subReqID_;
    /**
     * <code>int32 subReqID = 1;</code>
     */
    public int getSubReqID() {
      return subReqID_;
    }

    public static final int RESPCODE_FIELD_NUMBER = 2;
    private int respCode_;
    /**
     * <code>int32 respCode = 2;</code>
     */
    public int getRespCode() {
      return respCode_;
    }

    public static final int DESC_FIELD_NUMBER = 3;
    private volatile java.lang.Object desc_;
    /**
     * <code>string desc = 3;</code>
     */
    public java.lang.String getDesc() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        desc_ = s;
        return s;
      }
    }
    /**
     * <code>string desc = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDescBytes() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        desc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (subReqID_ != 0) {
        output.writeInt32(1, subReqID_);
      }
      if (respCode_ != 0) {
        output.writeInt32(2, respCode_);
      }
      if (!getDescBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, desc_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (subReqID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, subReqID_);
      }
      if (respCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, respCode_);
      }
      if (!getDescBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, desc_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.wb.proto.entity.SubscribeResqProto.SubscribeResq)) {
        return super.equals(obj);
      }
      com.wb.proto.entity.SubscribeResqProto.SubscribeResq other = (com.wb.proto.entity.SubscribeResqProto.SubscribeResq) obj;

      boolean result = true;
      result = result && (getSubReqID()
          == other.getSubReqID());
      result = result && (getRespCode()
          == other.getRespCode());
      result = result && getDesc()
          .equals(other.getDesc());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SUBREQID_FIELD_NUMBER;
      hash = (53 * hash) + getSubReqID();
      hash = (37 * hash) + RESPCODE_FIELD_NUMBER;
      hash = (53 * hash) + getRespCode();
      hash = (37 * hash) + DESC_FIELD_NUMBER;
      hash = (53 * hash) + getDesc().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.wb.proto.entity.SubscribeResqProto.SubscribeResq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code SubscribeResq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SubscribeResq)
        com.wb.proto.entity.SubscribeResqProto.SubscribeResqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.wb.proto.entity.SubscribeResqProto.internal_static_SubscribeResq_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.wb.proto.entity.SubscribeResqProto.internal_static_SubscribeResq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.wb.proto.entity.SubscribeResqProto.SubscribeResq.class, com.wb.proto.entity.SubscribeResqProto.SubscribeResq.Builder.class);
      }

      // Construct using com.wb.netty_long.entity.SubscribeResqProto.SubscribeResq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        subReqID_ = 0;

        respCode_ = 0;

        desc_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.wb.proto.entity.SubscribeResqProto.internal_static_SubscribeResq_descriptor;
      }

      public com.wb.proto.entity.SubscribeResqProto.SubscribeResq getDefaultInstanceForType() {
        return com.wb.proto.entity.SubscribeResqProto.SubscribeResq.getDefaultInstance();
      }

      public com.wb.proto.entity.SubscribeResqProto.SubscribeResq build() {
        com.wb.proto.entity.SubscribeResqProto.SubscribeResq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.wb.proto.entity.SubscribeResqProto.SubscribeResq buildPartial() {
        com.wb.proto.entity.SubscribeResqProto.SubscribeResq result = new com.wb.proto.entity.SubscribeResqProto.SubscribeResq(this);
        result.subReqID_ = subReqID_;
        result.respCode_ = respCode_;
        result.desc_ = desc_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.wb.proto.entity.SubscribeResqProto.SubscribeResq) {
          return mergeFrom((com.wb.proto.entity.SubscribeResqProto.SubscribeResq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.wb.proto.entity.SubscribeResqProto.SubscribeResq other) {
        if (other == com.wb.proto.entity.SubscribeResqProto.SubscribeResq.getDefaultInstance()) return this;
        if (other.getSubReqID() != 0) {
          setSubReqID(other.getSubReqID());
        }
        if (other.getRespCode() != 0) {
          setRespCode(other.getRespCode());
        }
        if (!other.getDesc().isEmpty()) {
          desc_ = other.desc_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.wb.proto.entity.SubscribeResqProto.SubscribeResq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.wb.proto.entity.SubscribeResqProto.SubscribeResq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int subReqID_ ;
      /**
       * <code>int32 subReqID = 1;</code>
       */
      public int getSubReqID() {
        return subReqID_;
      }
      /**
       * <code>int32 subReqID = 1;</code>
       */
      public Builder setSubReqID(int value) {
        
        subReqID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 subReqID = 1;</code>
       */
      public Builder clearSubReqID() {
        
        subReqID_ = 0;
        onChanged();
        return this;
      }

      private int respCode_ ;
      /**
       * <code>int32 respCode = 2;</code>
       */
      public int getRespCode() {
        return respCode_;
      }
      /**
       * <code>int32 respCode = 2;</code>
       */
      public Builder setRespCode(int value) {
        
        respCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 respCode = 2;</code>
       */
      public Builder clearRespCode() {
        
        respCode_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object desc_ = "";
      /**
       * <code>string desc = 3;</code>
       */
      public java.lang.String getDesc() {
        java.lang.Object ref = desc_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          desc_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string desc = 3;</code>
       */
      public com.google.protobuf.ByteString
          getDescBytes() {
        java.lang.Object ref = desc_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          desc_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string desc = 3;</code>
       */
      public Builder setDesc(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        desc_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string desc = 3;</code>
       */
      public Builder clearDesc() {
        
        desc_ = getDefaultInstance().getDesc();
        onChanged();
        return this;
      }
      /**
       * <code>string desc = 3;</code>
       */
      public Builder setDescBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        desc_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:SubscribeResq)
    }

    // @@protoc_insertion_point(class_scope:SubscribeResq)
    private static final com.wb.proto.entity.SubscribeResqProto.SubscribeResq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.wb.proto.entity.SubscribeResqProto.SubscribeResq();
    }

    public static com.wb.proto.entity.SubscribeResqProto.SubscribeResq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SubscribeResq>
        PARSER = new com.google.protobuf.AbstractParser<SubscribeResq>() {
      public SubscribeResq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SubscribeResq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SubscribeResq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SubscribeResq> getParserForType() {
      return PARSER;
    }

    public com.wb.proto.entity.SubscribeResqProto.SubscribeResq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SubscribeResq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SubscribeResq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SubscribeResq.proto\"A\n\rSubscribeResq\022\020" +
      "\n\010subReqID\030\001 \001(\005\022\020\n\010respCode\030\002 \001(\005\022\014\n\004de" +
      "sc\030\003 \001(\tB.\n\030com.wb.netty_long.entityB\022Su" +
      "bscribeResqProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_SubscribeResq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SubscribeResq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SubscribeResq_descriptor,
        new java.lang.String[] { "SubReqID", "RespCode", "Desc", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
