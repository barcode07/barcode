import * as IL from "./style";
import { v4 as uuidv4 } from "uuid";

const menu = [{ title: "Boost" }, { title: "친구" }];

const list = [
  { name: "백승재" },
  { name: "이수경" },
  { name: "김선우" },
  { name: "정하일" },
];

export default function InnerLeftSideBarPresenter() {
  return (
    <IL.HTML>
      <IL.Header>
        <IL.InnerText placeholder="대화찾기 또는 시작하기" />
      </IL.Header>
      <IL.Body>
        {menu.map((el: { title: string }) => (
          <IL.BodyUpperItemBox key={uuidv4()}>
            <IL.BodyUpperItem>{el.title}</IL.BodyUpperItem>
          </IL.BodyUpperItemBox>
        ))}
        <IL.MessageMenu>
          <IL.MessageMenuText>Direct Message</IL.MessageMenuText>
          <IL.AddMessageIcon>+</IL.AddMessageIcon>
        </IL.MessageMenu>
        {list.map((el: { name: string }) => (
          <IL.BodyUpperItemBox key={uuidv4()}>
            <IL.BodyUnderItem>{el.name}</IL.BodyUnderItem>
          </IL.BodyUpperItemBox>
        ))}
      </IL.Body>
      <IL.Footer>푸터</IL.Footer>
    </IL.HTML>
  );
}
