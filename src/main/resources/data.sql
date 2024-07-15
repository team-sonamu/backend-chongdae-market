INSERT INTO MEMBER (NICKNAME, CREATED_AT, UPDATED_AT)
VALUES ('dora', '2024-07-15 00:00:00', '2024-07-15 00:00:00');

INSERT INTO GROUP_PURCHASE (CURRENT_COUNT, IS_MANUAL_CONFIRMED, TOTAL_COUNT, TOTAL_PRICE, CREATED_AT, UPDATED_AT,
                            MEMBER_ID, DEADLINE, DESCRIPTION, MEETING_ADDRESS, MEETING_ADDRESS_DETAIL, PRODUCT_URL,
                            THUMBNAIL_URL, TITLE)
VALUES (3, false, 5, 10000, '2024-07-15 00:00:00', '2024-07-15 00:00:00',
        1, '2024-08-01 00:00:00', '고양이 인형 공동구매해요', '서울시 동작구 보라매로 100', '101동 101호', 'www.naver.com',
        'https://file.notion.so/f/f/a98aa686-1767-4142-a9a2-f7303fcfa347/650b4cc1-0d39-4cac-9b2a-4db2782e73ec/Untitled.png?id=d002f22a-15bf-486c-b267-1ddc5f6ee3b3&table=block&spaceId=a98aa686-1767-4142-a9a2-f7303fcfa347&expirationTimestamp=1721174400000&signature=gdrQVGGE6z67DvZqeg93wnTB3_Kk3mK8ZxME5jqnWNk&downloadName=Untitled.png',
        '공동구매해요');
