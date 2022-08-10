import * as OS from "./style";

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
          <OS.example onClick={props.onClickMoveToChannel}>{el}</OS.example>
        ))}
      </OS.Body>
    </OS.HTML>
  );
}
