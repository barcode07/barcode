import * as OS from "./style";
import { v4 as uuid4 } from "uuid";

interface IOutSideBarPProps {
  dummy: string[];
  onClickMoveToMain: () => void;
  onClickMoveToChannel: () => void;
}

export default function OutSideBarPresenter(props: IOutSideBarPProps) {
  return (
    <OS.HTML>
      <OS.Header onClick={props.onClickMoveToMain}>아웃사이드바 헤더</OS.Header>
      <OS.Body>
        {props.dummy.map((el) => (
          <OS.ItemBox key={uuid4()}>
            {/* <OS.Bar /> */}
            <OS.example onClick={props.onClickMoveToChannel}>{el}</OS.example>
          </OS.ItemBox>
        ))}
      </OS.Body>
    </OS.HTML>
  );
}
