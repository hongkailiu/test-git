package tk.hongkailiu.test.webapp.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService public interface MathServiceS {
    @WebMethod public boolean isOdd(@WebParam(name = "number") Integer number);
}
