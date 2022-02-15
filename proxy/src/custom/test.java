package custom;

import jdk.JDKProxy;
import jdk.Person;
import jdk.QYQ;

public class test {

    public static void main(String[] args) throws Exception {
        Person jdkProxy = (Person) new Custom().getInstance(new QYQ());
    }
}
