package Common;

import Common.DataObjectToSend;
import Common.collectionInfo.StudyGroup;

import java.io.*;

    public class Serializer {

        public byte[] serializeDataObjectToSend(DataObjectToSend obj) {
            try {
                try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                    try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                        oos.writeObject(obj);
                        oos.flush();
                    }
                    return bos.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public byte[] serializeStudyGroup(StudyGroup obj) {
            try {
                try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                    try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                        oos.writeObject(obj);
                        oos.flush();
                    }
                    return bos.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public byte[] serializeString(String obj) {
            try {
                try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
                    try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                        oos.writeObject(obj);
                        oos.flush();
                    }
                    return bos.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public String deserializeString(byte[] bytes) {
            try {
                try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                    try(ObjectInputStream ois = new ObjectInputStream(bis)){
                        return (String) ois.readObject();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }


        public DataObjectToSend deserializeDataObjectToSend(byte[] bytes) {
            try {
                try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                    try(ObjectInputStream ois = new ObjectInputStream(bis)){
                        return (DataObjectToSend) ois.readObject();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        public StudyGroup deserializeStudyGroup(byte[] bytes) {
            try {
                try(ByteArrayInputStream bis = new ByteArrayInputStream(bytes)){
                    try(ObjectInputStream ois = new ObjectInputStream(bis)){
                        return (StudyGroup) ois.readObject();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
