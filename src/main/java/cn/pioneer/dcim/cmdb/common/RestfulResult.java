package cn.pioneer.dcim.cmdb.common;

import cn.pioneer.dcim.cmdb.common.constants.RestConst;

import java.util.HashMap;

public class RestfulResult extends HashMap<String, Object> {

    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String STATUS = "status";
    private static final String MESSAGE = "message";

    /**
     * 构造方法
     */
    public RestfulResult() {
        put(STATUS, Status.SUCCESS.getValue());
        put(CODE, RestConst.HttpConst.OK.getCode());
    }


    /**
     * 构造方法(数据)
     *
     * @param data 返回消息
     */
    public RestfulResult(Object data) {
        put(STATUS, Status.SUCCESS.getValue());
        put(CODE, RestConst.HttpConst.OK.getCode());
        if (data != null) {
            put(DATA, data);
        }
    }

    /**
     * 构造方法(状态、消息)
     *
     * @param status  返回状态
     * @param message 返回消息
     */
    public RestfulResult(Status status, String message) {
        put(CODE, RestConst.HttpConst.OK.getCode());
        put(STATUS, status.getValue());
        if (message != null) {
            put(MESSAGE, message);
        }
    }


    /**
     * 构造方法(状态、消息、数据)
     *
     * @param code    返回页面码
     * @param status  返回状态
     * @param message 返回消息
     * @param data    the data
     */
    public RestfulResult(RestConst.RestEnum code, Status status, Object message, Object data) {
        put(CODE, code.getCode());
        put(STATUS, status.getValue());
        if (message != null) {
            put(MESSAGE, message);
        }
        if (data != null) {
            put(DATA, data);
        }
    }

    /**
     * 构造方法(状态、消息、数据)
     *
     * @param status  返回状态
     * @param message 返回消息
     */
    public RestfulResult(Status status, String message, Object data) {
        put(CODE, RestConst.HttpConst.OK.getCode());
        put(STATUS, status.getValue());
        if (message != null) {
            put(MESSAGE, message);
        }
        if (data != null) {
            put(DATA, data);
        }

    }


    /**
     * 获得 请求状态Code.
     *
     * @return 请求状态Code
     */
    public RestConst.RestEnum getCode() {
        return (RestConst.RestEnum) (get(CODE) == null ? null : get(CODE));
    }

    /**
     * 设定 请求状态Code.
     *
     * @param code 请求状态Code
     * @return RestResult
     */
    public RestfulResult setCode(RestConst.RestEnum code) {
        put(CODE, code.getCode());
        return this;
    }

    /**
     * 获得 status.
     *
     * @return 返回状态 status
     */
    public boolean getStatus() {
        return (boolean) get(STATUS);
    }

    /**
     * 设定 status.
     *
     * @param status 返回状态
     * @return RestResult
     */
    public RestfulResult setStatus(Status status) {
        put(STATUS, status.getValue());
        return this;
    }

    /**
     * 获得 message.
     *
     * @return 返回消息 message
     */
    public Object getMessage() {
        return get(MESSAGE);
    }

    /**
     * 设定 message.
     *
     * @param message 返回消息
     * @return the message
     */
    public RestfulResult setMessage(Object message) {
        put(MESSAGE, message);
        return this;
    }

    /**
     * 获得 data.
     *
     * @return 返回数据 data
     */
    public Object getData() {
        return get(DATA);
    }

    /**
     * 设定 data.
     *
     * @param data 返回数据
     * @return RestResult
     */
    public RestfulResult setData(Object data) {
        put(DATA, data);
        return this;
    }

    /**
     * 设定除预设的自动外的扩展字段.
     *
     * @param key     the key
     * @param extData the ext data
     * @return RestResult
     */
    public RestfulResult setExtData(String key, Object extData) {
        put(key, extData);
        return this;
    }

    /**
     * 获得设定扩展字段.
     *
     * @param key the key
     * @return the ext data
     */
    public Object getExtData(String key) {
        return get(key);
    }

    /**
     * 枚举 Status.
     */
    public enum Status {
        /**
         * 操作成功.
         */
        SUCCESS(true),
        /**
         * 操作失败.
         */
        FAILURE(false);

        boolean value;

        /**
         * 构造 Status 的实例.
         *
         * @param value the value
         */
        Status(boolean value) {
            this.value = value;
        }

        /**
         * 获得 value.
         *
         * @return the value
         */
        public boolean getValue() {
            return this.value;
        }
    }

}