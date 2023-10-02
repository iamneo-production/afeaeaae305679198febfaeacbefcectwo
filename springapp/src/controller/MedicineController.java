

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private Map<Integer, Medicine> medicineMap = new HashMap<>();
    private int currentId = 1;

    
    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        medicine.setMedicineId(currentId++);
        medicineMap.put(medicine.getMedicineId(), medicine);
        return true;
    }

    
    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        if (medicineMap.containsKey(medicineId)) {
            Medicine existingMedicine = medicineMap.get(medicineId);
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            return existingMedicine;
        }
        return null; 
    }
}