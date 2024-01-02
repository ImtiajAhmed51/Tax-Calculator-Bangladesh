package imtiaj.restController;


import imtiaj.model.Tax;
import imtiaj.service.TaxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxRestController {

    private TaxService taxService;

    public TaxRestController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/tax")
    public String createTax(@RequestBody Tax tax) {
        taxService.create(tax);
        return "Successful Insert";
    }

    @PutMapping("/{id}")
    public String updateTax(@PathVariable("id") int id, @RequestBody Tax tax) {

        taxService.edit(tax);
        return "Successful Update";
    }

    //gett all user
    @GetMapping("/tax")
    public List<Tax> getTaxs() {
        return taxService.getAll();
    }

    @GetMapping("/tax/{id}")
    public Tax infoTax(@PathVariable("id") int id) {
        return taxService.get(id);
    }

    @DeleteMapping("/tax/{id}")
    public String deleteTax(@PathVariable("id") int id) {
        taxService.delete(id);
        return "Successful";
    }


}