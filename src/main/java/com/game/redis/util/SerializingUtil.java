package com.game.redis.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ���ܼ���: ���л������࣬����byte[]��Object֮����໥ת��.
 */
public class SerializingUtil {
    
    private static Log logger = LogFactory.getLog(SerializingUtil.class);
    
    /**
     * ���ܼ���: ��ʵ��Bean�������л�����.
     * @param source ��ת����ʵ��
     * @return ת��֮����ֽ�����
     * @throws Exception
     */
    public static byte[] serialize(Object source) {
        ByteArrayOutputStream byteOut = null;
        ObjectOutputStream ObjOut = null;
        try {
            byteOut = new ByteArrayOutputStream();
            ObjOut = new ObjectOutputStream(byteOut);
            ObjOut.writeObject(source);
            ObjOut.flush();
        }
        catch (IOException e) {
            logger.error(source.getClass().getName()
                + " serialized error !", e);
        }
        finally {
            try {
                if (null != ObjOut) {
                    ObjOut.close();
                }
            }
            catch (IOException e) {
                ObjOut = null;
            }
        }
        return byteOut.toByteArray();
    }
    
    /**
     * ���ܼ���: ���ֽ����鷴���л�Ϊʵ��Bean.
     * @param source ��Ҫ���з����л����ֽ�����
     * @return �����л����ʵ��Bean
     * @throws Exception
     */
    public static Object deserialize(byte[] source) {
        ObjectInputStream ObjIn = null;
        Object retVal = null;
        try {
            ByteArrayInputStream byteIn = new ByteArrayInputStream(source);
            ObjIn = new ObjectInputStream(byteIn);
            retVal = ObjIn.readObject();
        }
        catch (Exception e) {
            logger.error("deserialized error  !", e);
        }
        finally {
            try {
                if(null != ObjIn) {
                    ObjIn.close();
                }
            }
            catch (IOException e) {
                ObjIn = null;
            }
        }
        return retVal;
    }
}

