const express = require("express");
const jwt = require("jsonwebtoken");
const { Domain, User, Post, Hashtag } = require("../models");
const { verifyToken, apiLimiter } = require("./middlewares");

const router = express.Router();

const cors = require("cors");
const url = require("url");

// 무조건 CORS를 허용
// router.get(
//   cors({
//     credentials: true,
//   })
// );

// Domain에 등록된 경우만 전송할 수 있도록 설정
router.use(async (req, res, next) => {
  // 현재 도멩ㅇㅇㅇㅇ인이
  const domain = await Domain.findOne({
    where: { host: url.parse(req.get("origin")).host },
  });
  if (domain) {
    cors({
      origin: req.get("origin"),
      credentials: true,
    })(req, res, next);
  } else {
    next();
  }
});

// 데이터를 리턴하는 요청 처리
router.get("/posts/my", apiLimiter, verifyToken, (req, res) => {
  Post.findAll({ where: { userId: req.decoded.id } })
    .then((posts) => {
      console.log(posts);
      res.json({ code: 200, payload: posts });
    })
    .catch((error) => {
      console.error(error);
      return res.status(500).json({
        code: 500,
        message: "서버 에러",
      });
    });
});

// 토큰 발급
router.post("/token", apiLimiter, async (req, res) => {
  const { clientSecret } = req.body;
  try {
    // 도메인 찾아오기
    const domain = await Domain.findOne({
      where: { clientSecret },
      include: {
        model: User,
        attribute: ["nick", "id"],
      },
    });
    if (!domain) {
      return res.status(401).json({
        code: 401,
        message: "등록되지 않은 도메인입니다.",
      });
    }
    // 토큰 생성
    const token = jwt.sign(
      {
        id: domain.User.id,
        nick: domain.User.nick,
      },
      process.env.JWT_SECRET,
      {
        expiresIn: "1m", // 유효기간
        issuer: "gyumin", //발급자
      }
    );

    return res.json({
      code: 200,
      message: "토큰이 발급되었습니다",
      token,
    });
  } catch (error) {
    console.error(error);
    return res.json(500).json({
      code: 500,
      message: "서버에러",
    });
  }
});
// 토큰을 확인하기 위한 처리
router.get("/test", apiLimiter, verifyToken, (req, res) => {
  res.json(req.decoded);
});

module.exports = router;
