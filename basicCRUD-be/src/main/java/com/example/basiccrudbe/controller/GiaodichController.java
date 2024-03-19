package com.example.basiccrudbe.controller;
import com.example.basiccrudbe.dto.ThemGiaoDich;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.basiccrudbe.entity.Giaodich;
import com.example.basiccrudbe.service.GiaodichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/giaodich")
public class GiaodichController {

    @Autowired
    private GiaodichService giaodichService;

    @GetMapping("")
    public ResponseEntity<List<Giaodich>> getAllTrans(){
        try {
            List<Giaodich> allGiaodich = giaodichService.getAllTrans();

            if(!allGiaodich.isEmpty()){
                return ResponseEntity.ok(allGiaodich);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteTran(@PathVariable Long id){
        try {
            giaodichService.deleteById(id);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> addNewTransaction (@RequestBody ThemGiaoDich themgiaodich){
        try {
            giaodichService.addNewTransaction(themgiaodich);
            return ResponseEntity.ok("Thêm thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
