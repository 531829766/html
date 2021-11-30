package mapper;

import model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    public Admin findAdminById(int id);
    public  int insertAdmin(Admin admin);
    public Admin findAdminByIdName(String a_username);
    public void updateUserBalanceByUid(Admin admin);


}
