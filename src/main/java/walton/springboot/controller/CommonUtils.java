package walton.springboot.controller;

import walton.springboot.constants.MessageConstants;
import walton.springboot.model.Employee;
import walton.springboot.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class CommonUtils implements MessageConstants {
    static EmployeeRepository employeeRepository;
    public static CommonResponse generateSuccessResponse(Object obj, String... message) {
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setData(obj);
        if (message.length > 1 && message[0] != null && message[1] != null) {
            response.setMessage(message[0]);
            response.setMessageBn(message[1]);
        }
        return response;
    }
    public static CommonResponse generateErrorResponse(Exception e) {
        CommonResponse response = new CommonResponse();
        response.setStatus(false);
        String msgType = getMessageType(e.getMessage());
        if(msgType.equals("uk") || msgType.equals("re")) {
            response.setMessage(DATA_ALRADY_EXISTS_MESSAGE);
            response.setMessageBn(DATA_ALRADY_EXISTS_MESSAGE_BN);
        }else if(msgType.equals("fk")) {
            response.setMessage(CHILD_RECORD_FOUND);
            response.setMessageBn(CHILD_RECORD_FOUND_BN);
        }else {
            response.setMessage(e.getMessage());
        }


        return response;
    }
    private static String getMessageType(String message) {
        System.out.println("12 > " + message);
        if(message != null && message.length() > 55) {
            return message.substring(52,54);
        }
        return "";
    }
    public static void setUpdateUserInfo(Object obj, Object obj2) {
        Employee entity = (Employee) obj;
        Employee data = (Employee) obj2;

        /* set previous entry User Info */
        entity.setId(data.getId());


        /* set other information */
        Long userId = entity.getId();
        Employee appUser = employeeRepository.findById(userId).get();
        entity.setId(appUser.getId());

    }
    public static PageRequest getPageRequest(int page, int size) {




        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        return pageRequest;
    }
}
