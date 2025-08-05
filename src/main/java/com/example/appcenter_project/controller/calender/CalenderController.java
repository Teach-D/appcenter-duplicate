package com.example.appcenter_project.controller.calender;

import com.example.appcenter_project.dto.request.calender.RequestCalenderDto;
import com.example.appcenter_project.dto.response.calender.ResponseCalenderDto;
import com.example.appcenter_project.service.calender.CalenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/calenders")
public class CalenderController {

    private final CalenderService calenderService;

    @PostMapping
    public ResponseEntity<Void> saveCalender(@RequestBody RequestCalenderDto requestCalenderDto) {
        calenderService.saveCalender(requestCalenderDto);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseCalenderDto>> getAllCalenders() {
        return ResponseEntity.status(OK).body(calenderService.findAllCalenders());
    }

    @GetMapping("/{calenderId}")
    public ResponseEntity<ResponseCalenderDto> getCalender(@PathVariable Long calenderId) {
        return ResponseEntity.status(OK).body(calenderService.findCalender(calenderId));
    }

    @PutMapping("/{calenderId}")
    public ResponseEntity<Void> updateCalender(@PathVariable Long calenderId, @RequestBody RequestCalenderDto requestCalenderDto) {
        calenderService.updateCalender(calenderId, requestCalenderDto);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/{calenderId}")
    public ResponseEntity<Void> deleteCalender(@PathVariable Long calenderId) {
        calenderService.deleteCalender(calenderId);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
