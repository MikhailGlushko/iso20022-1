package net.toregard.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(
        targetNamespace = "http://toregard.net/orders",
        serviceName = "OrderServiceName",
        portName = "OrderServicePortName"
)
public interface OrderService {
    @WebResult(name = "Success")
    @WebMethod(operationName = "createOrder")
    boolean createOrder(OrderRequest orderRequest);
}
