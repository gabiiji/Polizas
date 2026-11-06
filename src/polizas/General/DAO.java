package polizas.General;

import java.util.ArrayList;
import java.util.List;

public abstract interface DAO {
    int create(Object obj);
    List read();
    int update(Object obj);
    int delete(Object obj);
    
}
