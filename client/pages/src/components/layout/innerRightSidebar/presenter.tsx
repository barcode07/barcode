import * as IR from "./style";
import { v4 as uuid4 } from "uuid";

interface IRightSideBarProps {
  dummy: { name: string; member: string[] }[];
  serverName: string;
}

export default function InnerRightSideBarPresenter(props: IRightSideBarProps) {
  const memberList = props.dummy.filter((el) => el.name === props.serverName);
  return (
    <IR.HTML>
      <IR.Body>
        <IR.MemberList>
          {memberList[0].name === props.serverName ? (
            memberList[0].member.map((el) => (
              <IR.MemberName key={uuid4()}>{el}</IR.MemberName>
            ))
          ) : (
            <></>
          )}
        </IR.MemberList>
      </IR.Body>
    </IR.HTML>
  );
}
