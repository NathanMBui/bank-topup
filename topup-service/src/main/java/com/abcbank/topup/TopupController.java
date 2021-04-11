package com.abcbank.topup;

import com.abcbank.topup.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TopupController implements TopupApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExternalUrl externalUrl;

    @PostMapping(path = "/topup")
    @Override
    public TopupPurchaseResponse purchase(@Valid @RequestBody TopupPurchaseRequest request) {
        return restTemplate.postForObject(externalUrl.getPurchaseVoucherUrl(), request, TopupPurchaseResponse.class);
    }

    @GetMapping(path = "/topup")
    @Override
    public TopupGetVouchersResponse getVouchers(TopupGetVouchersRequest request) {
        return new TopupGetVouchersResponse();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
