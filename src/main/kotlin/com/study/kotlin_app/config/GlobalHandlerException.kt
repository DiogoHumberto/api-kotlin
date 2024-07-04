package com.study.kotlin_app.config

import com.study.kotlin_app.dto.ErrorView
import com.study.kotlin_app.exception.TopicNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalHandlerException {

    @ExceptionHandler(TopicNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFund(exception: TopicNotFoundException,
                      request: HttpServletRequest): ErrorView<String> {
        return ErrorView(
                status = HttpStatus.NOT_FOUND.value(),
                error = HttpStatus.NOT_FOUND.name,
                codeError = 0,
                message =  exception.message,
                path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
            exception: MethodArgumentNotValidException,
            request: HttpServletRequest
    ): ErrorView<HashMap<String, String?>> {
        val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
            e -> errorMessage.put(e.field, e.defaultMessage)
        }
        return ErrorView(
                status = HttpStatus.BAD_REQUEST.value(),
                error = HttpStatus.BAD_REQUEST.name,
                message = errorMessage,
                codeError = 1,
                path = request.servletPath
        )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleNotReadableError(
            exception: HttpMessageNotReadableException,
            request: HttpServletRequest
    ): ErrorView<String> {

        return ErrorView(
                status = HttpStatus.BAD_REQUEST.value(),
                error = HttpStatus.BAD_REQUEST.name,
                message = exception.localizedMessage,
                codeError = 2,
                path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
            exception: Exception,
            request: HttpServletRequest
    ): ErrorView<String> {
        return ErrorView(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error = HttpStatus.INTERNAL_SERVER_ERROR.name,
                codeError = 500,
                message = exception.message,
                path = request.servletPath
        )
    }


}