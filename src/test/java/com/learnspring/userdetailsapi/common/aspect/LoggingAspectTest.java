//package com.learnspring.userdetailsapi.common.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.slf4j.Logger;
//
//import java.lang.reflect.Field;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class LoggingAspectTest {
//
//    @Mock
//    private ProceedingJoinPoint proceedingJoinPoint;
//
//    @Mock
//    private JoinPoint joinPoint;
//
//    @Mock
//    private Signature signature;
//
//    @Mock
//    private Logger logger;
//
//    @InjectMocks
//    private LoggingAspect loggingAspect;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        // Initialize the aspect and set the mocked logger using reflection
//        setLoggerField(loggingAspect, logger);
//
//        when(proceedingJoinPoint.getSignature()).thenReturn(signature);
//        when(joinPoint.getSignature()).thenReturn(signature);
//        when(signature.getDeclaringTypeName()).thenReturn("com.learnspring.userdetailsapi.service.DummyService");
//        when(signature.getName()).thenReturn("dummyMethod");
//    }
//
//    private void setLoggerField(LoggingAspect aspect, Logger logger) throws Exception {
//        Field loggerField = LoggingAspect.class.getDeclaredField("LOGGER");
//        loggerField.setAccessible(true);
//        loggerField.set(aspect, logger);
//    }
//
//    @Test
//    public void testLogAfterThrowing() {
//        Throwable exception = new RuntimeException("Test Exception");
//
//        loggingAspect.logAfterThrowing(joinPoint, exception);
//
//        verify(logger).error("Exception in {}.{}() with cause = {}", "com.learnspring.userdetailsapi.service.DummyService",
//                "dummyMethod", exception.getCause() != null ? exception.getCause() : "NULL");
//    }
//
//    @Test
//    public void testLogAround() throws Throwable {
//        Object[] args = new Object[]{"arg1", "arg2"};
//        when(proceedingJoinPoint.getArgs()).thenReturn(args);
//        when(proceedingJoinPoint.proceed()).thenReturn("result");
//        when(logger.isDebugEnabled()).thenReturn(true);
//
//        Object result = loggingAspect.logAround(proceedingJoinPoint);
//
//        InOrder inOrder = inOrder(logger, proceedingJoinPoint);
//        inOrder.verify(logger).debug("Enter: {}.{}() with argument[s] = {}", "com.learnspring.userdetailsapi.service.DummyService",
//                "dummyMethod", Arrays.toString(args));
//        inOrder.verify(proceedingJoinPoint).proceed();
//        inOrder.verify(logger).debug("Exit: {}.{}() with result = {}", "com.learnspring.userdetailsapi.service.DummyService",
//                "dummyMethod", "result");
//
//        assertEquals("result", result);
//    }
//
//    @Test
//    public void testLogAroundWithException() throws Throwable {
//        Object[] args = new Object[]{"arg1", "arg2"};
//        when(proceedingJoinPoint.getArgs()).thenReturn(args);
//        when(proceedingJoinPoint.proceed()).thenThrow(new IllegalArgumentException("Test Exception"));
//        when(logger.isDebugEnabled()).thenReturn(true);
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            loggingAspect.logAround(proceedingJoinPoint);
//        });
//
//        assertEquals("Test Exception", exception.getMessage());
//
//        verify(logger).debug("Enter: {}.{}() with argument[s] = {}", "com.learnspring.userdetailsapi.service.DummyService",
//                "dummyMethod", Arrays.toString(args));
//        verify(logger).error("Illegal argument: {} in {}.{}()", Arrays.toString(args),
//                "com.learnspring.userdetailsapi.service.DummyService", "dummyMethod");
//    }
//}
