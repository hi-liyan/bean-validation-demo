package com.shiguangping.beanvalidationdemo.controller;

import com.alibaba.fastjson.JSON;
import com.shiguangping.beanvalidationdemo.common.RespResult;
import com.shiguangping.beanvalidationdemo.entity.User;
import com.shiguangping.beanvalidationdemo.enums.RespStatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    /**
     * {
     *     "id": "1001",
     *     "name": "李达康",
     *     "age": 45,
     *     "gender": 1,
     *     "bool1": true,
     *     "balance": 1,
     *     "birthday": "2021-7-1",
     *     "hobbies": [
     *         "吃饭",
     *         "睡觉"
     *     ],
     *     "mobile": "18599999999",
     *     "languages": [
     *         {
     *             "id": "01",
     *             "name": "Java"
     *         }
     *     ],
     *     "email": "111@1.com",
     *     "addr": "1"
     * }
     */
    @PostMapping("add")
    public ResponseEntity<RespResult> addUser(@RequestBody @Valid User user) {
        log.info("入参: {}", JSON.toJSONString(user));
        return new ResponseEntity<>(RespResult.build(RespStatusEnum.OK.getCode(), RespStatusEnum.OK.getDesc(), user), HttpStatus.OK);
    }
}
