import com.sh.admin.item.model.dto.ItemDto;
import com.sh.admin.item.model.dto.SaleStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCommandService {

    public final ItemMapper itemMapper;

//나경작업시작
    public boolean updateSaleStatus(Long itemId) {
        ItemDto item = itemMapper.findById(itemId); // id로 해당되는 객체 찾기
        // 해당되는 객체가 null이 아니고 saleStatus가 품절일 경우 Status를 판매중지로 바꾼다
        if (item != null && SaleStatus.품절.equals(item.getSaleStatus())) {
            int updatedRows = itemMapper.updateSaleStatus(itemId);
            if (updatedRows == 1) {
                return true;
            }
        }
        return false;
    }
//    나경작업끝
}
