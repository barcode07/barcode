import * as IL from "./style";
import { v4 as uuidv4 } from "uuid";

const menu = [{ title: "Boost" }, { title: "친구" }];

export default function InnerLeftSideBarPresenter() {
  return (
    <IL.HTML>
      <IL.Header>
        <IL.InnerText placeholder="대화찾기 또는 시작하기" />
      </IL.Header>
      <IL.Body>
        {menu.map((el: { title: string }) => (
          <IL.BodyItemBox key={uuidv4()}>
            <IL.BodyItem>{el.title}</IL.BodyItem>
          </IL.BodyItemBox>
        ))}
      </IL.Body>
    </IL.HTML>
  );
}
