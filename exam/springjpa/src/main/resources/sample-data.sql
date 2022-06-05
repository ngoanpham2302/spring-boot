-- Sample Data for Testing
-- student table
INSERT INTO student (id, name) VALUES (1, 'bob');
INSERT INTO student (id, name) VALUES (2, 'alice');
INSERT INTO student (id, name) VALUES (3, 'tom');
INSERT INTO student (id, name) VALUES (4, 'jane');
INSERT INTO student (id, name) VALUES (5, 'van');
INSERT INTO student (id, name) VALUES (6, 'long');

-- course table
INSERT INTO course (id, name) VALUES (1, 'math');
INSERT INTO course (id, name) VALUES (2, 'music');
INSERT INTO course (id, name) VALUES (3, 'history');

-- student_course table
INSERT INTO  student_course(student_id, course_id, score) VALUES (1, 1, 7);
INSERT INTO  student_course(student_id, course_id, score) VALUES (1, 2, 5);
INSERT INTO  student_course(student_id, course_id, score) VALUES (1, 3, 8);
INSERT INTO  student_course(student_id, course_id, score) VALUES (2, 1, 8);
INSERT INTO  student_course(student_id, course_id, score) VALUES (2, 2, 2);
INSERT INTO  student_course(student_id, course_id, score) VALUES (2, 3, 9);
INSERT INTO  student_course(student_id, course_id, score) VALUES (3, 1, 4);
INSERT INTO  student_course(student_id, course_id, score) VALUES (3, 3, 10);
INSERT INTO  student_course(student_id, course_id, score) VALUES (4, 2, 9);
INSERT INTO  student_course(student_id, course_id, score) VALUES (4, 3, 8);
INSERT INTO  student_course(student_id, course_id, score) VALUES (5, 1, 9);
INSERT INTO  student_course(student_id, course_id, score) VALUES (5, 2, 7);
INSERT INTO  student_course(student_id, course_id, score) VALUES (5, 3, 6);
INSERT INTO  student_course(student_id, course_id, score) VALUES (6, 1, 10);
INSERT INTO  student_course(student_id, course_id, score) VALUES (6, 2, 3);